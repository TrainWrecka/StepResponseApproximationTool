package JFreeChart;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class Plots{
    JFreeChart lineChart = ChartFactory.createLineChart(
       "Title",
       "Years","Number of Schools",
       new DefaultCategoryDataset( ),
       PlotOrientation.VERTICAL,
       true,true,false);
       
    ChartPanel chartPanel = new ChartPanel( lineChart );
   
    public Plots(){
    		
    }
}
