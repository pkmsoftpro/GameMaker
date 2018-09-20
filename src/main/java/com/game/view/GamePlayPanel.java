package com.game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.game.helpers.Constants;
import com.game.model.GameModel;
import com.game.model.ScoreReadout;
import com.game.model.Sprite;
import com.game.model.TimerReadout;

@SuppressWarnings("serial")
public class GamePlayPanel extends JPanel {
	
	private GameModel gameModel;
	
	private static Logger gamePlayPanelLog = Logger.getLogger("gamePlayPanelLogger");
	private Image backGroundImage;
	private TimerReadout timerReadout;
	private ScoreReadout tempScore;
	private int score = -1;
	private String scoreDisplay = "Score";
	
	public GamePlayPanel(GameModel gameModel){
		this.setSize(Constants.GAME_PANEL_DIMENSION);
		this.gameModel = gameModel;
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setFocusTraversalKeysEnabled(false);
		backGroundImage = this.getBackGroundImage();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(backGroundImage, 0, 0, this.getWidth(), this.getHeight(), this);	
		this.timerReadout = gameModel.getTimerReadout();
		this.tempScore = gameModel.getScoreReadout();
		try{
			for(Sprite sprite : gameModel.getSpriteList()){
				if(sprite.isVisible()){
					sprite.draw(g);
				}
			}
			if(timerReadout.isTimerSet)
			{
				timerReadout.draw(g);
			}
			
			if(tempScore.isScoreSet) {
				g.setColor(Color.BLUE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30));				
				g.drawString(scoreDisplay+" : "+tempScore.getScore(), Constants.GAME_PANEL_WIDTH/2, 30);			
				this.score = tempScore.getScore();
			}
			
		}catch(NullPointerException e){
			gamePlayPanelLog.error("Failed to get array " + e.getLocalizedMessage());
		}
	}

	public Image getBackGroundImage() {
		return backGroundImage;
	}

	public void setBackGroundImage(Image backGroundImage) {
		this.backGroundImage = backGroundImage;
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ScoreReadout getTempScore() {
		return tempScore;
	}

	public void setTempScore(ScoreReadout tempScore) {
		this.tempScore = tempScore;
	}

	
}