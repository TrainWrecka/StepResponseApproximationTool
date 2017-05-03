package DataProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import matlabfunctions.Filtfilt;
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
	int stepLocation = 0;

	public Measurement() {

	}

	public void setMeasurement(List<String[]> measurementList) {
		this.measurementList = measurementList;

		measurementData = convertList(measurementList);

		extractData();

		if (input) {
		//	getStepLocation();
		//	getOffset();
		}
		
		if(checkNoise() == true){
			filtFunction();
		}
		

		if (checkNoise() == false) {
			//cutData2();
		}
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

	private boolean checkNoise() {
		for (int i = 1; i < 20; i++) {
			if (stepData[i] != stepData[i - 1]) {
				StatusBar.showStatus("noise");
				return true;
			}
		}
		StatusBar.showStatus("no noise");
		return false;
	}

	void cutData2() {

		int j = 0;

		for (int i = 0; i < measurementData.length; i++) {
			if (measurementData[i][1] != 0) {
				j = i;
				StatusBar.showStatus("Step location:" + Integer.toString(i));
				break;
			}
		}

		j = 0;

		for (int i = 0; i < measurementData.length; i++) {
			if (measurementData[i][2] != 0) {
				j = i - 1;
				StatusBar
						.showStatus("index:" + Integer.toString(i - 1) + " data:" + Double.toString(measurementData[i - 1][2]));
				StatusBar.showStatus("index:" + Integer.toString(i) + " data:" + Double.toString(measurementData[i][2]));
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

	private void getStepLocation() {
		stepLocation = 0;
		for (int i = 0; i < inputData.length; i++) {
			if (inputData[i] != 0) {
				stepLocation = i - 1;
				StatusBar.showStatus("Step location:" + Integer.toString(i));
				break;
			}
		}
	}

	private void getOffset() {
		double[] tempArray = Arrays.copyOfRange(stepData, 0, stepLocation);
		double offset = mean(tempArray);
		StatusBar.showStatus("Offset:" + Double.toString(offset));
		removeOffset(offset);
		//double offset = mean(y(1:cut1));
	}

	private void removeOffset(double offset) {
		for (int i = 0; i < stepData.length; i++) {
			stepData[i] -= offset;
		}
	}

	public boolean inputExisting() {
		return input;
	}
	
	
	/*
	 * hoffentli chomi do i einere woche no druus...
	 */
	private void filtFunction() {
		//ArrayList<Double> stepDataList = Arrays.asList(stepData);
		//List<Double> list = new ArrayList<Double>(Arrays.asList(stepData));

		int iN = 30;
		double[] yFiltered = null;
		double[] ySignal = null;
		
		ArrayList<Double> oneOne; 
		ArrayList<Double> onesArrayList;
		ArrayList<Double> stepDataList = new ArrayList<Double>();
		for(double d : stepData) stepDataList.add(d);
		
		//Double[] doubleArray = ArrayUtils.toObject(stepData);
		//ArrayList<Double> stepDataList = Arrays.asList(doubleArray);
		
		double noiseError = 1;
		ArrayList<Double> yFilteredList;

		while (Math.abs(noiseError) > 1.9e-3) {
			Double[] onesArray = new Double[iN];
			

			oneOne = new ArrayList<Double>();
			oneOne.add(1.0);
			
			for (int i = 0; i < onesArray.length; i++) {
				onesArray[i] = 1.0 / iN;
				
			}
			
			onesArrayList =  new ArrayList<Double>();
			for(double d : onesArray) onesArrayList.add(d);

			
			
			yFilteredList = Filtfilt.doFiltfilt(onesArrayList, oneOne, stepDataList);

			yFiltered = new double[yFilteredList.size()];
			
			ySignal = new double[yFilteredList.size()];
			
			

			for (int i = 0; i < yFilteredList.size(); i++) {
				ySignal[i] = yFilteredList.get(i);
				yFiltered[i] = (stepData[i] - yFilteredList.get(i)) / stepData[i];
			}

			noiseError = mean(yFiltered);

			iN--;
			
			if(iN == 0){
				StatusBar.showStatus("iN = 0");
				break;
			}
		}
		
		inputData = ySignal;
		

	}

	private static double mean(double[] m) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i];
		}
		return sum / m.length;
	}

}
