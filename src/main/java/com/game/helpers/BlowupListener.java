package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.game.model.GameModel;

public class BlowupListener implements ActionListener {
	
	private GameModel gameModel;
	
	public BlowupListener(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean blowupFlag = ((JCheckBox) (e.getSource())).isSelected();
		gameModel.getGameSprite().setDisappear(blowupFlag);
	}

}
