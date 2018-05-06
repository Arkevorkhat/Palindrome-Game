package gFX;

import javax.swing.JFrame;

import engine.CONSTANTS;
import engine.WindowCloseOperation;

public class WindowFactory {
	public static void makeWindow() {
		GfxCore.CoreFrame = new JFrame();
		GfxCore.CoreFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GfxCore.CoreFrame.addWindowListener(new WindowCloseOperation());
		GfxCore.CoreFrame.setMinimumSize(CONSTANTS._DEFAULT_MINIMUM_WINDOW_SIZE);
	}
	public static void makeWindow(String name) {
		makeWindow();
		GfxCore.CoreFrame.setTitle(name);
	}
}
