package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayoutInfo;
import java.awt.Insets;
import JFreeChart.Plots;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OutputPanel extends JPanel implements ActionListener, ChangeListener{
	
    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
	
	private JPanel DefaultPanel=new JPanel(new GridBagLayout());
	private JPanel StepresponsePanel=new StepresponsePanel();
	private JPanel ZeroesPanel=new ZeroesPanel();
	private JPanel ErrorPanel=new ErrorPanel();
	private JPanel VariablePanel=new VariablePanel();
    

	
	public OutputPanel(){
		super(new GridBagLayout());
		
		tabpane.addTab("Default",DefaultPanel);
		tabpane.addTab("StepResponse", StepresponsePanel);
        tabpane.addTab("Zeroes", ZeroesPanel);
        tabpane.addTab("Error", ErrorPanel);
		
//		DefaultPanel.add(StepresponsePanel, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,  
//				new Insets(0, 0, 0, 0), 0, 0));
//		DefaultPanel.add(ZeroesPanel, new GridBagConstraints( 1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH,  
//				new Insets(0, 0, 0, 0), 0, 0));
//		DefaultPanel.add(ErrorPanel, new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH,  
//				new Insets(0, 0, 0, 0), 0, 0));
//		DefaultPanel.add(VariablePanel, new GridBagConstraints( 1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH,  
//				new Insets(0, 0, 0, 0), 0, 0));
//		add(DefaultPanel);
		tabpane.addChangeListener(this);
		
		
        add(tabpane,new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 
        		new Insets(0, 0, 0, 0), 0, 0));	
//        tabpane.setPreferredSize(new Dimension(400,200));
	}
	
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
			

	}

}
