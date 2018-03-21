package communications;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.filechooser.FileSystemView;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

public class FileHandler {
	public static File mainFile = new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
			+ File.separatorChar + ".PalindromeGame");

	public static void init() {
		System.out.println(mainFile.getParentFile().mkdirs());
		System.out.println(mainFile);
		try {
			if (children.exists() != true) {
				System.out.println(children.createNewFile());
			}
			if (parents.exists() != true) {
				System.out.println(parents.createNewFile());
			}
			if (teachers.exists() != true) {
				System.out.println(teachers.createNewFile());
			}
			if (messages.exists() != true) {
				System.out.println(messages.createNewFile());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static File children = new File(mainFile.getAbsolutePath() + "1.pg");
	public static File parents = new File(mainFile.getAbsolutePath() + "2.pg");
	public static File teachers = new File(mainFile.getAbsolutePath() + "3.pg");
	public static File messages = new File(mainFile.getAbsolutePath() + "4.pg");

	public static enum streams {
		CHILDREN, PARENTS, TEACHERS, MESSAGES
	}

	public static ObjectOutputStream[] getStreams() {
		try {
			ObjectOutputStream[] output = { new ObjectOutputStream(new FileOutputStream(children)),
					new ObjectOutputStream(new FileOutputStream(parents)),
					new ObjectOutputStream(new FileOutputStream(teachers)),
					new ObjectOutputStream(new FileOutputStream(messages)) };
			return output;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static boolean serialDump() {
		ObjectOutputStream[] outs = getStreams();
		try {
			outs[0].writeObject(CommLink.children);
			outs[1].writeObject(CommLink.parents);
			outs[2].writeObject(CommLink.teachers);
			outs[3].writeObject(CommLink.messages);
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}