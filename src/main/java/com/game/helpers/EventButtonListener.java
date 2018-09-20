package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import org.apache.log4j.Logger;

import com.game.model.GameModel;

public class EventButtonListener implements ActionListener {
	
	private static Logger eventLog = Logger.getLogger("eventLogger");
	private GameModel gameModel;
	
	public EventButtonListener(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case Constants.SIDES:
			eventLog.info("Sides selected");
			setHorizontalMotion(((JCheckBox) (e.getSource())).isSelected());
			break;
		case Constants.UPDOWN:
			eventLog.info("Updown selected");
			setVerticalMotion(((JCheckBox) (e.getSource())).isSelected());
			break;
		case Constants.COLLISION:
			eventLog.info("Collision selected");
			setCollision(((JCheckBox) (e.getSource())).isSelected());
			break;
		case Constants.NOBOUND:
			eventLog.info("No Bounds selected");
			setNoBoundsMotion(((JCheckBox) (e.getSource())).isSelected());
			break;
		}

	}
	
	public void setHorizontalMotion(boolean horizontalMotion){
		gameModel.getGameSprite().setHorizontal(horizontalMotion);
	}
	
	public void setVerticalMotion(boolean verticalMotion){
		gameModel.getGameSprite().setVertical(verticalMotion);
	}
	
	public void setCollision(boolean collision){
		gameModel.getGameSprite().setCollidable(collision);
	}
	
	public void setNoBoundsMotion(boolean noBounds){
		gameModel.getGameSprite().setNoBounds(noBounds);
	}

}
