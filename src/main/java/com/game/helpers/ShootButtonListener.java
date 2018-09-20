package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.game.model.GameModel;
import com.game.strategy.ShootAction;

public class ShootButtonListener implements ActionListener {
	
	private GameModel gameModel;
	private ShootAction shootAction;
	
	public ShootButtonListener(GameModel gameModel){
		this.gameModel = gameModel;
		this.shootAction = new ShootAction(gameModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean shooterFlag = ((JCheckBox) (e.getSource())).isSelected();
		gameModel.getGameSprite().setShooter(shooterFlag);
		gameModel.getGameSprite().setShootAction(shootAction);
	}

}
