package com.game.helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

import com.game.controller.GameController;
import com.game.hibernate.UpdateScore;
import com.game.main.Main;
import com.game.model.GameModel;
import com.game.pojos.Game;
import com.game.save.GameLoad;
import com.game.save.GameSavable;
import com.game.save.GameSave;
import com.game.view.GamePlayPanel;

public class GameButtonListener implements ActionListener {
	
	private GameController gameController;
	private GameModel gameModel;
	private GamePlayPanel gamePlayPanel;
	
	private String gameSelected = "";
	
	private static Logger buttonLog = Logger.getLogger("buttonLogger");
	
	private int gameId = -1;
	private int playerId = -1;
	private String playerName = "";
	private String gameName = "";
	
	public GameButtonListener(GameController gameController){
		this.gameController = gameController;
		this.gameModel = gameController.getGameModel();
		this.gamePlayPanel = gameController.getGamePlayPanel();
		this.playerId = Main.getPlayerId();
		this.playerName = Main.getPlayerName();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case Constants.DRAW:
			buttonLog.info("Draw button clicked");
			gameModel.addSprite();
			gamePlayPanel.repaint();
			break;
		case Constants.PLAY:
			buttonLog.info("Play button clicked");
			gamePlayPanel.repaint();
			gameController.setGamePlay(true);
			
			if(gameModel.getTimerReadout().isTimerSet)
			{
				gameModel.startTimer();
			}
			break;
		case Constants.PAUSE:
			buttonLog.info("Pause button clicked");
			gameController.setGamePlay(false);
			
			if(gameModel.getTimerReadout().isTimerSet)
			{
				gameModel.stopTimer();
			}
			
			if(playerId != -1 && gameId != -1){
				int score = gamePlayPanel.getScore();
				UpdateScore updateScore = new UpdateScore(score, playerId, playerName,gameId,gameName);
				updateScore.pushScoreToDB();
			}
						
			break;
		case Constants.SAVE:
			buttonLog.info("Save button clicked");
			performSave();
			break;
		case Constants.LOAD:
			buttonLog.info("Load button clicked");
			showGames();
			break;
		}

	}
	
	public void performSave(){
		GameSave gameSave = new GameSave(gameModel);		
		if (gameSave.serialize() == false) {
			JOptionPane.showMessageDialog(null,
					"Error Saving File",
					"Save",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void showGames() {
		GameLoad gameLoad = new GameLoad();
				
				
				try {
					ArrayList<String> gameNamesList = gameLoad.retrieveGameNames();				
					loadGameDialog(gameNamesList);						
				}catch(Exception e){
					buttonLog.error("Loading Failed" + e.getLocalizedMessage());
				}
		
				
	}
	
	private void loadGameDialog(ArrayList<String> gameNamesList) {
		final JDialog loadDialog = new JDialog();
		JPanel loadGamePanel = new JPanel();
		JLabel gameLabel = new JLabel("Select any game ");
		JButton loadGameButton = new JButton("Load");
		loadGamePanel.setLayout(new GridLayout(0, 1));
		JScrollPane scrollPane = new JScrollPane(loadGamePanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		HashMap<JLabel, String> gameNamesMap = new HashMap<JLabel, String>();
		
		Border border  = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(String gameName : gameNamesList){
			final JLabel tempLabel = new JLabel(gameName);
			tempLabel.setBorder(border);
			tempLabel.setOpaque(true);
			tempLabel.addMouseListener(new MouseListener()	{
				@Override
				public void mouseReleased(MouseEvent e) {	
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				}
				
				@Override
				public void mouseExited(MouseEvent e) {

				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					tempLabel.setBackground(Color.cyan);
					gameSelected = tempLabel.getText();
					
				}
			});
			loadGamePanel.add(tempLabel);
		}
		
		loadGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameSelected != null){
				 performLoad(gameSelected);
				
				loadDialog.dispose();
					JOptionPane.showMessageDialog(null,
							"Load Successful",
							"Load",
							JOptionPane.INFORMATION_MESSAGE);	
				}

			}
		});
		
		loadGamePanel.add(gameLabel);
		loadGamePanel.add(loadGameButton);

		loadDialog.setSize(new Dimension(300,600));
		loadDialog.add(loadGamePanel);
		loadDialog.setVisible(true);
	}


	
	public void performLoad(String selectedGameName){
		GameLoad gameLoad = new GameLoad();
		
		
		try {
			
			Game game = (Game)(gameLoad.retrieveSelectedGame(selectedGameName));
			this.gameId = game.getGameId();
			this.gameName = game.getGameName();
			GameSavable loadSavable = game.getGameSavable();
			
			if(loadSavable.isScoreSet){
				gamePlayPanel.getTempScore().reset();
				gamePlayPanel.getTempScore().isScoreSet = true;
			}
			
			gameController.getGameModel().setSpriteList(loadSavable.spriteList);
			gameController.getGameModel().setBackgroundImage(loadSavable.imageIcon.getImage());
			gamePlayPanel.setBackGroundImage(loadSavable.imageIcon.getImage());
			
		
			if(loadSavable.timerReadout.isTimerSet)				
				gameModel.setTimerReadout(loadSavable.timerReadout);			
			gamePlayPanel.repaint();
			
		}catch(Exception e){
			buttonLog.error("Loading Failed" + e.getLocalizedMessage());
		}
		
	}

	public String getGameSelected() {
		return gameSelected;
	}

	public void setGameSelected(String gameSelected) {
		this.gameSelected = gameSelected;
	}

}
