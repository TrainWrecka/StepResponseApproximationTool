package DataProcessing;

import java.util.List;

import org.jfree.data.xy.XYSeries;

public class Measurement {

	private double[][] measurementData;

	private List<String[]> measurementList;

	private PlotData plotData = new PlotData();

	public Measurement() {

	}

	public void setMeasurement(List<String[]> measurementList) {
		this.measurementList = measurementList;

		measurementData = convertList(measurementList);

		//plotData.removeStepresponseData();
		plotData.setStepresponseData(measurementData);
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

}
