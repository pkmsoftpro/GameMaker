package com.game.command;

import com.game.model.Sprite;
import com.game.strategy.ActionInterface;
import com.game.strategy.ShootAction;

public class SpriteCommand implements Command {
	
	private Sprite sprite;
	private int initX, initY;
	private ActionInterface actionInterface;
	private ShootAction shootAction;
	
	public SpriteCommand(Sprite sprite){
		this.sprite = sprite;
		this.initX = sprite.getPosition_X();
		this.initY = sprite.getPosition_Y();
		this.actionInterface = sprite.getActionInterface();
	}
	

	@Override
	public void execute() {
		actionInterface.performAction(sprite);
		if(sprite.isShooter()){
			shootAction = sprite.getShootAction();
			shootAction.performAction(sprite);
		}
	}

}
