package DataProcessing;

import org.jfree.data.xy.XYSeries;

public class PlotData {

	private XYSeries[] seriesStepresponse = new XYSeries[2];

	public PlotData() {}

	public void setStepresponseData(double[][] stepresponseData) {
		int index = 1;

		if (stepresponseData[0].length == 3) {

			seriesStepresponse[1] = new XYSeries("Input");
			for (int i = 0; i < stepresponseData.length; i++) {
				seriesStepresponse[1].add(stepresponseData[i][0], stepresponseData[i][index]);
			}

			index++;
		}

		seriesStepresponse[0] = new XYSeries("Output");
		for (int i = 0; i < stepresponseData.length; i++) {
			seriesStepresponse[0].add(stepresponseData[i][0], stepresponseData[i][index]);
		}
	}

	public void setStepresponseData(double[] timeData, double[] inputData, double[] stepData) {

		seriesStepresponse[0] = new XYSeries("Output");
		for (int i = 0; i < timeData.length; i++) {
			seriesStepresponse[0].add(timeData[i], stepData[i]);
		}

		seriesStepresponse[1] = new XYSeries("Input");
		for (int i = 0; i < timeData.length; i++) {
			seriesStepresponse[1].add(timeData[i], inputData[i]);
		}

	}

	public void setStepresponseData(double[] timeData, double[] stepData) {

		seriesStepresponse[0] = new XYSeries("Output");
		for (int i = 0; i < timeData.length; i++) {
			seriesStepresponse[0].add(timeData[i], stepData[i]);
		}
	}

	public XYSeries[] getStepresponseData() {
		return seriesStepresponse;
	}

	public void removeStepresponseData() {
		if (seriesStepresponse[0] != null) {
			seriesStepresponse[0].clear();
		}
		if (seriesStepresponse[1] != null) {
			seriesStepresponse[1].clear();
		}

	}

	public void setErrorData() {

	}

	public void setZeroesData() {

	}

}
