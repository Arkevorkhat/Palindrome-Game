package backEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
