package core;

import java.io.*;

import javax.swing.filechooser.FileSystemView;

public class Install {
	public static String PATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	private static File storage = new File(PATH + File.separatorChar + ".palindromeGame" + File.separatorChar + "storage.xml");
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