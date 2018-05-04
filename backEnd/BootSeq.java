package backEnd;

import communications.CommLink;
import gFX.GameWindow;
import gFX.MainWindow;

public class BootSeq extends CommLink {
	public static boolean boot()
	{
		communications.FileHandler.init();
		communications.FileHandler.getArrayLists();
		//new MainWindow().init();
		new GameWindow(new Palindrome());
		return true;
	}
}
