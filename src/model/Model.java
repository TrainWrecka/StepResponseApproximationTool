package model;
import java.util.List;
import java.util.Observable;

import DataProcessing.Approximation;
import DataProcessing.Measurement;
import DataProcessing.PlotData;

public class Model extends Observable {
	private Approximation approximation;
	private PlotData plotData;
	private Measurement measurement = new Measurement();
	
	public Model() {}
	
	
	public void setMeasurement(List<String[]> measurementList){
		measurement.setMeasurement(measurementList);
	}
}
