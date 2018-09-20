/**
 * 
 */
package com.game.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

import com.game.helpers.Constants;
import com.game.helpers.ResourcesLoader;
import com.game.strategy.ActionInterface;
import com.game.strategy.ShootAction;

/**
 * @author shubham
 *the parent sprite it will have the variables and business logic common to all sprite
 */
public class Sprite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	   
    // all sprites going to have a location on the screen
	private int position_X;
	private int position_Y;
	// all sprites are going to have an image
	private ImageIcon spriteImage;
	// all sprites are going to have a dimensions
	private int height;
	private int width;
	private int vel_X, vel_Y;
	private int keyCode;
	private ActionInterface actionInterface;
	private ShootAction shootAction;
	private boolean horizontal;
	private boolean vertical;
	private boolean random;
	private boolean noBounds;
	private boolean collidable;
	private boolean visible;
	private boolean shooter;
	private boolean projectile;
	private boolean disintegrate;
	private boolean disappear;
	  
	
	public Sprite() {
		this.position_X = Constants.DEFAULT_X;
		this.position_Y = Constants.DEFAULT_Y;
		this.spriteImage = new ImageIcon(ResourcesLoader.class.getClassLoader().getResource("Questionmark.png"));
		this.vel_X = Constants.MOVEMENT_AUTO_X;
		this.vel_Y = Constants.MOVEMENT_AUTO_Y;
		this.horizontal = false;
		this.vertical = false;
		this.random = false;
		this.noBounds = false;
		this.collidable = false;
		this.shooter = false;
		this.visible = true;
		this.projectile = false;
		this.disintegrate = false;
		this.disappear = false;
		this.keyCode = Constants.DEFAULT_KEY;
	}
	
	public Sprite(Sprite sprite){
		this.position_X = sprite.position_X;
		this.position_Y = sprite.position_Y;
		this.spriteImage = sprite.spriteImage;
		this.vel_X = sprite.vel_X;
		this.vel_Y = sprite.vel_Y;
		this.actionInterface = sprite.actionInterface;
		this.horizontal = sprite.horizontal;
		this.vertical = sprite.vertical;
		this.random = sprite.random;
		this.noBounds = sprite.noBounds;
		this.collidable = sprite.collidable;
		this.visible = sprite.visible;
		this.keyCode = sprite.keyCode;
		this.shooter = sprite.shooter;
		this.projectile = sprite.projectile;
		this.disintegrate = sprite.disintegrate;
		this.disappear = sprite.disappear;
		this.shootAction = sprite.shootAction;
	}
	
	public void draw(Graphics g){
		Image tempImage = spriteImage.getImage();
		g.drawImage(tempImage, position_X, position_Y, null);
	}
	
	public Rectangle createCollider(){
		int width = spriteImage.getIconWidth();
		int height = spriteImage.getIconHeight();
		return new Rectangle(position_X, position_Y, width, height);
	}
	
	//TODO: Implement Checkbounds
	// Function to check for boundary of the game panel window
		public void checkBounds(){
			if(!isNoBounds())
			{
			if(position_Y <= 0){
				vel_Y = -vel_Y;
			}
			if(position_Y >= Constants.BOUND_HEIGHT){
				vel_Y = -vel_Y;
			}
			if(position_X >= Constants.BOUND_WIDTH  || position_X <= 0){
				vel_X = -vel_X;
			}
			}
			else
			{
				if(position_X >= Constants.BOUND_WIDTH){
					position_X = 0;
					//vel_X = -vel_X;
			}
			}
		}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getPosition_X() {
		return position_X;
	}

	public void setPosition_X(int position_X) {
		this.position_X = position_X;
	}

	public int getPosition_Y() {
		return position_Y;
	}

	public void setPosition_Y(int position_Y) {
		this.position_Y = position_Y;
	}

	public ImageIcon getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(ImageIcon spriteImage) {
		this.spriteImage = spriteImage;
	}

	public int getVel_X() {
		return vel_X;
	}

	public void setVel_X(int vel_X) {
		this.vel_X = vel_X;
	}

	public int getVel_Y() {
		return vel_Y;
	}

	public void setVel_Y(int vel_Y) {
		this.vel_Y = vel_Y;
	}

	public ActionInterface getActionInterface() {
		return actionInterface;
	}

	public void setActionInterface(ActionInterface actionInterface) {
		this.actionInterface = actionInterface;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public boolean isShooter() {
		return shooter;
	}

	public void setShooter(boolean shooter) {
		this.shooter = shooter;
	}

	public ShootAction getShootAction() {
		return shootAction;
	}

	public void setShootAction(ShootAction shootAction) {
		this.shootAction = shootAction;
	}

	public boolean isProjectile() {
		return projectile;
	}

	public void setProjectile(boolean projectile) {
		this.projectile = projectile;
	}

	public boolean isDisintegrate() {
		return disintegrate;
	}

	public void setDisintegrate(boolean disintegrate) {
		this.disintegrate = disintegrate;
	}

	public boolean isNoBounds() {
		return noBounds;
	}

	public void setNoBounds(boolean noBounds) {
		this.noBounds = noBounds;
	}
	
	public boolean isDisappear() {
		return disappear;
	}

	public void setDisappear(boolean disappear) {
		this.disappear = disappear;
	}
  
}
