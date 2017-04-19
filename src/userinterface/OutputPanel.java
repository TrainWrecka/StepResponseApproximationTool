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
	private JPanel StepresponsePanel=new StepresponsePanel();
	private JPanel ZeroesPanel=new ZeroesPanel();
	private JPanel ErrorPanel=new ErrorPanel();
	private JPanel VariablePanel=new VariablePanel();
    

	
	public OutputPanel(){
		super(new GridBagLayout());
		
		
		DefaultPanel.add(StepresponsePanel, new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(ZeroesPanel, new GridBagConstraints( 1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(ErrorPanel, new GridBagConstraints( 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		DefaultPanel.add(VariablePanel, new GridBagConstraints( 1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		
		
		tabpane.addTab("Default",DefaultPanel);
		tabpane.addTab("StepResponse", new JPanel());
        tabpane.addTab("Zeroes", new JPanel());
        tabpane.addTab("Error", new JPanel());
		
		
		tabpane.addChangeListener(new ChangeListener() {
			
			
            public void stateChanged(ChangeEvent e) {
            	
            	
			if (e.getSource() instanceof JTabbedPane) {
	            JTabbedPane pane = (JTabbedPane) e.getSource();
				switch(pane.getSelectedIndex()){
				case 0:
					DefaultPanel.add(StepresponsePanel, new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,  
							new Insets(0, 0, 0, 0), 0, 0));
					DefaultPanel.add(ZeroesPanel, new GridBagConstraints( 1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE,  
							new Insets(0, 0, 0, 0), 0, 0));
					DefaultPanel.add(ErrorPanel, new GridBagConstraints( 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,  
							new Insets(0, 0, 0, 0), 0, 0));
					DefaultPanel.add(VariablePanel, new GridBagConstraints( 1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,  
							new Insets(0, 0, 0, 0), 0, 0));
					
					tabpane.addTab("Default",DefaultPanel);
					tabpane.addTab("StepResponse", new JPanel());
			        tabpane.addTab("Zeroes", new JPanel());
			        tabpane.addTab("Error", new JPanel());
					break;
				case 1:
					
					tabpane.addTab("Default",new JPanel());
					tabpane.addTab("StepResponse", StepresponsePanel);
			        tabpane.addTab("Zeroes", new JPanel());
			        tabpane.addTab("Error", new JPanel());
			        
			        break;
				}
			}
            }
		});
		
		
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


