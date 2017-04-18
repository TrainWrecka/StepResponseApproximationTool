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

public class ZeroesPanel extends JPanel implements ActionListener{
	
	
	private Plots Zeroesplot;
	
	public ZeroesPanel(){
		super(new GridBagLayout());
		
	}
	
	
	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
