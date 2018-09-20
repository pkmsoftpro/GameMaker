package com.game.model;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import com.game.strategy.ActionInterface;
import com.game.strategy.CollisionEvent;

public class SpriteTest {
	
	private Sprite sprite = new Sprite();
	int height = 0;
	int width = 0;
	int position_X = 500;
	int position_Y = 500;
	int vel_X = 10;
	int vel_Y = 10;
	ActionInterface actionInterface = null;
	boolean isHorizontal = false;
	boolean isVertical = false;
	boolean isRandom = false;
	boolean isCollidable = false;
	CollisionEvent collisionEvent = new CollisionEvent(isCollidable);
	boolean isVisible = true;
	int getKeyCode = 1000;
	boolean isShooter = false;
	boolean isProjectile = false;
	boolean isDisintegrate = false;
	
	@Before
	public void setUp() {
		sprite.setHeight(height);
		sprite.setWidth(width);
		sprite.setPosition_X(position_X);
		sprite.setPosition_Y(position_Y);
		sprite.setVel_X(vel_X);
		sprite.setVel_Y(vel_Y);
		sprite.setActionInterface(actionInterface);
		sprite.setHorizontal(isHorizontal);
		sprite.setVertical(isVertical);
		sprite.setRandom(isRandom);
		sprite.setCollidable(isCollidable);
		sprite.setVisible(isVisible);
		sprite.setKeyCode(getKeyCode);
		sprite.setShooter(isShooter);
		sprite.setProjectile(isProjectile);
		sprite.setDisintegrate(isDisintegrate);		
	}
	
	@Test
	public void testCreateCollider() {
		sprite.createCollider();
		Rectangle rectangle = new Rectangle(500, 500, 256, 256);
		assertEquals("They are not equal", sprite.createCollider(), rectangle);
	}
	
	@Test
	public void testTheGetterAndSetter() {
		assertEquals("They are not equal", sprite.getHeight(), height);
		
		assertEquals("They are not equal", sprite.getWidth(), width);
		
		assertEquals("They are not equal", sprite.getPosition_X(), position_X);
		
		assertEquals("They are not equal", sprite.getPosition_Y(), position_Y);
	
		assertEquals("They are not equal", sprite.getVel_X(), vel_X);
		
		assertEquals("They are not equal", sprite.getVel_Y(), vel_Y);
		
		assertEquals("They are not equal", sprite.getActionInterface(), actionInterface);
	
		assertEquals("They are not equal", sprite.isHorizontal(), isHorizontal);
		
		assertEquals("They are not equal", sprite.isVertical(), isVertical);
		
		assertEquals("They are not equal", sprite.isRandom(), isRandom);
		
		assertEquals("They are not equal", sprite.isCollidable(), isCollidable);
		
		assertEquals("They are not equal", sprite.isVisible(), isVisible);
		
		assertEquals("They are not equal", sprite.getKeyCode(), getKeyCode);
		
		assertEquals("They are not equal", sprite.isShooter(), isShooter);
		
		assertEquals("They are not equal", sprite.isProjectile(), isProjectile);
		
		assertEquals("They are not equal", sprite.isDisintegrate(), isDisintegrate);
	}

}
