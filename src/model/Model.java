package model;
import java.util.Observable;

import DataProcessing.Approximation;
import DataProcessing.Measurement;
import DataProcessing.PlotData;

public class Model extends Observable {
	private Approximation approximation;
	private PlotData plotData;
	private Measurement measurement;
	
	public Model() {}
	
}
