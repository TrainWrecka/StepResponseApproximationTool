package JFreeChart;

import org.jfree.chart.ChartPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import userinterface.StatusBar;

public class ZeroesPlot extends JPanel{

	// create a dataset...
	XYSeriesCollection dataset = new XYSeriesCollection();

	public static ChartPanel ZeroesChartPanel;
	private static int count=0;
	
	public ZeroesPlot(String type) {
		this.setLayout(new GridBagLayout());
		XYSeries series3 = new XYSeries("Third");
    	series3.add(17.0, 4.0);
//    	series3.add(18.0, 3.0);
//    	series3.add(19.0, 2.0);
//    	series3.add(20.0, -3.0);
//    	series3.add(21.0, 6.0);
//    	series3.add(22.0, 3.0);
    	series3.add(23.0, -4.0);
    	series3.add(24.0, 3.0);
		
		XYSeriesCollection dataset1=new XYSeriesCollection();
		dataset1.addSeries(series3);
		
		
		
		
		
		
		JFreeChart chart = ChartFactory.createScatterPlot(type, "Real", "Imaginary", dataset1);
		ZeroesChartPanel = new ChartPanel(chart);
		add(ZeroesChartPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinePaint(Color.black);
	}
	
	
	
	public void addSeries(XYSeries series) {
		dataset.addSeries(series);
	}
	
	public void clearSeries(){
		dataset.removeAllSeries();
	}
	
	
    public static void zoomChartAxis(ChartPanel chartP, boolean increase)
    {              
        int width = chartP.getMaximumDrawWidth() - chartP.getMinimumDrawWidth();
        int height = chartP.getMaximumDrawHeight() - chartP.getMinimumDrawWidth();        
        if(increase){
        	if(count<6){
        		chartP.zoomInBoth(width/2, height/2);
        		count++;
        	}
        	else{
        		StatusBar.showStatus("Zoom in nicht m�glich");
        	}
        	
        }else{
        	if(count>0){
            chartP.zoomOutBoth(width/2, height/2);
            count--;
        	}
        	else{
        		StatusBar.showStatus("Zoom out nicht m�glich");
        	}
        }
	
    }
}
