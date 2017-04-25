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

public class Plots extends JPanel {

	// create a dataset...
	XYSeriesCollection dataset = new XYSeriesCollection();
	Dimension screensize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/10, Toolkit.getDefaultToolkit().getScreenSize().height/7);


	public Plots(String type) {
		this.setLayout(new GridBagLayout());
		XYSeries series1 = new XYSeries("Planned");
		for (double i = 0.0; i < 10;) {
			series1.add(i, Math.cos(i));
			i = i + 0.1;
		}
		
		if(type == "Stepresponse"){
			createStepresponsePlot();
		}

		//    	XYSeries series1 = new XYSeries("Planned");
		//    	series1.add(1.0, 1.0);
		//    	series1.add(2.0, 4.0);
		//    	series1.add(3.0, -3.0);
		//    	series1.add(4.0, 5.0);
		//    	series1.add(5.0, 5.0);
		//    	series1.add(6.0, 7.0);
		//    	series1.add(7.0, 7.0);
		//    	series1.add(8.0, 8.0);

		//    	XYSeries series2 = new XYSeries("Delivered");
		//    	series2.add(9.0, 5.0);
		//    	series2.add(10.0, 7.0);
		//    	series2.add(11.0, 6.0);
		//    	series2.add(12.0, 8.0);
		//    	series2.add(13.0, -4.0);
		//    	series2.add(14.0, 4.0);
		//    	series2.add(15.0, 2.0);
		//    	series2.add(16.0, 1.0);
		//
		//    	XYSeries series3 = new XYSeries("Third");
		//    	series3.add(17.0, 4.0);
		//    	series3.add(18.0, 3.0);
		//    	series3.add(19.0, 2.0);
		//    	series3.add(20.0, -3.0);
		//    	series3.add(21.0, 6.0);
		//    	series3.add(22.0, 3.0);
		//    	series3.add(23.0, -4.0);
		//    	series3.add(24.0, 3.0);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		//    	dataset.addSeries(series2);
		//    	dataset.addSeries(series3);

		JFreeChart chart = ChartFactory.createXYLineChart("Line Chart Demo", "X", "Y", dataset);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinePaint(Color.black);

		ChartPanel chartPanel = new ChartPanel(chart);
//		chartPanel.setSize(screensize);

		add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

	}

	private void createStepresponsePlot() {
		JFreeChart chart = ChartFactory.createXYLineChart("Input Data", "t [s]", "U [V]", dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
//		chartPanel.setSize(screensize);
		
		add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
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

}
