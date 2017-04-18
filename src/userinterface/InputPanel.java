package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;


public class InputPanel extends JPanel implements ActionListener, ItemListener {
	// Buttons
	public JButton btLoad = new JButton("Load");
	private JButton btRun = new JButton("Run");	
	private JRadioButton rbtAuto = new JRadioButton("Auto");
	private JRadioButton rbtManual = new JRadioButton("Manual");
	// Buttongroup
    private ButtonGroup gruppeAuto_Manual = new ButtonGroup();
    // JCombobox
    private String comboBoxListe[] = {"1","2","3","4","5","6","7","8","9","10"};
    private JComboBox cbOrdnungsauswahl = new JComboBox(comboBoxListe);
    // Labels
    private JLabel lbOrdnung = new JLabel("Ordnung:");
    private JLabel lbwp1 = new JLabel("\u03C9p1:");
    private JLabel lbqp1 = new JLabel("qp1:");
    private JLabel lbwp2 = new JLabel("\u03C9p2:");
    private JLabel lbqp2 = new JLabel("qp2:");
    private JLabel lbwp3 = new JLabel("\u03C9p3:");
    private JLabel lbqp3 = new JLabel("qp3:");
    private JLabel lbwp4 = new JLabel("\u03C9p4:");
    private JLabel lbqp4 = new JLabel("qp4:");
    private JLabel lbwp5 = new JLabel("\u03C9p5:");
    private JLabel lbqp5 = new JLabel("qp5:");
    private JLabel lbwp6 = new JLabel("\u03C9p6:");
    private JLabel lbqp6 = new JLabel("qp6:");
    private JLabel lbwp7 = new JLabel("\u03C9p7:");
    private JLabel lbqp7 = new JLabel("qp7:");
    private JLabel lbwp8 = new JLabel("\u03C9p8:");
    private JLabel lbqp8 = new JLabel("qp8:");
    private JLabel lbwp9 = new JLabel("\u03C9p9:");
    private JLabel lbqp9 = new JLabel("qp9:");
    private JLabel lbwp10 = new JLabel("\u03C9p10:");
    private JLabel lbqp10 = new JLabel("qp10:");
    private JLabel lbSigma=new JLabel("\u03C3:");
    // Textfields
    private JTextField tfwp1 = new JTextField();
    private JTextField tfqp1 = new JTextField();
    private JTextField tfwp2 = new JTextField();
    
    private JTextField tfqp2 = new JTextField();
    private JTextField tfwp3 = new JTextField();
    private JTextField tfqp3 = new JTextField();
    private JTextField tfwp4 = new JTextField();
    private JTextField tfqp4 = new JTextField();
    private JTextField tfwp5 = new JTextField();
    private JTextField tfqp5 = new JTextField();
    private JTextField tfwp6 = new JTextField();
    private JTextField tfqp6 = new JTextField();
    private JTextField tfwp7 = new JTextField();
    private JTextField tfqp7 = new JTextField();
    private JTextField tfwp8 = new JTextField();
    private JTextField tfqp8 = new JTextField();
    private JTextField tfwp9 = new JTextField();
    private JTextField tfqp9 = new JTextField();
    private JTextField tfwp10 = new JTextField();
    private JTextField tfqp10 = new JTextField();
    private JTextField tfSigma=new JTextField();
    
    
    private String Ordnung;
    
	public InputPanel(){
		super(new GridBagLayout());
		
		// create Buttongroup
		gruppeAuto_Manual.add(rbtAuto);
		gruppeAuto_Manual.add(rbtManual);
		
		// add Buttons to Panel
		add(btLoad,new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,  
				new Insets(10, 30, 0, 10), 0, 0));
		add(rbtAuto,new GridBagConstraints( 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,  
				new Insets(10, 30, 0, 10), 0, 0));
		add(rbtManual,new GridBagConstraints( 0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,  
				new Insets(10, 30, 0, 10), 0, 0));
		add(btRun,new GridBagConstraints( 0, 25, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,  
				new Insets(10, 30, 0, 10), 0, 0));
		
		// add Labels to Panel	
		add(lbOrdnung,new GridBagConstraints( 0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 30, 0, 0), 0, 0));
		add(lbwp1,new GridBagConstraints( 0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp1,new GridBagConstraints( 0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp2,new GridBagConstraints( 0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp2,new GridBagConstraints( 0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp3,new GridBagConstraints( 0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp3,new GridBagConstraints( 0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp4,new GridBagConstraints( 0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp4,new GridBagConstraints( 0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp5,new GridBagConstraints( 0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp5,new GridBagConstraints( 0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp6,new GridBagConstraints( 0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp6,new GridBagConstraints( 0, 15, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp7,new GridBagConstraints( 0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp7,new GridBagConstraints( 0, 17, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp8,new GridBagConstraints( 0, 18, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp8,new GridBagConstraints( 0, 19, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp9,new GridBagConstraints( 0, 20, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp9,new GridBagConstraints( 0, 21, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbwp10,new GridBagConstraints( 0, 22, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbqp10,new GridBagConstraints( 0, 23, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(lbSigma,new GridBagConstraints( 0, 24, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		
		
		// add Textfields to Panel
		add(tfwp1,new GridBagConstraints( 1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(tfqp1,new GridBagConstraints( 1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(tfwp2,new GridBagConstraints( 1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(tfqp2,new GridBagConstraints( 1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(tfwp3,new GridBagConstraints( 1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(0, 0, 0, 0), 0, 0));
		add(tfqp3,new GridBagConstraints( 1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp4,new GridBagConstraints( 1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp4,new GridBagConstraints( 1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp5,new GridBagConstraints( 1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp5,new GridBagConstraints( 1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp6,new GridBagConstraints( 1, 14, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp6,new GridBagConstraints( 1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp7,new GridBagConstraints( 1, 16, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp7,new GridBagConstraints( 1, 17, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp8,new GridBagConstraints( 1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp8,new GridBagConstraints( 1, 19, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp9,new GridBagConstraints( 1, 20, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp9,new GridBagConstraints( 1, 21, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfwp10,new GridBagConstraints( 1, 22, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(tfqp10,new GridBagConstraints( 1, 23, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));		
		add(tfSigma,new GridBagConstraints( 1, 24, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		
		// add Combobox
		cbOrdnungsauswahl.setPreferredSize(new Dimension(50,20));
		add(cbOrdnungsauswahl,new GridBagConstraints( 1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 0), 0, 0));
		
		
		cbOrdnungsauswahl.addItemListener(new java.awt.event.ItemListener(){
			public void itemStateChanged(java.awt.event.ItemEvent e)
			   {
			    Ordnung = null;
			    Ordnung = (String)cbOrdnungsauswahl.getSelectedItem();
			    switch(Ordnung){
			    case "1":
			    	lbwp1.setEnabled(true);
			    	lbqp1.setEnabled(true);
			    	tfwp1.setEditable(true);
			    	tfqp1.setEditable(true);
			    	lbwp2.setVisible(false);
			    	lbqp2.setVisible(false);
			    	lbwp3.setVisible(false);
			    	lbqp3.setVisible(false);
			    	lbwp4.setVisible(false);
			    	lbqp4.setVisible(false);
			    	lbwp5.setVisible(false);
			    	lbqp5.setVisible(false);
			    	lbwp6.setVisible(false);
			    	lbqp6.setVisible(false);
			    	lbwp7.setVisible(false);
			    	lbqp7.setVisible(false);
			    	lbwp8.setVisible(false);
			    	lbqp8.setVisible(false);
			    	lbwp9.setVisible(false);
			    	lbqp9.setVisible(false);
			    	lbwp10.setVisible(false);
			    	lbqp10.setVisible(false);
			    	lbSigma.setVisible(false);
			    	
			    	
			    }
			     }
			});
		
		
		
	}
	


	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cbOrdnungsauswahl){
			int Ordnung=(int) cbOrdnungsauswahl.getSelectedItem();
			for (int i=1;i<=Ordnung;i++){
				
			}
		}
		// TODO Auto-generated method stub
		
	}

}
