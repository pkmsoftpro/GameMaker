package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.game.model.GameModel;

public class ActionButtonListenerTest {
		
	private GameModel gameModel = new GameModel();
	ActionButtonListener actionButtonListener = new ActionButtonListener(gameModel);
	ActionListener spy;
	ActionEvent e;
	
	@Before
	public void setUp() {
		String actionCommand = "Constants.AUTOMOVE";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy = Mockito.spy(actionButtonListener);
	}
	
	@Test
	public void testActionPerformedUPDOWN() {
		String actionCommand = "Constants.MOVE";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy.actionPerformed(e);
		Mockito.verify(spy, Mockito.times(1)).actionPerformed(e);
	}
	
}
