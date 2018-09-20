package com.game.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.model.GameModel;
import com.game.pojos.Game;
import com.game.save.GameSavable;
public class SaveGameToDatabase {
	
	private String gameName;
	private GameSavable gameSavable;
	
	public SaveGameToDatabase(String inputName, GameSavable gameSavable2){
		this.gameName = inputName;
		this.gameSavable = gameSavable2;
		saveGame();
	}
	
	
	public void saveGame() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
        session.beginTransaction();  
        
        Game game = new Game();
        game.setGameName(gameName);
        game.setGameSavable(gameSavable);
        
        
        session.save(game);
        session.getTransaction().commit();
        
        session.close();
	}
}
