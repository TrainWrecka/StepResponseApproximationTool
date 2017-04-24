package DataProcessing;

import org.jfree.data.xy.XYSeries;

public class PlotData {
	
	private XYSeries[] seriesStepresponse = new XYSeries[2];
	
	public PlotData(){
	}
	
	public void setStepresponseData(double[][] stepresponseData){
		int index = 0;
		
		
		if(stepresponseData[0].length == 3){
			
			seriesStepresponse[0] = new XYSeries("Input");
			for (int i = 0; i < stepresponseData.length; i++) {
				seriesStepresponse[0].add(stepresponseData[i][0], stepresponseData[i][index+1]);
			}
			index = 1;
		}
		
		seriesStepresponse[index] = new XYSeries("Output");
		for (int i = 0; i < stepresponseData.length; i++) {
			seriesStepresponse[0].add(stepresponseData[i][0], stepresponseData[i][index+1]);
		}
	}
	
	public XYSeries[] getStepresponseData(){
		return seriesStepresponse;
	}
	
	public void removeStepresponseData(){
		if(seriesStepresponse != null){
			for(int i = 0; i < seriesStepresponse[0].getItemCount(); i++){
				seriesStepresponse[0].remove(i);
				seriesStepresponse[1].remove(i);
			}
		}	
	}
	
	
	public void setErrorData(){
		
	}
	
	public void setZeroesData(){
		
	}
	
}
