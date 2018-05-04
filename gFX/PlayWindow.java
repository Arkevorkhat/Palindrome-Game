package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import backEnd.GameLogicController;
import communications.CommLink;
import engine.CONSTANTS;

public class PlayWindow {
	static GameLogicController GLC;
	static Button Y = new Button("Yes");
	static Button N = new Button("No");
	static Button Nl = new Button("Null");
	static Button S = new Button("Start");
	static Container BC = new Container();

	static TextField output = new TextField(40);

	public PlayWindow(GameLogicController G) {
		GLC = G;
		Y.setActionCommand("Y");
		N.setActionCommand("N");
		Nl.setActionCommand("O");
		BC.add(Y);
		BC.add(Box.createVerticalGlue());
		BC.add(N);
		output.setEditable(false);
		windowPrep();
		S.addActionListener(new PWButtonListener());
		GfxCore.CoreFrame.add(S);
		GfxCore.CoreFrame.setVisible(true);
	}

	public static void windowPrep() {
		WindowFactory.makeWindow(CONSTANTS._GAME_NAME);
		GfxCore.CoreFrame.setLayout(new GridLayout(6, 1));
		GfxCore.CoreFrame.add(output);
		GfxCore.CoreFrame.add(new Label("Is the above word a palindrome?"));
	}

	private class PWButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (arg0.getActionCommand()) {
			case "Start":
				windowPrep();
				GfxCore.CoreFrame.add(BC);
				GfxCore.CoreFrame.setVisible(true);
				break;
			case "Y":
				CommLink.loggedInUser.Score += (GLC.check(output.getText())==true)?1:0;
				break;
			case "N":
				CommLink.loggedInUser.Score += (GLC.check(output.getText())==false)?1:0;
				break;
			case "O":
				switch(output.getText().toUpperCase().charAt(0)) {
				case'A':
				case'E':
				case 'I':
				case 'O':
				case 'U':
					CommLink.loggedInUser.Score++;
					break;
				default:
					break;
				}
				break;
			}
		}
	}
}
