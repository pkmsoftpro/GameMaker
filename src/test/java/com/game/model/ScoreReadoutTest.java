package com.game.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreReadoutTest {
	
	ScoreReadout scoreReadout = new ScoreReadout();
	private String scoretext = "Score: 0";
	private int score = 200;
	
	@Before
	public void setup() {
		scoreReadout.setScore(score);
		
	}
	
	@Test
	public void test() {
		assertEquals("They are not equal", scoreReadout.getScore(), score);
	}

}
