package com.game.model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.game.strategy.PlayermoveAction;
import com.game.strategy.ShootAction;

public class GameModelTest {
	
	private GameModel gameModel = new GameModel();
	private Sprite gameSprite = gameModel.getGameSprite();
	private ArrayList<Sprite> spriteList = gameModel.getSpriteList();
	ShootAction shootAction = new ShootAction(gameModel);
	PlayermoveAction playermoveAction = new PlayermoveAction();
	ActionListener spy;
	private TimerReadout timerReadout = new TimerReadout();
	
	@Before
	public void setUp() {
		gameModel.setGameSprite(gameSprite);
		gameModel.setSpriteList(spriteList);
		shootAction.performAction(gameSprite);
		playermoveAction.performAction(gameSprite);
		gameModel.setTimerReadout(timerReadout);
		gameModel.startTimer();
		gameModel.stopTimer();
		gameModel.addSprite();
	}
	
	@Test
	public void testGetterAndSetter() {
		
		assertEquals("They are not equal", gameModel.getGameSprite(), gameSprite);
	
		assertEquals("They are not equal", gameModel.getSpriteList(), spriteList);
	}
}
