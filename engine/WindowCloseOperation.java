	package engine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import communications.CommLink;
import communications.FileHandler;

public class WindowCloseOperation implements WindowListener {
	@Override
	public void windowActivated(WindowEvent arg0)
	{
	}
	@Override
	public void windowClosed(WindowEvent arg0)
	{
	}
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if (CommLink.loggedInUser.getUUID() != 0)
		{
			backEnd.Login.logOut(CommLink.loggedInUser.username);
		}
		FileHandler.serialDump();
		arg0.getWindow().dispose();
	}
	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
	}
	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
	}
	@Override
	public void windowIconified(WindowEvent arg0)
	{
	}
	@Override
	public void windowOpened(WindowEvent arg0)
	{
	}
}
