package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.game.model.GameModel;
import com.game.strategy.ActionInterface;
import com.game.strategy.AutomoveAction;
import com.game.strategy.DisappearAction;
import com.game.strategy.PlayermoveAction;

public class ActionButtonListener implements ActionListener {
	
	private static Logger actionLog = Logger.getLogger("actionLogger");
	
	private GameModel gameModel;
	
	public ActionButtonListener(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case Constants.AUTOMOVE:
			actionLog.info("Auto-Move selected");
			automoveInterface();
			break;
		case Constants.MOVE:
			actionLog.info("Move selected");
			playermoveInterface();
			break;
		case Constants.BLOWUP:
			actionLog.info("Disappear selected");
			disappearInterface();
			break;
		}
		
	}
	
	public void automoveInterface(){
		ActionInterface autoMoveInterface = new AutomoveAction(gameModel);
		gameModel.getGameSprite().setActionInterface(autoMoveInterface);
	}
	
	public void playermoveInterface(){
		ActionInterface playermoveInterface = new PlayermoveAction();
		gameModel.getGameSprite().setActionInterface(playermoveInterface);
	}
	
	public void disappearInterface(){
		ActionInterface disappearInterface = new DisappearAction(gameModel);
		gameModel.getGameSprite().setActionInterface(disappearInterface);
	}

}
