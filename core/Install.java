package core;

import java.io.*;

import javax.swing.filechooser.FileSystemView;

public class Install {
	private static final String PATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	private static final File storage = new File(
			PATH + File.separatorChar + ".palindromeGame" + File.separatorChar + "storage.xml");

	public static void flowDirs() {
		try {
			if (storage.getAbsoluteFile().getParentFile().mkdirs()) {
				storage.createNewFile();
			} else {
				System.out.println("Directory Already Exists.");
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

	public static File getPathFile() {
		return new File(PATH);
	}

	public static String getPath() {
		return PATH;
	}
}