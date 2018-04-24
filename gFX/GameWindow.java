package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import backEnd.GameLogicController;
import engine.CONSTANTS;

public class GameWindow {
	private GameLogicController logicMain;
	private Container C1Container = new Container();
	public GameWindow(GameLogicController GLC) {
		logicMain = GLC;
		GfxCore.CoreFrame.dispose();
		GfxCore.CoreFrame = new JFrame(CONSTANTS._GAME_NAME);
		GfxCore.CoreFrame.setMinimumSize(engine.CONSTANTS._DEFAULT_MINIMUM_WINDOW_SIZE);
		GfxCore.CoreFrame.setLayout(new GridLayout(1,11));
		C1Container.setLayout(new BoxLayout(C1Container,3));
		C1Container.add(new Button("Play"));
		C1Container.add(new Button("Practice"));
		C1Container.add(new Button("Scores"));
		GfxCore.CoreFrame.add(Box.createRigidArea(new Dimension(15,0)));
		GfxCore.CoreFrame.add(C1Container);
		GfxCore.CoreFrame.add(C1Container);
		GfxCore.CoreFrame.setVisible(true);
		
	}	
	public GameLogicController getGLC() {
		return this.logicMain;
	}
	
}
