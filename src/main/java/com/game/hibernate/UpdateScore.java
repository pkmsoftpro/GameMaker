package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.pojos.ScoreSheet;

public class UpdateScore {

	private int playerId;
	private String playerName;
	private int gameId;
	private String gameName;
	private int score;
	
	public UpdateScore(int score, int playerId, String playerName, int gameId, String gameName){
		this.score = score;
		this.playerId = playerId;
		this.playerName = playerName;
		this.gameId = gameId;
		this.gameName = gameName;
		
		System.out.println(" called update score");
		//updateScore();
	}
	
	
	public void pushScoreToDB() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
	    session.beginTransaction();  
	    
	    ScoreSheet scoreSheet = new ScoreSheet();
	    
	    scoreSheet.setPlayerId(playerId);
	    scoreSheet.setPlayerName(playerName);
	    scoreSheet.setGameId(gameId);
	    scoreSheet.setGameName(gameName);
	    scoreSheet.setScore(score);
	    
	    session.save(scoreSheet);
	    session.getTransaction().commit();
	    
	    session.close();
	}
	
	public boolean isGameAlreadyPlayedByUser(){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		    Session session = sessionFactory.openSession();
			
			System.out.println( "in update score" +score);
			
			String sql_query = "select * from ScoreSheet where playerId = '" + playerId + "' AND gameId = '" + gameId + "'" ;
			
			ArrayList<ScoreSheet> score = (ArrayList<ScoreSheet>) session.createSQLQuery(sql_query).addEntity(ScoreSheet.class).list();
			session.close();
			System.out.println("score size"+score.size());
			if(score.isEmpty())
				return false;
			else
				return true;
	}

}