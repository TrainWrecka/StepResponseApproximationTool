package userinterface;

import StepResponseApproximationTool.StepResponseApproximationTool;
import model.Model;



public class Controller {
	private Model model;
	private View view;
	private StepResponseApproximationTool mvcFramework;

	public Controller(Model model, StepResponseApproximationTool mvcFramework) {
		this.model = model;
		this.mvcFramework = mvcFramework;

	}
	
	public void setView(View view){
		this.view = view;
	}
}
