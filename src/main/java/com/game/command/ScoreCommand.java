package com.game.command;

import com.game.model.ScoreReadout;


public class ScoreCommand {

	private ScoreReadout score;
	private String text;
	private int currentScore;
	
	public ScoreCommand(ScoreReadout score) {
		this.score = score;
	}

	public void execute() {
		currentScore = score.getScore();
		currentScore += 5;
		score.setScore(currentScore);
	}
	
	public String getText() {
		return text;
	}
}