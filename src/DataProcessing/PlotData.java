package DataProcessing;

import org.jfree.data.xy.XYSeries;

public class PlotData {
	
	private XYSeries seriesStepresponse;
	
	public PlotData(){
	}
	
	public void setStepresponseData(double[][] stepresponseData){
		seriesStepresponse = new XYSeries("Input");
		for (int i = 0; i < stepresponseData.length; i++) {
			seriesStepresponse.add(stepresponseData[i][0], stepresponseData[i][1]);
		}
	}
	
	public XYSeries getStepresponseData(){
		return seriesStepresponse;
	}
	
	public void removeStepresponseData(){
		if(seriesStepresponse != null){
			for(int i = 0; i < seriesStepresponse.getItemCount(); i++){
				seriesStepresponse.remove(i);
			}
		}	
	}
	
	
	public void setErrorData(){
		
	}
	
	public void setZeroesData(){
		
	}
	
}
