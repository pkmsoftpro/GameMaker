package com.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimerTest {
	
	private TimerReadout TimerReadout = new TimerReadout();
	public static int timerSeconds = 0;
	public static int timerMinutes = 0;
	
	@Test
	public void testTimer() {
		TimerReadout.startTimer();
		assertEquals(timerMinutes, TimerReadout.timerMinutes);
		TimerReadout.stopTimer();
	}

}
