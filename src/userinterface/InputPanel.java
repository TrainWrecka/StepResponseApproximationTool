package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;


public class InputPanel extends JPanel implements ActionListener {
	// Buttons
	private JButton btLoad = new JButton("Load");
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
    private JLabel lbwq1 = new JLabel("\u03C9q1:");
    private JLabel lbwp2 = new JLabel("\u03C9p2:");
    private JLabel lbwq2 = new JLabel("\u03C9q2:");
    private JLabel lbwp3 = new JLabel("\u03C9p3:");
    private JLabel lbwq3 = new JLabel("\u03C9q3:");
    private JLabel lbwp4 = new JLabel("\u03C9p4:");
    private JLabel lbwq4 = new JLabel("\u03C9q4:");
    private JLabel lbwp5 = new JLabel("\u03C9p5:");
    private JLabel lbwq5 = new JLabel("\u03C9q5:");
//    private JLabel lbwp6 = new JLabel("\u03C9p6:");
//    private JLabel lbwq6 = new JLabel("\u03C9q6:");
//    private JLabel lbwp7 = new JLabel("\u03C9p7:");
//    private JLabel lbwq7 = new JLabel("\u03C9q7:");
//    private JLabel lbwp8 = new JLabel("\u03C9p8:");
//    private JLabel lbwq8 = new JLabel("\u03C9q8:");
//    private JLabel lbwp9 = new JLabel("\u03C9p9:");
//    private JLabel lbwq9 = new JLabel("\u03C9q9:");
//    private JLabel lbwp10 = new JLabel("\u03C9p10:");
//    private JLabel lbwq10 = new JLabel("\u03C9q10:");
    private JLabel lbSigma=new JLabel("\u03C3:");
    // Textfields
    private JTextField tfwp1 = new JTextField();
    private JTextField tfwq1 = new JTextField();
    private JTextField tfwp2 = new JTextField();
    private JTextField tfwq2 = new JTextField();
    private JTextField tfwp3 = new JTextField();
    private JTextField tfwq3 = new JTextField();
    private JTextField tfwp4 = new JTextField();
    private JTextField tfwq4 = new JTextField();
    private JTextField tfwp5 = new JTextField();
    private JTextField tfwq5 = new JTextField();
//    private JTextField tfwp6 = new JTextField();
//    private JTextField tfwq6 = new JTextField();
//    private JTextField tfwp7 = new JTextField();
//    private JTextField tfwq7 = new JTextField();
//    private JTextField tfwp8 = new JTextField();
//    private JTextField tfwq8 = new JTextField();
//    private JTextField tfwp9 = new JTextField();
//    private JTextField tfwq9 = new JTextField();
//    private JTextField tfwp10 = new JTextField();
//    private JTextField tfwq10 = new JTextField();
    private JTextField tfSigma=new JTextField();
    
	public InputPanel(){
		super(new GridBagLayout());
		// create Buttongroup
		gruppeAuto_Manual.add(rbtAuto);
		gruppeAuto_Manual.add(rbtManual);
		// add Buttons to Panel
		add(btLoad,new GridBagConstraints
				( 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 10, 0, 10), 0, 0));
		add(rbtAuto,new GridBagConstraints( 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 10, 0, 10), 0, 0));
		add(rbtManual,new GridBagConstraints( 0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 10, 0, 10), 0, 0));
		// add Labels to Panel	
		add(lbOrdnung,new GridBagConstraints( 0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(0, 10, 0, 0), 0, 0));
		add(lbwp1,new GridBagConstraints( 0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwq1,new GridBagConstraints( 0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwp2,new GridBagConstraints( 0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwq2,new GridBagConstraints( 0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwp3,new GridBagConstraints( 0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwq3,new GridBagConstraints( 0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwp4,new GridBagConstraints( 0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwq4,new GridBagConstraints( 0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwp5,new GridBagConstraints( 0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
		add(lbwq5,new GridBagConstraints( 0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwp6,new GridBagConstraints( 0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwq6,new GridBagConstraints( 0, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwp7,new GridBagConstraints( 0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwq7,new GridBagConstraints( 0, 17, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwp8,new GridBagConstraints( 0, 18, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwq8,new GridBagConstraints( 0, 19, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwp9,new GridBagConstraints( 0, 20, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwq9,new GridBagConstraints( 0, 21, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwp10,new GridBagConstraints( 0, 22, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
//		add(lbwq10,new GridBagConstraints( 0, 23, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
//				new Insets(10, 0, 0, 10), 0, 0));
		// add Combobox
		cbOrdnungsauswahl.setPreferredSize(new Dimension(50,20));
		add(cbOrdnungsauswahl,new GridBagConstraints( 1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  
				new Insets(10, 0, 0, 0), 0, 0));

		
		
		
	}
	


	public void update(Observable obs, Object obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
