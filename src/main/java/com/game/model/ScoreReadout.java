package com.game.model;

import java.io.Serializable;

public class ScoreReadout implements Serializable{
		
		private static final long serialVersionUID = 10L;
		private int score;
		public boolean isScoreSet = false;
	    
        public ScoreReadout() {
        	score = 0;
	    }
	
       public int getScore() {
    	   return score;
	    }
	
	    public void setScore(int score) {
	        this.score = score;
	    }
	    
	    public void reset() {
	       this.setScore(0);
	    }     
	}