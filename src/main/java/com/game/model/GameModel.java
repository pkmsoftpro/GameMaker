package com.game.model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameModel implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	private Sprite gameSprite;
	private ArrayList<Sprite> spriteList;
	private ImageIcon backgroundImage;
	private TimerReadout timerReadout;
	private ScoreReadout scoreReadout;
	
	public GameModel(){
		this.gameSprite = new Sprite();
		this.spriteList = new ArrayList<Sprite>();
		this.timerReadout = new TimerReadout();
		this.scoreReadout = new ScoreReadout();
	}
	
	public void addSprite(){
		spriteList.add(new Sprite(gameSprite));
	}
	
	private void removeSprite(Sprite sprite){
		int i = spriteList.indexOf(sprite);
		if(i >= 0){
			spriteList.remove(i);
		}
	}

	public Sprite getGameSprite() {
		return gameSprite;
	}

	public void setGameSprite(Sprite gameSprite) {
		this.gameSprite = gameSprite;
	}

	public ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	public void setSpriteList(ArrayList<Sprite> spriteList) {
		this.spriteList = spriteList;
	}

	public Image getBackgroundImage() {
		Image background = backgroundImage.getImage();
		return background;
	}

	public void setBackgroundImage(Image backgroundImage) {
		ImageIcon icon = new ImageIcon(backgroundImage);
		this.backgroundImage = icon;
	}
	
	public void startTimer()
	{
		this.timerReadout.startTimer();
	}
	
	public void stopTimer()
	{
		this.timerReadout.stopTimer();
	}

	public TimerReadout getTimerReadout() {
		return timerReadout;
	}

	public void setTimerReadout(TimerReadout timerReadout) {
		this.timerReadout = timerReadout;
	}
	
	public ScoreReadout getScoreReadout() {
		return scoreReadout;
	}

	public void setScoreReadout(ScoreReadout scoreReadout) {
		this.scoreReadout = scoreReadout;
	}
	
}