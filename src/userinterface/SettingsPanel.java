package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

import com.opencsv.CSVReader;

import javafx.scene.control.RadioButton;
import model.Model;

import java.awt.*;
import java.util.List;
import java.util.Observable;

public class SettingsPanel extends JPanel implements ActionListener, ItemListener {

	private Controller controller;
	
	private JLabel lbLaguerre=new JLabel();
	private JLabel lbSimplexOptimizerRelative=new JLabel("Simplex Optimizer relative Optimum");
	private JLabel lbSimplexOptimizerAbsolute=new JLabel("Simplex Optimizer absolute Optimum"); 
	private JLabel lbMaxEval=new JLabel("Max Eval length");
	private JLabel lbNelderMeadSimplexSteps=new JLabel("Nelder Mead Simplex Steps");
	private JLabel lbFilterLength=new JLabel("Filter length");
	private JLabel lbFilterErrorMax=new JLabel("Filter Error Max");
	
	private JLabel lbFilterSignal=new JLabel("Filter Signal");
	private JLabel lbShowFilteredSignal=new JLabel("Show filtered Signal");
	
	
	
	
	private JTextField tfLaguerre=new JTextField();
	private JTextField tfSimplexOptimizerRelative=new JTextField();
	private JTextField tfSimplexOptimizerAbsolute=new JTextField();
	private JTextField tfMaxEval=new JTextField();
	private JTextField tfNelderMeadSimplexSteps=new JTextField();
	private JTextField tfFilterLength=new JTextField();
	private JTextField tfShowFilteredSignal=new JTextField();
	
	private JRadioButton rbtFilterSignalYes=new JRadioButton("Yes");
	private JRadioButton rbtFilterSignalNo=new JRadioButton("No");
	private JRadioButton rbtShowFilteredSignalYes=new JRadioButton("Yes");
	private JRadioButton rbtShowFilteredSignalNo=new JRadioButton("No");
	
	private ButtonGroup groupFilterSignal = new ButtonGroup();
	private ButtonGroup groupShowFilteredSignal=new ButtonGroup();
	
	
	
	public SettingsPanel() {
		super(new GridBagLayout());
		groupFilterSignal.add(rbtFilterSignalYes);
//		groupFilterSignal.add(FilterSignal);
		
		
		
		}
	
	
	
	private double[] stringToCoeff(String s) {
		String[] tokens = s.split("[, ]+");
		double[] z = new double[tokens.length];
		for (int i = 0; i < z.length; i++) {
			z[i] = Double.parseDouble(tokens[i]);
		}
		return z;
	}

	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	// Ausgrauen von allen Textfeldern, Labels, Ordnungsauswahl und Combobox bei entsprechender Aktion
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	// Ausgrauen von Textfeldern und Labels bei entsprechender Aktion
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		}
		
	}

	

