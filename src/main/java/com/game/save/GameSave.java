package com.game.save;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.hibernate.HibernateUtil;
import com.game.hibernate.SaveGameToDatabase;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.pojos.Game;
import com.game.strategy.Music;

public class GameSave{

	private ArrayList<Sprite> spriteList;
	private Image background;
	public GameSavable gameSavable;
	private GameModel gameModel;
	JDialog saveDialog = new JDialog();
	
	public GameSave(GameModel gameModel) 
	{
		this.spriteList = gameModel.getSpriteList();
		this.background = gameModel.getBackgroundImage();
		this.gameSavable = new GameSavable(gameModel);
	}

	/**
	 * Function called when user click save
	 * @return
	 */
	public boolean serialize() {
		try {
			saveGameDialog();
			return true;
			
			
		}catch(Exception i) {
			i.printStackTrace();
		}
		return false;
	}
	
	private void saveGameDialog() {
		JPanel saveGamePanel = new JPanel();
		JLabel gameLabel = new JLabel("Please Give a name to your game: ");
		final JTextField userInput = new JTextField();
		JButton saveGameButton = new JButton("Save");
		
		userInput.setPreferredSize(new Dimension(300,30));
		saveGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = userInput.getText();
					saveGameToDatabase(input);
					saveDialog.dispose();
					JOptionPane.showMessageDialog(null,
							"Save Successful",
							"Save",
							JOptionPane.INFORMATION_MESSAGE);					

			}
		});
		
		saveGamePanel.add(gameLabel);
		saveGamePanel.add(userInput);
		saveGamePanel.add(saveGameButton);

		saveDialog.setSize(new Dimension(300,200));
		saveDialog.add(saveGamePanel);
		saveDialog.setVisible(true);
	}
	
	public boolean saveGameToDatabase(String inputName){		
		new SaveGameToDatabase(inputName, gameSavable);
		return true;
		
	}
}

