package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayoutInfo;
import java.awt.Insets;
import JFreeChart.Plots;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class OutputPanel extends JPanel implements ActionListener{
	
    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
	
	private JPanel DefaultPanel=new JPanel(new GridBagLayout());
	private JPanel StepresponsePanel=new StepresponsePanel();
	private JPanel ZeroesPanel=new ZeroesPanel();
	private JPanel ErrorPanel=new ErrorPanel();
	private JPanel VariablePanel=new VariablePanel();
    

	
	public OutputPanel(){
		super(new GridBagLayout());

		DefaultPanel.add(StepresponsePanel, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(ZeroesPanel, new GridBagConstraints( 1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(ErrorPanel, new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(VariablePanel, new GridBagConstraints( 1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));

		
		tabpane.addTab("Default",DefaultPanel);
        tabpane.addTab("StepResponse", StepresponsePanel);
        tabpane.addTab("Zeroes", ZeroesPanel);
        tabpane.addTab("Error", ErrorPanel);
        
        add(tabpane,new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 
        		new Insets(0, 0, 0, 0), 0, 0));	
	}
	
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
