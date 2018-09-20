package com.game.helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.model.GameModel;
import com.game.model.Sprite;

public class UserKeyListener implements KeyListener {
	
	private GameModel gameModel;
	
	public UserKeyListener(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		for(Sprite sprite : gameModel.getSpriteList()){
			sprite.setKeyCode(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
