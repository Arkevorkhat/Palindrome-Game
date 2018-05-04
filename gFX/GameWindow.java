package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import backEnd.GameLogicController;
import backEnd.Palindrome;
import communications.CommLink;
import engine.CONSTANTS;
import engine.WindowCloseOperation;

public class GameWindow {
	private GameLogicController logicMain;
	private Container C1Container = new Container();
	private Button PlB = new Button("Play");
	private Button PrB = new Button("Practice");
	private Button SB = new Button("Scores");
	private Button AB = new Button("Admin");
	private Dimension spacing = new Dimension(0, 80);
	private Container C11Container = new Container();

	public GameWindow(GameLogicController GLC) {
		logicMain = GLC;
		GfxCore.CoreFrame.dispose();
		GfxCore.CoreFrame = new JFrame(CONSTANTS._GAME_NAME);
		GfxCore.CoreFrame.setMinimumSize(CONSTANTS._DEFAULT_MINIMUM_WINDOW_SIZE);
		GfxCore.CoreFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GfxCore.CoreFrame.addWindowListener(new WindowCloseOperation());
		GfxCore.CoreFrame.setLayout(new GridLayout(1, 3));
		C1Container.setLayout(new BoxLayout(C1Container, BoxLayout.Y_AXIS));
		C1Container.add(Box.createRigidArea(spacing));
		C1Container.add(PlB);
		C1Container.add(Box.createRigidArea(spacing));
		C1Container.add(PrB);
		C1Container.add(Box.createRigidArea(spacing));
		C1Container.add(SB);
		C1Container.add(Box.createRigidArea(spacing));
		if (CommLink.loggedInUser.isAdmin == true) {
			C1Container.add(AB);
		}
		Container C2Container = new Container();
		C2Container.setLayout(new GridLayout(1, 3));
		GfxCore.CoreFrame.add(C1Container);
		GfxCore.CoreFrame.setVisible(true);
	}

	public GameLogicController getGLC() {
		return this.logicMain;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (arg0.getActionCommand()) {
			case "Play":
				new PlayWindow(new Palindrome());
			}
		}

	}
}
