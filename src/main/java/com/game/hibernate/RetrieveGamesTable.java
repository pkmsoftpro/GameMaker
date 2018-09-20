package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.game.pojos.Game;

public class RetrieveGamesTable {
	
	public RetrieveGamesTable() {

	}

	public ArrayList<String> showGames() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		ArrayList<String> games = (ArrayList<String>) (session.createSQLQuery("SELECT gameName from Game").list());

		System.out.println(" in retrieve class size of gameNames" + games.size());
		session.close();

		System.out.println("Game 0 " + games.get(0));
		return games;
	}

	public Game returnSelectedGame(String gName) {
		Game game;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		// SQL query is not correct
		String gameName = gName;
		
		System.out.println(gameName);
		String sql_query = "select gameId, gameName,gameSavable from Game where gameName = '" + gameName + "'";
		//System.out.println(session.createSQLQuery(sql_query).addEntity(Game.class).list());
		//game = (Game) session.createSQLQuery(sql_query).addEntity(Game.class).list();
		ArrayList<Game> games = (ArrayList<Game>) session.createSQLQuery(sql_query).addEntity(Game.class).list();
		System.out.println(games.size());
		System.out.println("in retrieve");
		System.out.println(games.get(0).getGameName());
		//System.out.println("Fetch game: " + games.getGameName());
		session.close();

		return games.get(0);
	}

}
