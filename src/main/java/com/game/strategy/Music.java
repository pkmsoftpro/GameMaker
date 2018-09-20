package com.game.strategy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.game.helpers.ResourcesLoader;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/*
 * This file contains methods for playing and stopping music
 * It checks for the filename provided
 */

public class Music implements Serializable {
	private Player player;
	String fileName;
	
	private static final String PREFIX = "streamMusic";
	private static final String SUFFIX = ".tmp";
	
	public void play(String fileName) {
		try{
			URL url = ResourcesLoader.class.getClassLoader().getResource(fileName);
			InputStream inputStream = url.openStream();
			File tempFile = streamToTempFile(inputStream);
			FileInputStream fileInputStream = new FileInputStream(tempFile);
			player = new Player(fileInputStream);
		}catch(FileNotFoundException e){
			
		}catch(JavaLayerException e1){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				try{
					{
					player.play();
					}
				}catch(Exception e){	
				}
			}
		}.start();
	}
	
	public void stop(){
		if(player != null){
			try{
				player.close();
			}catch(Exception e){
				
			}
		}
	}
	
	private File streamToTempFile(InputStream in) throws IOException {
		final File tempFile = File.createTempFile(PREFIX, SUFFIX);
		tempFile.deleteOnExit();
		Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return tempFile;
	}
}
