package com.game.strategy;




import java.io.Serializable;

import com.game.model.Sprite;

public class CollisionEvent implements EventInterface, Serializable {
	
	private static final long serialVersionUID = 8L;
	private boolean collidable;

	public CollisionEvent(boolean collidable) {
		
		this.collidable = collidable;

	}

	@Override
	public void addEvent(Sprite gameSprite) {
		gameSprite.setCollidable(collidable);	
	}

}