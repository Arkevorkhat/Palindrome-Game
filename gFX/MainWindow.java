package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JFrame;
import backEnd.EventListener;
import backEnd.KeyListener;
import gFX.GfxCore.iWindow;

public class MainWindow implements iWindow {
	private static TextField TF = new TextField(10);
	private static Container GL = new Container();
	private static Button loginButton = new Button("Login");
	private static Button guestButton = new Button("Continue as Guest");
	public MainWindow() {
		TF.addKeyListener(new KeyListener());
		loginButton.addActionListener(new EventListener());
	}
	public void init()
	{
		GfxCore.CoreFrame.setTitle(engine.CONSTANTS._GAME_NAME);
		GfxCore.CoreFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GfxCore.CoreFrame.addWindowListener(new engine.WindowCloseOperation());
		GfxCore.CoreFrame.setMinimumSize(new Dimension(600, 400));
		GfxCore.CoreFrame.setLayout(new GridLayout(2, 1));
		GfxCore.CoreFrame.add(TF);
		GL.setLayout(new GridLayout(1, 2));
		GfxCore.CoreFrame.add(GL);
		GL.add(loginButton);
		GL.add(guestButton);
		GfxCore.CoreFrame.setVisible(true);
	}
}
