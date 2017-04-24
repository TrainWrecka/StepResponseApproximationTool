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

public class OutputPanel extends JPanel implements ActionListener{
	
    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
	
	private JPanel DefaultPanel=new JPanel(new GridBagLayout());
	private JPanel DefaultStepresponsePanel=new StepresponsePanel();
	private JPanel DefaultZeroesPanel=new ZeroesPanel();
	private JPanel DefaultErrorPanel=new ErrorPanel();
	private JPanel DefaultVariablePanel=new VariablePanel();
	private JPanel StepresponsePanel=new StepresponsePanel();
	private JPanel ZeroesPanel=new ZeroesPanel();
	private JPanel ErrorPanel=new ErrorPanel();
    

	
	public OutputPanel(){
		super(new GridBagLayout());
		
		
		DefaultPanel.add(DefaultStepresponsePanel, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(DefaultZeroesPanel, new GridBagConstraints( 1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(DefaultErrorPanel, new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(DefaultVariablePanel, new GridBagConstraints( 1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		
		tabpane.addTab("Default", DefaultPanel);
		tabpane.addTab("StepresponsePanel", StepresponsePanel);
		tabpane.addTab("Zeroes", ZeroesPanel);
		tabpane.addTab("Error", ErrorPanel);
		
					
		
		
        add(tabpane,new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 
        		new Insets(0, 0, 0, 0), 0, 0));	
//        tabpane.setPreferredSize(new Dimension(400,200));
            
		}
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


