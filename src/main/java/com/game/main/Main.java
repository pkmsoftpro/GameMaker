package com.game.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.game.hibernate.LoginHandler;
import com.game.hibernate.SignUpHandler;
import com.game.view.GameFrame;


public class Main {
	
	private static boolean userRegistered = false;
	private static int playerId = -1;
	private static String playerName = "";

	public static void main(String[] args) {
		final JPanel userLoginPanel = new JPanel();
		final JDialog loginDialog = new JDialog();
		final JTextField userInput = new JTextField();
		JLabel userNameLabel = new JLabel("Enter your name: ");
		//userLoginPanel.setLayout(new BoxLayout(userLoginPanel, BoxLayout.Y_AXIS));
		userInput.setPreferredSize(new Dimension(200,30));
		JButton loginButton = new JButton("Log in");
		JButton signUpButton = new JButton("Sign up");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				String input = userInput.getText();
				LoginHandler loginHandler = new LoginHandler(input);
				
				setPlayerId(loginHandler.isUserRegistered());
				
				//System.out.println("playerId"+playerId);
				if(getPlayerId() != -1){
					userRegistered = true;
					playerName += input;
					//System.out.println("userRegistered" + userRegistered);
					loginDialog.dispose();
					startGame();
				}
				else{
					JOptionPane.showMessageDialog(userLoginPanel, "Signup to Login and Have fun");
				}
			}
		});
		
		signUpButton.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e)	{
				String input = userInput.getText();
				SignUpHandler signUpHandler = new SignUpHandler(input);
				if(signUpHandler.isUserNameExistsAlready()){
					  JOptionPane.showMessageDialog(userLoginPanel, "User Name Already Exists! - Try another Name");
				}
				else{
					signUpHandler.registerPlayer();
					loginDialog.dispose();
					setPlayerId(signUpHandler.getCurrentPlayerId());
					//System.out.println("playerId"+playerId);
					userRegistered = true;
					playerName += input;
					startGame();
				}
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(loginButton);
		buttonPanel.add(signUpButton);
		userLoginPanel.add(userNameLabel, BorderLayout.NORTH);
		userLoginPanel.add(userInput, BorderLayout.CENTER);
		userLoginPanel.add(buttonPanel, BorderLayout.SOUTH);

		loginDialog.setSize(new Dimension(300,200));
		loginDialog.add(userLoginPanel);
		loginDialog.setVisible(true);
		
	}
	
	public static void startGame(){
		if(userRegistered){		
			//System.out.println(" in main : works if user registered-- calls new gameFrame");
			new GameFrame();
		}
	}

	public static int getPlayerId() {
		return playerId;
	}

	public static void setPlayerId(int playerId) {
		Main.playerId = playerId;
	}

	public static String getPlayerName() {
		return playerName;
	}

	public static void setPlayerName(String playerName) {
		Main.playerName = playerName;
	}
		
		

}
