package engine;

import communications.FileHandler;

/*
 * Todos are closed by replacing "todo" with TO DO.
 */
public class Core {
	public static final String _VERSION = "0.13.0";
	public static final String _GAME_NAME = "Palindrome";

	/*
	 * This file should contain ONLY the main method. all other methods should be
	 * defined in one of the other sections of the program; gfx, backEnd, engine,
	 * communications, or users. 
	 * TODO: create main method logic.
	 */
	public static void main(String[] args) {
		FileHandler.init();
		FileHandler.serialDump();
	}
}
