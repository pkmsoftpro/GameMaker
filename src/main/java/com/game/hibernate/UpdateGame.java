package com.game.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.model.GameModel;
import com.game.pojos.Game;
import com.game.save.GameSavable;
import com.game.hibernate.HibernateUtil;

public class UpdateGame {
	public static void main(String[] args) {  
		  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
       
        
        
       // Updates the game with id -1 ( generally it could be any game)
        
        Game game  = (Game) session.get(Game.class, 1);
        
        
         
        //user.setName("Meow");  
        //user.setScore(90);  
        
        //setting a temp user name --- going forward give flexibility for the user to give a name
        // setting the gameSavable to this gameSavable when user clicks save
        GameSavable gameSavable = new GameSavable(new GameModel());
        game.setGameName("temp");
        game.setGameSavable(gameSavable);
        
        
        
        session.update(game);  
        session.getTransaction().commit();  
          
        session.close();  
    }  
}
