package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import org.apache.log4j.Logger;

import com.game.strategy.Music;

public class SoundButtonListener implements ActionListener, Serializable {
	String fileName;

	private static Logger backgroundMusicRbLog = Logger.getLogger("backgroundMusicRbLogger");

	Music music = new Music();

	@Override
	public void actionPerformed(ActionEvent e) {
		String commandString = e.getActionCommand();
		switch (commandString) {
		case Constants.MARIOMUSIC:
			fileName = "mario.mp3";
			stopMusic();
			playMusic(fileName);
			backgroundMusicRbLog.info("Mario selected");
			break;
		case Constants.TICKTOCK:
			fileName = "Tick.mp3";
			stopMusic();
			playMusic(fileName);
			backgroundMusicRbLog.info("Ticktock selected");
			break;
		case Constants.NOMUSIC:
			stopMusic();
			backgroundMusicRbLog.info("No music selected");
			break;
		}
	}

	private void playMusic(String fileName) {
		music.play(fileName);
	}

	private void stopMusic() {
		music.stop();
	}

}

