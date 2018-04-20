package backEnd;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import gFX.LoginWindow;

public class EventListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
		case "Login":
			new LoginWindow();
			break;
		default:
			System.err.printf(
					"Please send an Error Report to mailto://CIST4A1G3@Outlook.com containing: Invalid button event: %s",
					e.getActionCommand()
			);
		}
	}
}
