package userinterface;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.opencsv.CSVReader;

import JFreeChart.Plots;
import model.Model;

public class View extends JPanel implements Observer, ActionListener {

	private Controller controller;
	protected JButton btOk = new JButton("Open File");
	private InputPanel inputPanel;
	private OutputPanel outputPanel;
	private JFileChooser fileChooser = new JFileChooser();
	private File file;

	double[][] measurementData;

	XYSeriesCollection dataset = new XYSeriesCollection();

	public View(Controller controller) {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Topview "));
		this.controller = controller;
		add(btOk, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
		btOk.addActionListener(this);

		JFreeChart chart = ChartFactory.createXYLineChart("Input Data", "t [s]", "U [V]", dataset);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinePaint(Color.black);

		ChartPanel chartPanel = new ChartPanel(chart);

		add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;

		dataset.removeAllSeries();
		dataset.addSeries(model.getStepresponseData());
		
		StatusBar.showStatus("Data Set");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	

		if (fileChooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
			controller.setMeasurement(readCSV());
		}
	}

	/*
	 * reads a csv file
	 */
	private List<String[]> readCSV() {
		CSVReader reader = null;
		List<String[]> measurementList = null;

		try {
			reader = new CSVReader(new FileReader(fileChooser.getSelectedFile()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			measurementList = reader.readAll();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		StatusBar.showStatus(fileChooser.getSelectedFile().getName() + " loading...");

		return measurementList;
	}

}