<<<<<<< HEAD
package userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.opencsv.CSVReader;

public class View extends JPanel implements Observer, ActionListener {

	private Controller controller;
	protected JButton btOk = new JButton("open file chooser pls press me thank");
	private InputPanel inputPanel;
	private OutputPanel outputPanel;
	private JFileChooser fileChooser = new JFileChooser();
	private File file;
	//private CSVReader reader;
	//private List<String[]> listString;

	public View(Controller controller) {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Topview "));
		this.controller = controller;
		add(btOk, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
		btOk.addActionListener(this);
	}

	public void update(Observable obs, Object obj) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	

		if (fileChooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
			
			CSVReader reader = null;
			List<String[]> measurementList = null;
			
			try {
				reader = new CSVReader(new FileReader(fileChooser.getSelectedFile()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				measurementList = reader.readAll();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			controller.setMeasurement(measurementList);
		}
	}
	


}
=======
 package userinterface;
 import java.awt.Dimension;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.Insets;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.File;
 import java.util.Observable;
 import java.util.Observer;
  
 import javax.swing.JButton;
 import javax.swing.JFileChooser;
 import javax.swing.JPanel;
  
 import JFreeChart.Plots;
 import javafx.stage.FileChooser;
  
  public class View extends JPanel implements Observer, ActionListener{
  	
  	
  	private Controller controller;
 	protected JButton btOk = new JButton("open file chooser pls press me thank");
  	private InputPanel inputPanel=new InputPanel();
  	private OutputPanel outputPanel = new OutputPanel();
 	private JFileChooser fileChooser = new JFileChooser();
 	private File filefile;	
  
  	public View(Controller controller) {
  		super(new GridBagLayout());
  		setBorder(MyBorderFactory.createMyBorder(" Topview "));
  		this.controller = controller;
//  		add(btOk, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
//  				new Insets(10, 10, 10, 10), 0, 0));
  		add(inputPanel,new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.VERTICAL,
  				new Insets(0, 0, 10, 10), 0, 0));
  		add(outputPanel,new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH,
  				new Insets(0, 0, 10, 10), 0, 0));
  		
   		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

 		btOk.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				
 				int result = fileChooser.showOpenDialog(getParent());
 				if (result == JFileChooser.APPROVE_OPTION) {
 					filefile = fileChooser.getSelectedFile();
 					String filename = filefile.getName();
 				}
 			}
 		});
  	}
  
  	public void update(Observable obs, Object obj) {}
  
  	@Override
  	public void actionPerformed(ActionEvent e) {
  		// TODO Auto-generated method stub	
  		
  	}
  
 }
>>>>>>> origin/master
