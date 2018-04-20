package engine;

//import communications.FileHandler;
import gFX.GfxCore;

/*
 * Todos are closed by replacing "todo" with TO DO.
 */
public class Core {
	public static final String _VERSION = "1.0.2";
	public static final String _GAME_NAME = "NULL"; //FIXME: set game name.

	/*
	 * This file should contain ONLY the main method. all other methods should be
	 * defined in one of the other sections of the program; gfx, backEnd, engine,
	 * communications, or users. 
	 * TODO: create main method logic.
	 */
	public static void main(String[] args) {
		//FileHandler.init();
		//FileHandler.serialDump();
		GfxCore.init();
	}
}
