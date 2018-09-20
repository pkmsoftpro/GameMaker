package com.game.helpers;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.game.controller.GameController;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.view.GamePlayPanel;

public class DragEventListener implements MouseListener, MouseMotionListener {
	
	private Sprite dragSprite;
	private GamePlayPanel gamePlayPanel;
	private GameModel gameModel;
	private boolean drag = false;
	
	public DragEventListener(GameController gameController){
		this.gamePlayPanel = gameController.getGamePlayPanel();
		this.gameModel = gameController.getGameModel();
	}
	
	private void checkBounds(MouseEvent e){
		if(e.getX() > gamePlayPanel.getWidth() - dragSprite.getSpriteImage().getIconWidth())
			dragSprite.setPosition_X(gamePlayPanel.getWidth() - dragSprite.getSpriteImage().getIconWidth());
		
		if(e.getX() < 0)
			dragSprite.setPosition_X(0);
		
		if(e.getY() > gamePlayPanel.getHeight() - dragSprite.getSpriteImage().getIconHeight())
			dragSprite.setPosition_Y(gamePlayPanel.getHeight() - dragSprite.getSpriteImage().getIconHeight());
		
		if(e.getY() < 0)
			dragSprite.setPosition_Y(0);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(drag){
			dragSprite.setPosition_X(e.getX());
			dragSprite.setPosition_Y(e.getY());
			checkBounds(e);
			gamePlayPanel.repaint();
		}
		

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(Sprite sprite : gameModel.getSpriteList()){
			Rectangle collider = sprite.createCollider();
			if(collider.contains(e.getX(), e.getY())){
				dragSprite = sprite;
				drag = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragSprite = null;
		drag = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public Sprite getDragSprite() {
		return dragSprite;
	}

	public void setDragSprite(Sprite dragSprite) {
		this.dragSprite = dragSprite;
	}

}
