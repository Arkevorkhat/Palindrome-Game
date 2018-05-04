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

public class PlayWindow {
	GameLogicController GLC;
	Button Y = new Button("Yes");
	Button N = new Button("No");
	Button Nl = new Button("Starts with a Vowel");
	Button S = new Button("Start");
	Container BC = new Container();

	TextField output = new TextField(40);

	public PlayWindow(GameLogicController G) {
		GLC = G;
		Y.setActionCommand("Y");
		N.setActionCommand("N");
		Nl.setActionCommand("O");
		BC.add(Y);
		BC.add(Box.createVerticalGlue());
		BC.add(N);
		output.setEditable(false);
		GfxCore.CoreFrame.removeAll();
		S.addActionListener(new PWButtonListener());
		GfxCore.CoreFrame.setLayout(new GridLayout(1,6));
		GfxCore.CoreFrame.add(S);
		GfxCore.CoreFrame.add(output);
		GfxCore.CoreFrame.revalidate();
		GfxCore.CoreFrame.repaint();
		GfxCore.CoreFrame.setVisible(true);
	}

	public void windowPrep() {
		GfxCore.CoreFrame.removeAll();
		GfxCore.CoreFrame.revalidate();
		GfxCore.CoreFrame.setLayout(new GridLayout(6, 1));
		GfxCore.CoreFrame.add(this.output);
		GfxCore.CoreFrame.add(new Label("Is the above word a palindrome?"));
	}
	
	public void playGame() {
		GfxCore.CoreFrame.remove(S);
		GfxCore.CoreFrame.revalidate();
		BC.add(Y);
		BC.add(Nl);
		BC.add(N);
		GfxCore.CoreFrame.add(BC);
		GfxCore.CoreFrame.repaint();
		GfxCore.CoreFrame.setVisible(true);
	}

	
	public class PWButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (arg0.getActionCommand()) {
			case "Start":
				playGame();
				break;
			case "Y":
				CommLink.loggedInUser.Score += (GLC.check(output.getText()) == true) ? 1 : 0;
				break;
			case "N":
				CommLink.loggedInUser.Score += (GLC.check(output.getText()) == false) ? 1 : 0;
				break;
			case "O":
				switch (output.getText().toUpperCase().charAt(0)) {
				case 'A':
				case 'E':
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
