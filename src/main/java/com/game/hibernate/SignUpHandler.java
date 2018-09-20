package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.pojos.Game;
import com.game.pojos.Player;


public class SignUpHandler {
	    private Player player;
		private String playerName;
		
		
		public SignUpHandler(String username){
			this.playerName = username;
			
		}
		
		
		public boolean isUserNameExistsAlready(){
			  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			   Session session = sessionFactory.openSession();
				
				System.out.println( "in signup handler" +playerName);
				String sql_query = "select playerId, playerName from Player where playerName = '" + playerName + "'";
				
				ArrayList<Player> player = (ArrayList<Player>) session.createSQLQuery(sql_query).addEntity(Player.class).list();
				session.close();
				System.out.println("player size"+player.size());
				if(player.isEmpty())
					return false;
				else
					return true;
		}
		
		  @SuppressWarnings("unchecked")
		   public boolean registerPlayer() {
			  	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();  
		        session.beginTransaction();  
		        
		        Player player = new Player();
		        player.setPlayerName(playerName);
		        
		        session.save(player);
		        session.getTransaction().commit();
		        
		        session.close();
		        return true;		        
		  }


		public int getCurrentPlayerId() {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			    Session session = sessionFactory.openSession();
				String sql_query = "select playerId, playerName from Player where playerName = '" + playerName + "'";				
				ArrayList<Player> player = (ArrayList<Player>) session.createSQLQuery(sql_query).addEntity(Player.class).list();
				session.close();				
				return player.get(0).getPlayerId();				
		}
		  
}




 



