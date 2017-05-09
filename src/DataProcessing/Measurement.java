package DataProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.jfree.data.xy.XYSeries;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import matlabfunctions.Filter;
import matlabfunctions.FilterFactory;
import matlabfunctions.Filtfilt;
import matlabfunctions.Matlab;
import matlabfunctions.SVTools;
import userinterface.StatusBar;

public class Measurement {

	private double[][] measurementData;
	private double[][] cutData;
	private double[] inputData;
	private double[] timeData;
	private double[] stepData;

	private List<String[]> measurementList;

	private PlotData plotData = new PlotData();

	private boolean input = false;
	int unitStepLocation = 0;
	int stepResponseLocation = 0;

	double offset = 0;

	public Measurement() {

	}

	public void setMeasurement(List<String[]> measurementList) {
		this.measurementList = measurementList;

		measurementData = convertList(measurementList);

		extractData();
		if (input) {
			getStepLocation();
		} else {
			unitStepLocation = 1;
		}
		offset = getOffset();

		if (checkNoise() == false) {
			//cutData2();
			if (input) {
				getfirstSignalChange();
			}

			else {
				getfirstSignalChange();

			}

		}

		if (checkNoise() == true) {
			stepResponseLocation = 0;
			filtFunction();
			if (input) {
				removeDeadTimeNoise();
			} else {
				//getfirstSignalChange();
				removeDeadTimeNoise();

			}

			StatusBar.showStatus("Filtered Location: " + stepResponseLocation);
		}

		removeDeadTime();
		removeOffset(offset);

		normTime();

		//cutData = cutMeasurement(measurementData);
		//findData();

		plotData.removeStepresponseData();
		//plotData.setStepresponseData(cutData);
		//plotData.setStepresponseData(measurementData);
		if (input) {
			plotData.setStepresponseData(timeData, inputData, stepData);
		} else {
			plotData.setStepresponseData(timeData, stepData);
		}

		StatusBar.showStatus("Number of points: " + timeData.length);
		StatusBar.showStatus("Last entry: " + timeData[timeData.length - 1]);

	}

	public double[][] getMeasurement() {
		return measurementData;
	}

	public List<String[]> getMeasurementList() {
		return measurementList;
	}

	public XYSeries[] getStepresponseData() {
		return plotData.getStepresponseData();
	}

	/*
	 * converts 2D list of strings in 2d array of doubles
	 * uses string array for conversion
	 */
	private double[][] convertList(List<String[]> listString) {
		String[][] tempArrayString = new String[listString.size()][];
		for (int i = 0; i < listString.size(); i++) {
			String[] arrayRow = listString.get(i);
			tempArrayString[i] = arrayRow;
		}

		double[][] tempArrayDouble = new double[tempArrayString.length][tempArrayString[0].length];
		for (int i = 0; i < tempArrayString.length; i++) {
			for (int j = 0; j < tempArrayString[0].length; j++) {
				tempArrayDouble[i][j] = Double.parseDouble(tempArrayString[i][j]);
			}
		}

		return tempArrayDouble;
	}

	/*
	 * removes the unused data
	 */
	private double[][] cutMeasurement(double[][] measurementData) {
		double[][] cutData = null;

		if (measurementData[0].length != 3) {
			return cutData = measurementData;
		}

		int j = 0;
		for (int i = 0; i < measurementData.length; i++) {
			if (measurementData[i][1] != 0) {
				j = i;
				break;
			}
		}

		cutData = new double[measurementData.length - j][measurementData[0].length];

		for (int i = 0; i < cutData.length; i++) {
			cutData[i][0] = measurementData[i][0];
			cutData[i][1] = measurementData[j][1];
			cutData[i][2] = measurementData[j][2];
			j++;
		}

		return cutData;
	}

	/*
	 * returns true if a fluctuation exists in
	 * the first 20 elements of the step response Data
	 */
	private boolean checkNoise() {
		boolean flagUp = false;
		boolean flagDown = false;
		for (int i = 0; i < 20; i++) {
			if (stepData[i] > stepData[i + 1]) {
				flagUp = true;
			} else if (stepData[i] < stepData[i + 1]) {
				flagDown = true;
			}

			if ((flagUp & flagDown) == true) {
				StatusBar.showStatus("noise");
				return true;
			}
		}
		StatusBar.showStatus("no noise");
		return false;
	}

	/*
	 * if three columns are found, the format of the data is [time, input, output]
	 * if two columns are found, the format of the data is [time, output]
	 * else an error message is printed
	 * if an input column exist a flag gets set
	 */
	private void extractData() {
		input = false;

		if (measurementData[0].length == 3) {
			timeData = new double[measurementData.length];
			inputData = new double[measurementData.length];
			stepData = new double[measurementData.length];
			for (int i = 0; i < measurementData.length; i++) {
				timeData[i] = measurementData[i][0];
				inputData[i] = measurementData[i][1];
				stepData[i] = measurementData[i][2];
			}
			input = true;
		} else if (measurementData[0].length == 2) {
			timeData = new double[measurementData.length];
			inputData = new double[1];
			stepData = new double[measurementData.length];
			for (int i = 0; i < measurementData.length; i++) {
				timeData[i] = measurementData[i][0];
				stepData[i] = measurementData[i][1];
			}
		} else if (measurementData[0].length == 0) {
			StatusBar.showStatus("No data found");
		} else {
			StatusBar.showStatus("Too many data columns");
		}
	}

	/*
	 * gets the location where the step of 
	 * the unit data occurs
	 */
	private void getStepLocation() {
		unitStepLocation = 0;
		for (int i = 0; i < inputData.length; i++) {
			if (inputData[i] != inputData[i + 1]) {
				unitStepLocation = i;
				StatusBar.showStatus("Step location:" + Integer.toString(i));
				break;
			}
		}
	}

	/*
	 * returns the offset value
	 */
	private double getOffset() {
		double[] tempArray = Arrays.copyOfRange(stepData, 0, unitStepLocation);
		double offset = Matlab.mean(tempArray);
		StatusBar.showStatus("Offset:" + Double.toString(offset));
		return offset;
	}

	/*
	 * removes the offset from the signal
	 */
	private void removeOffset(double offset) {
		for (int i = 0; i < stepData.length; i++) {
			stepData[i] -= offset;
		}
	}

	/*
	 * removes the deadtime
	 */
	private void removeDeadTime() {
		if (stepResponseLocation < unitStepLocation) {
			stepResponseLocation = unitStepLocation;
		}
		double[] tempTime = new double[timeData.length - stepResponseLocation];
		double[] tempStep = new double[timeData.length - stepResponseLocation];

		tempTime = Arrays.copyOfRange(timeData, 0, timeData.length - stepResponseLocation);
		tempStep = Arrays.copyOfRange(stepData, stepResponseLocation, stepData.length);

		timeData = new double[tempTime.length];
		stepData = new double[tempStep.length];

		System.arraycopy(tempTime, 0, timeData, 0, tempTime.length);
		System.arraycopy(tempStep, 0, stepData, 0, tempStep.length);

		if (input) {
			double[] tempInput = new double[timeData.length - stepResponseLocation];
			tempInput = Arrays.copyOfRange(inputData, stepResponseLocation, inputData.length);
			inputData = new double[tempInput.length];
			System.arraycopy(tempInput, 0, inputData, 0, tempInput.length);
		}

	}

	/*
	 * returns if input value exists
	 */
	public boolean inputExisting() {
		return input;
	}

	/*
	 * filter function
	 */
	private void filtFunction() {
		int iN = 30;
		double[] yFiltered = null;
		double[] ySignal = null;

		double errorMax = 100.9e-3;

		ArrayList<Double> oneOne;
		ArrayList<Double> onesArrayList;
		ArrayList<Double> stepDataList = new ArrayList<Double>();
		for (double d : stepData)
			stepDataList.add(d);

		double noiseError = 1;
		ArrayList<Double> yFilteredList;

		oneOne = new ArrayList<Double>();
		oneOne.add(1.0);

		Double[] onesArray = new Double[iN];
		for (int i = 0; i < onesArray.length; i++) {
			onesArray[i] = 1.0 / iN;
		}

		while (Math.abs(noiseError) > errorMax) {

			onesArrayList = new ArrayList<Double>();
			for (double d : onesArray)
				onesArrayList.add(d);

			yFilteredList = Filtfilt.doFiltfilt(onesArrayList, oneOne, stepDataList);

			yFiltered = new double[yFilteredList.size()];

			ySignal = new double[yFilteredList.size()];

			for (int i = 0; i < yFilteredList.size(); i++) {
				ySignal[i] = yFilteredList.get(i);
				yFiltered[i] = (stepData[i] - yFilteredList.get(i)) / stepData[i];
			}

			noiseError = Math.abs(Matlab.mean(yFiltered));

			iN--;

			if (iN == 0) {
				StatusBar.showStatus("iN = 0");
				break;
			}
		}

		stepData = ySignal;
		StatusBar.showStatus("iN = " + iN);

	}

	/*
	 * get first signal change
	 * only applicable if no noise
	 */
	private void getfirstSignalChange() {
		for (int i = 0; i < stepData.length; i++) {
			if (stepData[i] != stepData[i + 1]) {
				stepResponseLocation = i;
				StatusBar.showStatus("Stepresponse location:" + Integer.toString(i));
				break;
			}
		}
	}

	/*
	 * removes deadtime if signal is 
	 * affected by noise
	 */
	private void removeDeadTimeNoise() {
		int start = 0;
		if (stepResponseLocation != 0) {
			start = stepResponseLocation;
		}

		double max = Matlab.max(stepData);

		for (int i = start; i < stepData.length; i++) {
			if (stepData[i] <= offset && stepData[i + 1] >= offset) {
				stepResponseLocation = i;
			} else if ((stepData[i] - offset) > ((max - offset) / 2)) {
				break;
			}
		}
		StatusBar.showStatus("Last offset intersection" + stepResponseLocation);

	}

	private void normTime() {
		double nor = (175 * 30);
		double tNorm = Matlab.norm(timeData);

		for (int i = 0; i < timeData.length; i++) {
			timeData[i] = timeData[i] / tNorm * nor;
		}
	}

	public static void fminsearchImpl() {
		int N = 2;
	
		
		Filter filt = FilterFactory.createButter(N, 1.0);
	
		Object[] resi = Matlab.residue(filt.B, filt.A);
				
		Complex[] R = (Complex[]) resi[0];
		Complex[] P = (Complex[]) resi[1];
		double K = (double) resi[2];
		
		//System.out.println(""+K);
		
		//optimset
		
		//awert
		
		//fminsearch
		
		
		
		
		//		%options für den fminsearch werden gesetzt
		//		options = optimset('MaxFunEvals', 200*length(P), 'MaxIter', 200*length(P),'TolFun',1e-24, 'TolX', 1e-24);
		//		
		//		[x0,k]=awert(N, P);
		//		X = fminsearch(@(x) FehlerFunktion(t, y_soll, x, N),x0,options);
		//		
		//		for n=(k)
		//		    [X, output] = fminsearch(@(x) FehlerFunktion(t, y_soll, x, N),X,options);
		//		e=FehlerFunktion(t, y_soll, x, N);
		//		 if (e<1e-15) %Bestimmt ab welchem Fehler man nicht mehr in den fminsearch muss. 
		//		     %Falls die Fehlerabweichung nicht erreicht wird, läuft er die forcierten 
		//		     %Werte des awertes ab.
		//		 break
		//		 end
		//		end

	}

	public static void main(String[] args) {
		fminsearchImpl();
	}
	
	private double errorFunction(double[] stepTarget, int N){
		double error = 0;
		
		//[y_ist, t] = schritt(x, t, N);
		
		for(int i = 0; i < stepTarget.length; i++){
			error += Math.pow(stepTarget[i] - stepData[i], 2);
		}
		
		return error;
	}

}
