package backEnd;

import communications.CommLink;
import gFX.MainWindow;

public class BootSeq extends CommLink {
	public static boolean boot()
	{
		communications.FileHandler.getArrayLists();
		new MainWindow().init();
		return true;
	}
}
