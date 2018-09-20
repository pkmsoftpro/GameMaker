package com.game.strategy;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.game.model.GameModel;
import com.game.model.Sprite;

public class ShootActionTest {
	
	private GameModel gameModel = new GameModel();
	private Sprite gameSprite = new Sprite();
	ShootAction shootAction = new ShootAction(gameModel);
	ActionInterface spy;
	Sprite sprite;
	
	@Before
	public void setUp(){
		Sprite e = new Sprite();
		spy = Mockito.spy(shootAction);
		e.setCollidable(true);
		e.setVisible(true);
	}
	
	@Test
	public void testCreateProjectiles() {
		Sprite e = new Sprite();
		e.setCollidable(true);
		e.setVisible(true);
		Rectangle currentSpriteCollider = gameSprite.createCollider();
		ArrayList<Sprite> playList = new ArrayList<Sprite>(gameModel.getSpriteList());
		e.createCollider();
		spy.performAction(e);
		Mockito.verify(spy, Mockito.times(1)).performAction(e);
	}
}
