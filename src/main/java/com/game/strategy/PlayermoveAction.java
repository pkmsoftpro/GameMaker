package com.game.strategy;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import com.game.helpers.Constants;
import com.game.model.Sprite;

public class PlayermoveAction implements ActionInterface, Serializable {
	
	private static final long serialVersionUID = 5L;

	@Override
	public void performAction(Sprite gameSprite) {
		
		if(gameSprite.isHorizontal()){
			int keyCode = gameSprite.getKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				gameSprite.setPosition_X(gameSprite.getPosition_X() - Constants.MOVE_PLAYER_X);
				gameSprite.setKeyCode(Constants.DEFAULT_KEY);
			}
			if(keyCode == KeyEvent.VK_RIGHT){
				gameSprite.setPosition_X(gameSprite.getPosition_X() + Constants.MOVE_PLAYER_X);
				gameSprite.setKeyCode(Constants.DEFAULT_KEY);
			}
		}
		
		if(gameSprite.isVertical()){
			int keyCode = gameSprite.getKeyCode();
			if(keyCode == KeyEvent.VK_UP){
				gameSprite.setPosition_Y(gameSprite.getPosition_Y() - Constants.MOVE_PLAYER_Y);
				gameSprite.setKeyCode(Constants.DEFAULT_KEY);
			}
			if(keyCode == KeyEvent.VK_DOWN){
				gameSprite.setPosition_Y(gameSprite.getPosition_Y() + Constants.MOVE_PLAYER_Y);
				gameSprite.setKeyCode(Constants.DEFAULT_KEY);
			}
		}

	}

}
