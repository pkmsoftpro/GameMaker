package com.game.pojos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.game.save.GameSavable;

public class GamePOJOTest {
	private Game game = new Game();
	private int gameId = 1;
	private String gameName = "Mike";
	private GameSavable gameSavable;
	
	
	@Before
	public void setup() {
		game.setGameId(gameId);
		game.setGameName(gameName);	
	}
	
	
	@Test
	public void testGamePOJO() {
		
		assertEquals("They are not equal", game.getGameId(), gameId);
		assertEquals("They are not equal", game.getGameName(), gameName);
		
	}

}
