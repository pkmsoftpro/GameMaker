package com.game.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.game.command.SpriteCommand;
import com.game.helpers.ActionButtonListener;
import com.game.helpers.BackgroundButtonListener;
import com.game.helpers.BlowupListener;
import com.game.helpers.Constants;
import com.game.helpers.DisintegrateButtonListener;
import com.game.helpers.DragEventListener;
import com.game.helpers.EventButtonListener;
import com.game.helpers.GameButtonListener;
import com.game.helpers.ImageButtonListener;
import com.game.helpers.ReadoutButtonListener;
import com.game.helpers.ShootButtonListener;
import com.game.helpers.SoundButtonListener;
import com.game.helpers.UserKeyListener;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.view.GameMakerPanel;
import com.game.view.GamePlayPanel;

public class GameController {
	
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	private GameModel gameModel;
	private DragEventListener dragListener;
	
	private boolean gamePlay = false;
	
	private static Logger gameControlLog = Logger.getLogger("gameControlLogger");
	
	public GameController(GameModel gameModel, GameMakerPanel gameMakerPanel, GamePlayPanel gamePlayPanel) {
		this.gameModel = gameModel;
		this.gameMakerPanel = gameMakerPanel;
		this.gamePlayPanel = gamePlayPanel;
		this.dragListener = new DragEventListener(this);
		this.gameMakerPanel.addImageButtonListener(new ImageButtonListener(gameModel, gameMakerPanel));
		this.gameMakerPanel.addEventButtonListener(new EventButtonListener(gameModel));
		this.gameMakerPanel.addActionButtonListener(new ActionButtonListener(gameModel));
		this.gameMakerPanel.addGameButtonListener(new GameButtonListener(this));
		this.gameMakerPanel.addBackGroundButtonListener(new BackgroundButtonListener(this));
		this.gameMakerPanel.addBackGroundMusicButtonListener(new SoundButtonListener());
		this.gameMakerPanel.addShooterListener(new ShootButtonListener(gameModel));
		this.gameMakerPanel.addDisintegrateListener(new DisintegrateButtonListener(gameModel));
		this.gameMakerPanel.addReadoutButtonListener(new ReadoutButtonListener(gameModel));
		this.gameMakerPanel.addBlowUpListener(new BlowupListener(gameModel));
		this.gamePlayPanel.addMouseListener(this.dragListener);
		this.gamePlayPanel.addMouseMotionListener(this.dragListener);
		this.gamePlayPanel.addKeyListener(new UserKeyListener(gameModel));
		gameLoop();
	}
	
	public void gameLoop(){
		new Thread() {
			public void run(){
				while(true){
					if(gamePlay){
						ArrayList<Sprite> playList = new ArrayList<Sprite>(gameModel.getSpriteList());
						for(Sprite sprite : playList){
							SpriteCommand spriteCommand = new SpriteCommand(sprite);
							spriteCommand.execute();
						}
						gamePlayPanel.repaint();
					}
					try {
						java.lang.Thread.sleep(Constants.SLEEP);
					} catch (InterruptedException e) {
						gameControlLog.error("Error in thread" + e.getLocalizedMessage());
					}
				}
			}
		}.start();
	}

	public GameMakerPanel getGameMakerPanel() {
		return gameMakerPanel;
	}

	public void setGameMakerPanel(GameMakerPanel gameMakerPanel) {
		this.gameMakerPanel = gameMakerPanel;
	}

	public GamePlayPanel getGamePlayPanel() {
		return gamePlayPanel;
	}

	public void setGamePlayPanel(GamePlayPanel gamePlayPanel) {
		this.gamePlayPanel = gamePlayPanel;
	}

	public GameModel getGameModel() {
		return gameModel;
	}

	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public boolean isGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(boolean gamePlay) {
		this.gamePlay = gamePlay;
	}
		
}
