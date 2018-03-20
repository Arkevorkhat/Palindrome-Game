package core;

import communications.FileHandler;

/*
 * Todos are closed by replacing "todo" with TO DO.
 */
public class PalindromeGame {
	/*
	 * This file should contain ONLY the main method. all other methods should be
	 * defined in one of the other sections of the program; either gFX or logic.
	 * TODO: create main method logic.
	 */
	public static void main(String[] args) {
		Install.flowDirs();
		System.out.println(communications.FileHandler.generateFile());
	}
}
