package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayoutInfo;
import java.awt.Insets;
import java.awt.Toolkit;

import JFreeChart.Plots;
import model.Model;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OutputPanel extends JPanel implements ActionListener, ChangeListener {

	JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	
	private JPanel DefaultPanel = new JPanel(new GridBagLayout());

	private StepresponsePanel DefaultStepresponsePanel = new StepresponsePanel();
	private JPanel DefaultZeroesPanel = new ZeroesPanel();
	private JPanel DefaultErrorPanel = new ErrorPanel();
	private JPanel DefaultVariablePanel = new VariablePanel();

	private StepresponsePanel StepresponsePanel = new StepresponsePanel();
	private ZeroesPanel ZeroesPanel = new ZeroesPanel();
	private ErrorPanel ErrorPanel = new ErrorPanel();
	
	private JPanel TabStepresponsePanel=new JPanel(new GridBagLayout());
	private JPanel TabErrorPanel=new JPanel(new GridBagLayout());
	private JPanel TabZeroesPanel=new JPanel(new GridBagLayout());
	

	public OutputPanel() {
		super(new GridBagLayout());	
		
//		DefaultPanel.add(DefaultStepresponsePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
//				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//		
//		DefaultPanel.add(DefaultZeroesPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
//				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//		
//		DefaultPanel.add(DefaultErrorPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
//				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//		
//		DefaultPanel.add(DefaultVariablePanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
//				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		
		DefaultPanel.add(StepresponsePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		DefaultPanel.add(ZeroesPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		DefaultPanel.add(ErrorPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		DefaultPanel.add(DefaultVariablePanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		
//		tabpane.addTab("Default", DefaultPanel);
//		tabpane.addTab("StepresponsePanel", StepresponsePanel);
//		tabpane.addTab("Zeroes", ZeroesPanel);
//		tabpane.addTab("Error", ErrorPanel);
		
		
		tabpane.addTab("Default", DefaultPanel);
		tabpane.addTab("StepresponsePanel", TabStepresponsePanel);
		tabpane.addTab("Zeroes", TabZeroesPanel);
		tabpane.addTab("Error", TabErrorPanel);
		
		
		
		
	
		add(tabpane, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		
		tabpane.addChangeListener(this);
	}
	
	

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;

		DefaultStepresponsePanel.clearStepresponseData();
		StepresponsePanel.clearStepresponseData();
		/*if(model.getStepresponseData()[1] != null){
			StepresponsePanel.addStepresponseData(model.getStepresponseData()[1]);
		}*/
		
		DefaultStepresponsePanel.addStepresponseData(model.getStepresponseData()[0]);
		DefaultStepresponsePanel.addStepresponseData(model.getStepresponseData()[1]);
		StepresponsePanel.addStepresponseData(model.getStepresponseData()[0]);
		StepresponsePanel.addStepresponseData(model.getStepresponseData()[1]);
		
		/*
		dataset.removeAllSeries();
		dataset.addSeries(model.getStepresponseData()[0]);
		dataset.addSeries(model.getStepresponseData()[1]);
		StatusBar.showStatus("Data Set");*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        System.out.println("Tab changed to: " + sourceTabbedPane.getSelectedIndex());
        
        switch(index){
        case 0:
        	DefaultPanel.add(StepresponsePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
        	DefaultPanel.add(ZeroesPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
        	DefaultPanel.add(ErrorPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
        	DefaultPanel.add(DefaultVariablePanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        	break;
        case 1:
        	TabStepresponsePanel.add(StepresponsePanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        	break;
        case 2:
        	TabZeroesPanel.add(ZeroesPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        	break;
        case 3:
        	TabErrorPanel.add(ErrorPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
        			GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        	break;
        }
        
        
        
        
	}
}
