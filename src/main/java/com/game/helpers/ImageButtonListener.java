package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import com.game.model.GameModel;
import com.game.view.GameMakerPanel;

public class ImageButtonListener implements ActionListener {
	
	private GameModel gameModel;
	private GameMakerPanel gameMakerPanel;
	
	private static Logger imageRadioLog = Logger.getLogger("imageRadioLogger");
	
	public ImageButtonListener(GameModel gameModel, GameMakerPanel gameMakerPanel){
		this.gameModel = gameModel;
		this.gameMakerPanel = gameMakerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameMakerPanel.setButtonEnabled();
		ImageIcon tempIcon = (ImageIcon)((JRadioButton) e.getSource()).getIcon();
		try{
			gameModel.getGameSprite().setSpriteImage(tempIcon);
			gameMakerPanel.getPreviewLabel().setIcon(tempIcon);
		}catch(NullPointerException error){
			imageRadioLog.error("Error in getting ImageIcon" + error.getLocalizedMessage());
		}
	}

}
