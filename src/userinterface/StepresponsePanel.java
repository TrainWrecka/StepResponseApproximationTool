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

public class StepresponsePanel extends JPanel implements ActionListener{
	
	private Plots StepResponseplot=new Plots();
	
	
	private JLabel lbk =new JLabel("K:");
    private JLabel lbwp = new JLabel("\u03C9p:");
    private JLabel lbqp = new JLabel("qp:");
    private JLabel lbSigma=new JLabel("\u03C3:");
    private JLabel lbError=new JLabel("Error:");

	
	public StepresponsePanel(){
		super(new GridBagLayout());
		setSize(getPreferredSize());
		add(lbk, new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp,new GridBagConstraints( 0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp, new GridBagConstraints( 0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbSigma, new GridBagConstraints( 0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbError, new GridBagConstraints( 0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,  
				new Insets(0, 0, 0, 0), 0, 0));	
		
		setBorder(MyBorderFactory.createMyBorder("StepResponse"));
		
	}
	
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
