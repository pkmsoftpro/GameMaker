package com.game.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.model.GameModel;
import com.game.view.GameFrame;
import com.game.view.GameMakerPanel;
import com.game.view.GamePlayPanel;

public class GameControllerTest {
	
	private GameModel gameModel = new GameModel();
	private GameMakerPanel gameMakerPanel = new GameMakerPanel();
	private GamePlayPanel gamePlayPanel = new GamePlayPanel(gameModel);
	private GameController gameController = new GameController(gameModel, gameMakerPanel, gamePlayPanel);
	
	@Test
	public void testGetterAndSetter() {
	
		assertEquals("They are not equal", gameController.isGamePlay(), false);
	
		assertEquals("They are not equal", gameController.getGameMakerPanel(), gameMakerPanel);
		
		assertEquals("They are not equal", gameController.getGamePlayPanel(), gamePlayPanel);
	
		assertEquals("They are not equal", gameController.getGameModel(), gameModel);
	}

}
