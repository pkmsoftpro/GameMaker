package com.game.view;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.game.helpers.Constants;
import com.game.helpers.ResourcesLoader;

public class GameMakerPanel extends JPanel {

	
	private ImageIcon previewIcon;
	private JLabel previewLabel;
	private ButtonGroup bgActions;
	private ButtonGroup bgSprites;
	private ButtonGroup bgGame;
	private ArrayList<JCheckBox> bgEvents;
	private ButtonGroup bgBackgrounds;
	private ButtonGroup bgReadouts;
	private ButtonGroup bgBackgroundMusic;
	private JPanel imagePanel;
	private JCheckBox actionShooter;
	private JCheckBox disintegrate;
	private JCheckBox actionRbBlowUp;
	private ClassLoader cl;

	
	public GameMakerPanel(){
		
	
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.setAlignmentY(0);
	this.cl = ResourcesLoader.class.getClassLoader();
	
	previewIcon = new ImageIcon(cl.getResource("Questionmark.png"));
	Image tempImg = previewIcon.getImage();
	tempImg = tempImg.getScaledInstance(Constants.BALL_RADIUS, Constants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
	previewIcon = new ImageIcon(tempImg);
	previewLabel = new JLabel();
	previewLabel = new JLabel("Selected", previewIcon, JLabel.CENTER);
	initSpriteButtons();
	this.add(previewLabel);
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initActionButtons();
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initEventButtons();
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initBackgroundButtons();
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initBackgroundMusicButtons();
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initControlReadouts();
	this.add(new JSeparator(SwingConstants.HORIZONTAL));
	initGameButtons();
	
}

public void initSpriteButtons(){
	JLabel imageTitle = new JLabel("Select an Image");
	this.add(imageTitle);
	ImageIcon spriteImage = new ImageIcon(cl.getResource("football.png"));
	Image tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.BALL_RADIUS, Constants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbBall = new JRadioButton(spriteImage, true);
	spriteRbBall.setFocusable(false);
	spriteRbBall.setActionCommand(Constants.FOOT);
	
	spriteImage = new ImageIcon(cl.getResource("paddle1.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbPaddle = new JRadioButton(spriteImage, true);
	spriteRbPaddle.setFocusable(false);
	spriteRbPaddle.setActionCommand(Constants.PADDLE);
	
	spriteImage = new ImageIcon(cl.getResource("brick.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbBrick = new JRadioButton(spriteImage, true);
	spriteRbBrick.setFocusable(false);
	spriteRbBrick.setActionCommand(Constants.BRICK);
	
	spriteImage = new ImageIcon(cl.getResource("frog.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.FROG_WIDTH, Constants.FROG_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbFrog = new JRadioButton( spriteImage, false);
	spriteRbFrog.setFocusable(false);
	spriteRbFrog.setActionCommand(Constants.FROG);
	
	spriteImage = new ImageIcon(cl.getResource("car1.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.CAR_WIDTH, Constants.CAR_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbSportsCar = new JRadioButton( spriteImage, false);
	spriteRbSportsCar.setFocusable(false);
	spriteRbSportsCar.setActionCommand(Constants.SPORTSCAR);
	
	spriteImage = new ImageIcon(cl.getResource("car2.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.CAR_WIDTH, Constants.CAR_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbTaxi = new JRadioButton( spriteImage, false);
	spriteRbTaxi.setFocusable(false);
	spriteRbTaxi.setActionCommand(Constants.TAXI);
	
	spriteImage = new ImageIcon(cl.getResource("space-invaders.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.SPACEINVADER_WIDTH, Constants.SPACEINVADER_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbSpaceInvader = new JRadioButton( spriteImage, false);
	spriteRbSpaceInvader.setFocusable(false);
	spriteRbSpaceInvader.setActionCommand(Constants.SPACEINVADER);
	
	spriteImage = new ImageIcon(cl.getResource("shooter.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.SHOOTER_WIDTH, Constants.SHOOTER_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbShooter = new JRadioButton( spriteImage, false);
	spriteRbShooter.setFocusable(false);
	spriteRbShooter.setActionCommand(Constants.SHOOTER);
	
	spriteImage = new ImageIcon(cl.getResource("Asteroid.png"));
	tempImg = spriteImage.getImage();
	tempImg = tempImg.getScaledInstance(Constants.ASTERIOD_WIDTH, Constants.ASTERIOD_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	spriteImage = new ImageIcon(tempImg);
	
	JRadioButton spriteRbAsteriod = new JRadioButton(spriteImage, false);
	spriteRbAsteriod.setFocusable(false);
	spriteRbAsteriod.setActionCommand(Constants.ASTERIOD);
	
	
	
	bgSprites = new ButtonGroup();
	bgSprites.add(spriteRbBall);
	bgSprites.add(spriteRbPaddle);
	bgSprites.add(spriteRbBrick);
	bgSprites.add(spriteRbFrog);
	bgSprites.add(spriteRbAsteriod);
	bgSprites.add(spriteRbSportsCar);
	bgSprites.add(spriteRbTaxi);
	bgSprites.add(spriteRbSpaceInvader);
	bgSprites.add(spriteRbShooter);

	//Creating GroupLayout for the sprite image selection panel
	imagePanel = new JPanel();
	GroupLayout layout = new GroupLayout(imagePanel);
	imagePanel.setLayout(layout);
	
	layout.setHorizontalGroup(layout
		    .createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addComponent(spriteRbBall, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(spriteRbPaddle, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(spriteRbBrick, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    .addGroup(layout.createSequentialGroup()	        
		        .addComponent(spriteRbAsteriod, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(spriteRbFrog, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(spriteRbSportsCar, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))       
		    .addGroup(layout.createSequentialGroup()
			    .addComponent(spriteRbTaxi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addComponent(spriteRbSpaceInvader, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		    	.addComponent(spriteRbShooter, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		       .addComponent(spriteRbBall).addComponent(spriteRbPaddle).addComponent(spriteRbBrick))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		       .addComponent(spriteRbAsteriod).addComponent(spriteRbFrog).addComponent(spriteRbSportsCar))		       
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			   .addComponent(spriteRbTaxi).addComponent(spriteRbSpaceInvader).addComponent(spriteRbShooter)));
	
	this.add(imagePanel);
	
}

public void initActionButtons(){
	JLabel actionTitle = new JLabel("Attach Action");
this.add(actionTitle);
	JRadioButton actionRbMove = new JRadioButton("Move", false);
	JRadioButton actionRbBounce = new JRadioButton("Auto-Move", false);
	actionRbBlowUp = new JCheckBox("Blow Up", false);
	actionShooter = new JCheckBox("Shooter", false);
	disintegrate = new JCheckBox("Disintegrate", false);
	
	actionShooter.setFocusable(false);
	disintegrate.setFocusable(false);
	actionRbMove.setFocusable(false);
	actionRbBounce.setFocusable(false);
	actionRbBlowUp.setFocusable(false);
	
	actionRbMove.setActionCommand(Constants.MOVE);
	actionRbBounce.setActionCommand(Constants.AUTOMOVE);
	actionRbBlowUp.setActionCommand(Constants.BLOWUP);
	
	bgActions = new ButtonGroup();
	bgActions.add(actionRbMove);
	bgActions.add(actionRbBounce);
//	bgActions.add(actionRbBlowUp);
	
	this.add(actionRbMove);
	this.add(actionRbBounce);
	this.add(actionRbBlowUp);
	this.add(actionShooter);
	this.add(disintegrate);
	
}

public void initEventButtons(){
	JLabel eventTitle = new JLabel("Attach Events");
	this.add(eventTitle);
	JCheckBox eventRbsides = new JCheckBox("Left-Right", false);
	JCheckBox eventRbup = new JCheckBox("Up-down", false);
	JCheckBox eventCollision = new JCheckBox("Collision", false);
	JCheckBox eventRbnobounds = new JCheckBox("No-Bounds", false);
	
	eventRbsides.setFocusable(false);
	eventRbup.setFocusable(false);
	eventCollision.setFocusable(false);
	eventRbnobounds.setFocusable(false);
	
	eventRbsides.setActionCommand(Constants.SIDES);
	eventRbup.setActionCommand(Constants.UPDOWN);
	eventCollision.setActionCommand(Constants.COLLISION);
	eventRbnobounds.setActionCommand(Constants.NOBOUND);
	
	
	
	bgEvents = new ArrayList<JCheckBox>();
	bgEvents.add(eventRbsides);
	bgEvents.add(eventRbup);
	bgEvents.add(eventCollision);
	bgEvents.add(eventRbnobounds);
	
	this.add(eventRbsides);
	this.add(eventRbup);
	this.add(eventCollision);
	this.add(eventRbnobounds);
}

public void initBackgroundButtons() {
	JLabel backGroundTitle = new JLabel("Backgrounds");
	JRadioButton backGroundSpace = new JRadioButton("space", false);
	JRadioButton backGroundRoad = new JRadioButton("road", false);
	
	backGroundSpace.setFocusable(false);
	backGroundRoad.setFocusable(false);
	
	backGroundSpace.setActionCommand("Space");
	backGroundRoad.setActionCommand("Road");
	
	bgBackgrounds = new ButtonGroup();
	bgBackgrounds.add(backGroundSpace);
	bgBackgrounds.add(backGroundRoad);
	
	this.add(backGroundTitle);
	this.add(backGroundSpace);
	this.add(backGroundRoad);
	
}

public void initBackgroundMusicButtons() {
	JLabel backGroundMusicTitle = new JLabel("Background Music");
	JRadioButton backGroundMusicMario = new JRadioButton("Mario", false);
	JRadioButton backGroundMusicGreen = new JRadioButton("Tick Tock", false);
	JRadioButton backGroundMusicYellow = new JRadioButton("No Music", false);
	
	backGroundMusicMario.setFocusable(false);
	backGroundMusicGreen.setFocusable(false);
	backGroundMusicYellow.setFocusable(false);
	
	
	bgBackgroundMusic = new ButtonGroup();
	bgBackgroundMusic.add(backGroundMusicMario);
	bgBackgroundMusic.add(backGroundMusicGreen);
	bgBackgroundMusic.add(backGroundMusicYellow);

	this.add(backGroundMusicTitle);
	this.add(backGroundMusicMario);
	this.add(backGroundMusicGreen);
	this.add(backGroundMusicYellow);
}

public void initControlReadouts() {
	JLabel readoutTitle = new JLabel("Control Readouts");
	JRadioButton readoutClock = new JRadioButton("Clock", false);
	JRadioButton readoutScore = new JRadioButton("Score", false);
	
	readoutClock.setFocusable(false);
	readoutScore.setFocusable(false);
	
	readoutClock.setActionCommand(Constants.CLOCK);
	readoutScore.setActionCommand(Constants.SCORE);
	
	bgReadouts = new ButtonGroup();
	bgReadouts.add(readoutClock);
	bgReadouts.add(readoutScore);
	
	this.add(readoutTitle);
	this.add(readoutClock);
	this.add(readoutScore);
}

public void initGameButtons(){
	JButton buttonDraw = new JButton("Draw");
	JButton buttonPlay = new JButton("Play");
	JButton buttonPause = new JButton("Pause");
	JButton buttonSave = new JButton("Save");
	JButton buttonLoad = new JButton("Load");
	
	buttonDraw.setFocusable(false);
	buttonPlay.setFocusable(false);
	buttonPause.setFocusable(false);
	buttonSave.setFocusable(false);
	buttonLoad.setFocusable(false);

	//disable the buttons
	buttonDraw.setEnabled(true);
	buttonPlay.setEnabled(true);
	buttonPause.setEnabled(true);
	buttonSave.setEnabled(false);
	
	buttonDraw.setActionCommand(Constants.DRAW);
	buttonPlay.setActionCommand(Constants.PLAY);
	buttonPause.setActionCommand(Constants.PAUSE);
	buttonSave.setActionCommand(Constants.SAVE);
	buttonLoad.setActionCommand(Constants.LOAD);
	
	bgGame = new ButtonGroup();
	bgGame.add(buttonPlay);
	bgGame.add(buttonDraw);
	bgGame.add(buttonPause);
	bgGame.add(buttonSave);
	bgGame.add(buttonLoad);
	
	this.add(buttonDraw);
	this.add(buttonPlay);
	this.add(buttonPause);
	this.add(buttonSave);
	this.add(buttonLoad);
}

public JLabel getPreviewLabel() {
	return previewLabel;
}

public void addActionButtonListener(ActionListener actionButtonListener){
	Enumeration<AbstractButton> buttons = bgActions.getElements();
	while(buttons.hasMoreElements()){
		AbstractButton button = buttons.nextElement();
		button.addActionListener(actionButtonListener);
	}
}

public void addImageButtonListener(ActionListener imageButtonListener){
	Enumeration<AbstractButton> buttons = bgSprites.getElements();
	while(buttons.hasMoreElements()){
		AbstractButton button = buttons.nextElement();
		button.addActionListener(imageButtonListener);
	}
}

public void addGameButtonListener(ActionListener gameButtonListener){
	Enumeration<AbstractButton> buttons = bgGame.getElements();
	while(buttons.hasMoreElements()){
		AbstractButton button = buttons.nextElement();
		button.addActionListener(gameButtonListener);
	}
}

public void addEventButtonListener(ActionListener eventButtonListener){
	for(JCheckBox checkBox: bgEvents){
		checkBox.addActionListener(eventButtonListener);
	}
}

public void addBackGroundButtonListener(ActionListener backgroundButtonListener) {
	Enumeration<AbstractButton> buttons = bgBackgrounds.getElements();
	while (buttons.hasMoreElements()) {
		AbstractButton button = buttons.nextElement();
		button.addActionListener(backgroundButtonListener);
	}
}

public void addReadoutButtonListener(ActionListener readoutButtonListener) {
	Enumeration<AbstractButton> buttons = bgReadouts.getElements();
	while (buttons.hasMoreElements()) {
		AbstractButton button = buttons.nextElement();
		button.addActionListener(readoutButtonListener);
	}
}

//enable the buttons
public void setButtonEnabled() {
	Enumeration<AbstractButton> buttons = bgGame.getElements();
	while(buttons.hasMoreElements()){
		AbstractButton button = buttons.nextElement();
		button.setEnabled(true);
	}
}

//listener for background music
public void addBackGroundMusicButtonListener(ActionListener backgroundMusicButtonListener) {
	Enumeration<AbstractButton> buttons = bgBackgroundMusic.getElements();
	while (buttons.hasMoreElements()) {
		AbstractButton button = buttons.nextElement();
		button.addActionListener(backgroundMusicButtonListener);
	}
}

public void addShooterListener(ActionListener shooterListener){
	actionShooter.addActionListener(shooterListener);
}

public void addDisintegrateListener(ActionListener disintegrateListener){
	disintegrate.addActionListener(disintegrateListener);
}

public void addBlowUpListener(ActionListener blowupListener){
	actionRbBlowUp.addActionListener(blowupListener);
}

public JPanel getImagePanel() {
	return imagePanel;
}

public void setImagePanel(JPanel imagePanel) {
	this.imagePanel = imagePanel;
}

}