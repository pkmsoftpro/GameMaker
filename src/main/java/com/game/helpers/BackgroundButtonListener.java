package com.game.helpers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.game.controller.GameController;
import com.game.view.GamePlayPanel;

public class BackgroundButtonListener implements ActionListener {
	
	private GameController gameController;
	private GamePlayPanel gamePlayPanel;
	private Image image;
	
	public BackgroundButtonListener(GameController gameController){
		this.gameController = gameController;
		this.gamePlayPanel = gameController.getGamePlayPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch(actionCommand) {
        case "Select Background":
        	break;
        
        case "Road":
        	this.image = new ImageIcon(ResourcesLoader.class.getClassLoader().getResource("road.png")).getImage();
        	gameController.getGameModel().setBackgroundImage(image);
        	gamePlayPanel.setBackGroundImage(image);
        	gamePlayPanel.revalidate();
        	gamePlayPanel.repaint();
            break;
            
        case "Space":
        	this.image = new ImageIcon(ResourcesLoader.class.getClassLoader().getResource("space.png")).getImage();
        	gameController.getGameModel().setBackgroundImage(image);
        	gamePlayPanel.setBackGroundImage(image);
        	gamePlayPanel.revalidate();
            gamePlayPanel.repaint();
    		break;

	}

}

}