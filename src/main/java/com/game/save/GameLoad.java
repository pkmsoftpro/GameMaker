package com.game.save;

import java.util.ArrayList;

import com.game.hibernate.RetrieveGamesTable;
import com.game.pojos.Game;

public class GameLoad {
	
	public ArrayList<String> retrieveGameNames(){
		
		RetrieveGamesTable retrieveGamesTable = new RetrieveGamesTable();
		ArrayList<String> gameNamesList = retrieveGamesTable.showGames();
		return gameNamesList;
	}
	
	public Game retrieveSelectedGame(String string){
		System.out.println(" input --- Retrieve game: " + string);
		String temp = string;
		RetrieveGamesTable retrieveGamesTable = new RetrieveGamesTable();
		return retrieveGamesTable.returnSelectedGame(temp);
	}
}
