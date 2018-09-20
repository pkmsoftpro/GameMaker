package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.pojos.Player;

public class LoginHandler {
	
	//private Player player;
	private String playerName;
	public LoginHandler(String username){
		this.playerName = username;
		
	}
	
   @SuppressWarnings("unchecked")
   public int isUserRegistered() {
	   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	   Session session = sessionFactory.openSession();
		
		System.out.println( "in user registered" +playerName);
		String sql_query = "select playerId, playerName from Player where playerName = '" + playerName + "'";
		
		ArrayList<Player> player = (ArrayList<Player>) session.createSQLQuery(sql_query).addEntity(Player.class).list();
		session.close();
		System.out.println("player size"+player.size());
		if(!player.isEmpty())
			return player.get(0).getPlayerId();
		else
		 return -1;
	}
}



