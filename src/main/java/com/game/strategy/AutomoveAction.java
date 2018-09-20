package com.game.strategy;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import com.game.model.GameModel;
import com.game.model.Sprite;

public class AutomoveAction implements ActionInterface, Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private GameModel gameModel;
	
	public AutomoveAction(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void performAction(Sprite gameSprite) {
		
		Rectangle currentSpriteCollider = gameSprite.createCollider();
		
		//Check if current sprite collides with any other sprite which is collidable and is visible
		ArrayList<Sprite> playList = new ArrayList<Sprite>(gameModel.getSpriteList());
		for (Sprite listSprite : playList){
			if(listSprite.isCollidable() && listSprite.isVisible()){
				Rectangle listSpriteCollider = listSprite.createCollider();
				if(listSpriteCollider.intersects(currentSpriteCollider) && !listSprite.equals(gameSprite)){
					gameSprite.setVel_X(-gameSprite.getVel_X());
					gameSprite.setVel_Y(-gameSprite.getVel_Y());
					if(listSprite.isDisappear()){
						listSprite.setActionInterface(new DisappearAction(gameModel));
						listSprite.getActionInterface().performAction(listSprite);
					}
				}
			}
		}
		
		if(!gameSprite.isProjectile()){
			gameSprite.checkBounds();
		}
		
		//If the sprite has automove set to horizontal then move horizontally
		if(gameSprite.isHorizontal()){
			gameSprite.setPosition_X(gameSprite.getPosition_X() + gameSprite.getVel_X());
		}
		
		
		//If the sprite has automove set to vertical then move vertically
		if(gameSprite.isVertical()){
			gameSprite.setPosition_Y(gameSprite.getPosition_Y() + gameSprite.getVel_Y());
		}
		
		if(gameSprite.isNoBounds()){
			gameSprite.setPosition_X(gameSprite.getPosition_X() + gameSprite.getVel_X());
		}
		//TODO Determine if Random is required or not. Horizontal and Vertical together will take care of Random
		
	}

}
