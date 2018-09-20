package com.game.save;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.model.GameModel;
import com.game.model.TimerReadout;

public class GameSavable implements Serializable {
	
	private static final long serialVersionUID = 027;
	
	public ArrayList spriteList;
	public ImageIcon imageIcon;
	public TimerReadout timerReadout;
	public boolean isScoreSet = false;
	
	public GameSavable(GameModel gameModel) {
		this.spriteList = gameModel.getSpriteList();
		this.imageIcon = new ImageIcon(gameModel.getBackgroundImage());	
		this.timerReadout = gameModel.getTimerReadout();
		if(gameModel.getScoreReadout() != null){
			this.isScoreSet = true;
		}
		
	}
	
}
