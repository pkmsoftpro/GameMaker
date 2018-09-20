package com.game.strategy;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import com.game.command.ScoreCommand;
import com.game.helpers.Constants;
import com.game.helpers.ResourcesLoader;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.model.ScoreReadout;
import com.game.view.GamePlayPanel;

public class DisappearAction implements ActionInterface, Serializable {
	
	private static final long serialVersionUID = 4L;
	
	private GameModel gameModel;
	private Music soundEffect;
	private ScoreReadout tempScore;
	
	public DisappearAction(GameModel gameModel){
		this.gameModel = gameModel;
		this.soundEffect = new Music();
		this.tempScore = gameModel.getScoreReadout();
	}

	@Override
	public void performAction(Sprite gameSprite) {
		
		if(gameSprite.isCollidable() && gameSprite.isVisible()){
			
			Rectangle currentSpriteCollider = gameSprite.createCollider();
			
			ArrayList<Sprite> playList = new ArrayList<Sprite>(gameModel.getSpriteList());
			
			for (Sprite listSprite : playList){
				
				Rectangle listSpriteCollider = listSprite.createCollider();
				
				if(listSpriteCollider.intersects(currentSpriteCollider) && !listSprite.equals(gameSprite)){
					//TODO Logic for changing Velocity?
					
					soundEffect.stop();
					gameSprite.setVisible(false);
					updateScore();
					soundEffect.play(Constants.EXPLODE_SOUND);
					if(listSprite.isProjectile()){
						listSprite.setVisible(false);
						updateScore();
					}
					if(gameSprite.isDisintegrate()){
						createProjectiles(gameSprite);
						updateScore();
					}
				}
			}
		}
	}
	
	public void createProjectiles(Sprite sprite){
		ImageIcon tempIcon = sprite.getSpriteImage();
		Image tempImage = tempIcon.getImage();
		tempImage = tempImage.getScaledInstance(Constants.PROJECTILE_SIZE, Constants.PROJECTILE_SIZE, java.awt.Image.SCALE_SMOOTH);
		tempIcon = new ImageIcon(tempImage);
		gameModel.getSpriteList().add(newProjectile(sprite.getPosition_X(), sprite.getPosition_Y(), tempIcon));
		gameModel.getSpriteList().add(newProjectile(sprite.getPosition_X(), sprite.getPosition_Y(), tempIcon));
		gameModel.getSpriteList().add(newProjectile(sprite.getPosition_X(), sprite.getPosition_Y(), tempIcon));
	}
	
	public Sprite newProjectile(int posX, int posY, ImageIcon icon){
		Sprite projectile = new Sprite();
		projectile.setSpriteImage(icon);
		projectile.setCollidable(true);
		projectile.setVertical(true);
		projectile.setHorizontal(true);
		projectile.setDisappear(true);
		int random = ThreadLocalRandom.current().nextInt(Constants.MINDIS, Constants.MAXDIS);
		projectile.setPosition_X(posX+random);
		random = ThreadLocalRandom.current().nextInt(Constants.MINDIS, Constants.MAXDIS);
		projectile.setPosition_Y(posY+random);
		projectile.setProjectile(true);
		random = ThreadLocalRandom.current().nextInt(Constants.MINLIMIT, Constants.MAXLIMIT);
		projectile.setVel_X(random * Constants.PROJECTILE_SPEED);
		random = ThreadLocalRandom.current().nextInt(Constants.MINLIMIT, Constants.MAXLIMIT);
		projectile.setVel_Y(random * Constants.PROJECTILE_SPEED);
		projectile.setActionInterface(new AutomoveAction(gameModel));
		return projectile;
	}
	void updateScore(){	
		     ScoreCommand scoreCommand = new ScoreCommand(tempScore);
		     scoreCommand.execute();
		     gameModel.setScoreReadout(tempScore);
	       }

}
