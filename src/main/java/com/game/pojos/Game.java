package com.game.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.game.save.GameSavable;

@Entity
@Table
public class Game implements Serializable{
	
	@Id
	@GeneratedValue
	private int gameId;
	private String gameName;
	private GameSavable gameSavable;
	
	public Game(){
		
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public GameSavable getGameSavable() {
		return gameSavable;
	}

	public void setGameSavable(GameSavable gameSavable) {
		this.gameSavable = gameSavable;
	}

}
