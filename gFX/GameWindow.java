package gFX;

import javax.swing.JFrame;

import backEnd.GameLogicController;
import engine.CONSTANTS;

public class GameWindow {
	private GameLogicController logicMain;
	public GameWindow(GameLogicController GLC) {
		logicMain = GLC;
		GfxCore.CoreFrame = new JFrame(CONSTANTS._GAME_NAME);
		
	}
	
}
