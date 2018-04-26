package engine;

import java.io.*;

public class Install {
	private static File storage = new File(CONSTANTS.PATH + File.separatorChar + ".palindromeGame" + File.separatorChar + "storage");
	public static void flowDirs() {
		try {
			if (storage.getAbsoluteFile().getParentFile().mkdirs()) {
				storage.createNewFile();
			}
			else {
				System.out.println("Path Already Exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static File getStorageFile() {
		return storage;
	}
	public static String getStorage() {
		return storage.getPath();
	}
}