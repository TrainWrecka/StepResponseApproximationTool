package DataProcessing;

import java.util.List;

public class Measurement {
	
	double[][] measurementData;
	
	public Measurement(){

	
	}
	
	public void setMeasurement(List<String[]> measurementList){		
		String[][] array = new String[measurementList.size()][];
		for (int i = 0; i < measurementList.size(); i++) {
			String[] row = measurementList.get(i);
		    array[i] = row;
		}
		
		measurementData = new double[array.length][2];
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < 2; j++){
				measurementData[i][j] = Double.parseDouble(array[i][j]);
			}
			
		}
		
	}
		
}
