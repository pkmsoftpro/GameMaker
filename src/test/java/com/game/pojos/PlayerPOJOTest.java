package com.game.pojos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerPOJOTest {

	private Player player = new Player();
	private int playerId = 300;
	private String playerName = "Adrian";
	
	
	@Before
	public void setup() {
		player.setPlayerId(playerId);
		player.setPlayerName(playerName);	
	}
	
	
	@Test
	public void testGamePOJO() {
		
		assertEquals("They are not equal", player.getPlayerId(), playerId);
		assertEquals("They are not equal", player.getPlayerName(), playerName);
		
	}


}
