package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.game.model.GameModel;
import com.game.model.ScoreReadout;
import com.game.model.TimerReadout;

public class ReadoutButtonListener implements ActionListener {

	TimerReadout timerReadout;
	ScoreReadout scoreReadout;
	GameModel gameModel;
	
	public ReadoutButtonListener(GameModel gameModel) {
		this.gameModel= gameModel;
		this.scoreReadout = gameModel.getScoreReadout();
		this.timerReadout = gameModel.getTimerReadout();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		
		if(e.getActionCommand().equals(Constants.CLOCK))
		{
			timerReadout.isTimerSet = true;
		}
		else if (e.getActionCommand().equals(Constants.SCORE)) 
		{
			scoreReadout.isScoreSet = true;		
		}

}
}