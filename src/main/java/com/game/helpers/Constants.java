/**
 * s
 */
package com.game.helpers;

import java.awt.Dimension;

/**
 * @author shubh
 *
 */
public class Constants {
		
	
	//size of frame
	public static final int GAMEFRAME_WIDTH=1400;
	public static final int GAMEFRAME_HEIGHT=700;
	public static final String GAMEFRAME_TITLE ="GAME MAKER";
	
	//SplitPane
	public static final int SPLITPANE_LOCATION= 200;
	public static final int SPLITPANE_SIZE = 5;
	
		
		//Game Panel Dimensions
		public static final int GAME_PANEL_HEIGHT = 700;
		public static final int GAME_PANEL_WIDTH = 1200;
		public static final Dimension GAME_PANEL_DIMENSION = new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
		
			
	//Ball sprite image size
		public static final int BALL_RADIUS = 30;
		
		//Paddle sprite image size
		public static final int PADDLE_WIDTH = 60;
		public static final int PADDLE_HEIGHT = 20;
		
		//Brick sprite image size
		public static final int BRICK_WIDTH = 60;
		public static final int BRICK_HEIGHT = 40;
		
		//Frog sprite image size
		public static final int FROG_WIDTH = 40;
		public static final int FROG_HEIGHT = 40;
		
		//Car sprite image size
		public static final int CAR_WIDTH = 40;
		public static final int CAR_HEIGHT = 40;
		
		//Space Invader sprite image size
		public static final int SPACEINVADER_WIDTH = 40;
		public static final int SPACEINVADER_HEIGHT = 40;
		
		//Shooter sprite image size
		public static final int SHOOTER_WIDTH = 40;
		public static final int SHOOTER_HEIGHT = 40;
		
		//Asteriod sprite image size
		public static final int ASTERIOD_WIDTH = 40;
		public static final int ASTERIOD_HEIGHT = 40;
		
		
				
		//Strings for Actions
		public static final String MOVE = "Move";
		public static final String AUTOMOVE = "Automove";
		public static final String BLOWUP = "Blow Up";
		
		
		//Strings for Events
		public static final String SIDES = "Side";
		public static final String UPDOWN = "Up";
		public static final String COLLISION = "Collision";
		public static final String NOBOUND = "Nobound";
		
		//Strings for Game Buttons
		public static final String DRAW = "Draw";
		public static final String PLAY = "Play";
		public static final String PAUSE = "Pause";
		public static final String SAVE = "Save";
		public static final String LOAD = "Load";
		
		//Default Draw position
		public static final int DEFAULT_X = 500;
		public static final int DEFAULT_Y = 500;
		
		//Default Move value
		public static final int DEFAULT_MOVE = 20;
		
		//Non Move Value
		public static final int NO_MOVE = 1000;
		
		//Strings for Images
		public static final String AQUA = "Aqua";
		public static final String FOOT = "Foot";
		public static final String PADDLE = "Paddle";
		public static final String BRICK = "Brick";
		public static final String FROG = "Frog";
		public static final String SPORTSCAR = "Sportscar";
		public static final String TAXI = "Taxi";
		public static final String SPACEINVADER = "Spaceinvader";
		public static final String SHOOTER = "Shooter";
		public static final String ASTERIOD = "Asteriod";
		
		//Move speed for the ball
		public static final int BALL_SPEED_X = 5;
		public static final int BALL_SPEED_Y = 5;
		
		public static final String BLUE = "Blue";
		public static final String GREEN = "Green";
		public static final String YELLOW = "Yellow";
		
		
		public static final int BOUND_WIDTH = GAME_PANEL_WIDTH-40;
		public static final int BOUND_HEIGHT = GAME_PANEL_HEIGHT-40;
		
		//background sound music 
		public static final String MARIOMUSIC = "Mario";
		public static final String TICKTOCK = "Tick Tock";
		public static final String NOMUSIC = "No Music";
    
	
	//speed of command sprite
	public static final int MOVEMENT_CMD_X = 8;
	public static final int MOVEMENT_CMD_Y = 8;
	
    
	//speed of the auto sprite
	public static final int MOVEMENT_AUTO_X = 10;
	public static final int MOVEMENT_AUTO_Y = 10;
	
	//Default KeyCode
	public static final int DEFAULT_KEY = 1000;
	
	//Default Rocket Size
	public static final int DEFAULT_ROCKETSIZE = 15;
	
	//Default Rocket distance
	public static final int ROCKET_DISTANCEX = 10;
	public static final int ROCKET_DISTANCEY = 20;
	
	//Default Rocket speed
	public static final int DEFAULT_ROCKET_SPEED = -8;
	
	//speed of command sprite
	public static final int MOVE_PLAYER_X = 5;
	public static final int MOVE_PLAYER_Y = 5;

	//size of frame
	public static final int FRAME_WIDTH=1400;
	public static final int FRAME_HEIGHT=700;
	
	//default size of panel
	public static final int PANEL_WIDTH = 700;
	public static final int PANEL_HEIGTH = 700;
	
	public static final int BALL_HEIGHT = 40;
	public static final int BALL_WIDTH = 40;
	
	//Default projectile size
	public static final int PROJECTILE_SIZE = 20;
	
	//Default projectile speed
	public static final int PROJECTILE_SPEED = 5;
	
	//Default max and min limits
	public static final int MINLIMIT = -2;
	public static final int MAXLIMIT = 3;
	
	//Default projectile distance limits
	public static final int MINDIS = -150;
	public static final int MAXDIS = 151;
	
	//Default frame rate
	public static final int SLEEP = 30;
	
	public static final String CLOCK = "clock";
	
	//Scores
	public static String SCORE = "Score";
	
	//Default Rocket sound
	public static final String ROCKET_SOUND = "missle_launch.mp3";
	
	//Default Explode sound
	public static final String EXPLODE_SOUND = "explode.mp3";
	
	
	
}
