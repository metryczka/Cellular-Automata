package controller;

import gui.ArtPanel;
import gui.MainFrame;

public class Controller {
	private MainFrame mainFrame; 
	private ArtPanel panel;
	
	
	
	public Controller() {
		panel = new ArtPanel(new Rule(22));
		mainFrame =  new MainFrame();
		mainFrame.setContentPane(panel);
	}

}
