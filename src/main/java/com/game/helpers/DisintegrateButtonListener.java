package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.game.model.GameModel;

public class DisintegrateButtonListener implements ActionListener {
	
	private GameModel gameModel;
	
	public DisintegrateButtonListener(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean disintegrateFlag = ((JCheckBox) (e.getSource())).isSelected();
		gameModel.getGameSprite().setDisintegrate(disintegrateFlag);
	}

}
