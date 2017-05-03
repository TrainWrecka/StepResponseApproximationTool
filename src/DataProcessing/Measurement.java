package DataProcessing;

import java.util.Arrays;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import com.sun.org.apache.xerces.internal.util.Status;

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

	public Measurement() {

	}

	public void setMeasurement(List<String[]> measurementList) {
		this.measurementList = measurementList;

		measurementData = convertList(measurementList);

		extractData();
		if (checkNoise() == false) {
			//cutData2();
		}
		//cutData = cutMeasurement(measurementData);
		//findData();

		plotData.removeStepresponseData();
		//plotData.setStepresponseData(cutData);
		//plotData.setStepresponseData(measurementData);
		if(input){
			plotData.setStepresponseData(timeData, inputData, stepData);
		} else {
			plotData.setStepresponseData(timeData, stepData);
		}
		
		StatusBar.showStatus("Number of points: " + timeData.length);
		StatusBar.showStatus("Last entry: " + timeData[timeData.length-1]);
		
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

	private void extractData() {
		input = false;
		
		int lengthrow = measurementData.length;
		int lengthcolumn = measurementData[0].length;
		
		

		switch (measurementData[0].length) {
			case 3:
				timeData = new double[measurementData.length];
				inputData = new double[measurementData.length];
				stepData = new double[measurementData.length];
				for (int i = 0; i < measurementData.length; i++) {
					timeData[i] = measurementData[i][0];
					inputData[i] = measurementData[i][1];
					stepData[i] = measurementData[i][2];
				}
				input = true;
				break;

			case 2:
				timeData = new double[measurementData.length];
				inputData = new double[1];
				stepData = new double[measurementData.length];
				for (int i = 0; i < measurementData.length; i++) {
					timeData[i] = measurementData[i][0];
					stepData[i] = measurementData[i][1];
				}
				break;

			case 0:
				StatusBar.showStatus("No data found");
				break;

			default:
				StatusBar.showStatus("Too many data columns");
				break;
		}
	}

	public boolean inputExisting() {
		return input;
	}

}
