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
	private Plots StepResponseplot=new Plots();
	
	private Plots Zeroesplot;
	private Plots Errorplot;
	
    JTabbedPane tabpane = new JTabbedPane
            (JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
	
    private JPanel Outputpanel=new JPanel();
	private JPanel Defaultpanel=new JPanel();
	private JPanel Stepresponsepanel=new JPanel();
	private JPanel Zeroespanel=new JPanel();	
	private JPanel Errorpanel=new JPanel();
	private JPanel Variablepanel=new JPanel(); 
	
	private JLabel lbk =new JLabel("K:");
    private JLabel lbwp = new JLabel("\u03C9p:");
    private JLabel lbwq = new JLabel("\u03C9q:");
    private JLabel lbSigma=new JLabel("\u03C3:");
    private JLabel lbError=new JLabel("Error:");
    

	
	public OutputPanel(){
		super(new GridBagLayout());
		add(Outputpanel,new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 10, 10, 10), 0, 0));
		
		Defaultpanel.add(Stepresponsepanel, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		Defaultpanel.add(Zeroespanel, new GridBagConstraints( 1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		Defaultpanel.add(Errorpanel, new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		Defaultpanel.add(Variablepanel, new GridBagConstraints( 1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		
		Variablepanel.add(lbk, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		Variablepanel.add(lbwp,new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		Variablepanel.add(lbwq, new GridBagConstraints( 0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		Variablepanel.add(lbSigma, new GridBagConstraints( 0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		Variablepanel.add(lbError, new GridBagConstraints( 0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));		
		
		tabpane.addTab("Default",Defaultpanel);
        tabpane.addTab("StepResponse", Stepresponsepanel);
        tabpane.addTab("Zeroes", Zeroespanel);
        tabpane.addTab("Error", Errorpanel);
        
        Outputpanel.add(tabpane);
	}
	
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
