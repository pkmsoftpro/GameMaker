package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.game.controller.GameController;
import com.game.model.GameModel;
import com.game.view.GameMakerPanel;
import com.game.view.GamePlayPanel;

public class GameButtonListenerTest {
	private GameModel gameModel = new GameModel();
	private GameMakerPanel gameMakerPanel = new GameMakerPanel();
	private GamePlayPanel gamePlayPanel = new GamePlayPanel(gameModel);
	private GameController gameController = new GameController(gameModel, gameMakerPanel, gamePlayPanel);
	ActionListener GameButtonListener = new GameButtonListener(gameController);
	ActionListener spy;
	ActionEvent e;
	
	@Before
	public void setUp() {
		String actionCommand = "Constants.DRAW";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy = Mockito.spy(GameButtonListener);
	}
	
	@Test
	public void testActionPerformedPLAY() {
		String actionCommand = "Constants.PLAY";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy.actionPerformed(e);
		Mockito.verify(spy, Mockito.times(1)).actionPerformed(e);
	}
}
