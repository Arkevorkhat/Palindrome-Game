package communications;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import communications.CommLink;
import data.*;

import javax.swing.filechooser.FileSystemView;

public class FileHandler {
	public static File mainFile = new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
			+ File.separatorChar + ".PalindromeGame"+File.separatorChar);
	/*
	 * The above code requires a bit of explaining. FileSystemView allows for
	 * source-level access to the computer's filesystem.
	 * getFileSystemView().getHomeDirectory().getAbsolutePath() will give back:
	 * Linux: ~/home MacOS: ~/users/<Your Username> Windows: Inconsistent, but often
	 * C:/users/<Your Username>/desktop More obscure operating systems may store
	 * files in other locations.
	 * 
	 * Linux DirPath: ~/home/.PalindromeGame MacOS DirPath:
	 * ~/users/<YourUsername>/.PalindromeGame Windows DirPath:
	 * C:/users/<YourUsername>/desktop/.PalindromeGame
	 */
	// the .g filetype is a serialized bytestream containing the ArrayList object
	// that contains the relevant users.
	public static File children = new File(mainFile.getAbsolutePath() + "1.g");
	public static File parents = new File(mainFile.getAbsolutePath() + "2.g");
	public static File teachers = new File(mainFile.getAbsolutePath() + "3.g");
	public static File messages = new File(mainFile.getAbsolutePath() + "4.g");
	public static File admins = new File(mainFile.getAbsolutePath() + "5.g");
	public static File words = new File(mainFile.getAbsolutePath() + "6.g");
	public static File groups = new File(mainFile.getAbsolutePath() + "7.g");

	public static void init() { // ensures that all file system locations are present.
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
			if (admins.exists() != true) {
				System.out.println(admins.createNewFile());
			}
			if (words.exists() != true) {
				System.out.println(words.createNewFile());
			}
			if (groups.exists() != true) {
				System.out.println(groups.createNewFile());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("resource")
	public static ObjectOutputStream[] getStreams() { // this code returns a set of object output streams that allow for
														// serialization of arrayList objects containing user data.
		try {
			ObjectOutputStream[] output = { new ObjectOutputStream(new FileOutputStream(children)),
					new ObjectOutputStream(new FileOutputStream(parents)),
					new ObjectOutputStream(new FileOutputStream(teachers)),
					new ObjectOutputStream(new FileOutputStream(messages)),
					new ObjectOutputStream(new FileOutputStream(admins)),
					new ObjectOutputStream(new FileOutputStream(words)),
					new ObjectOutputStream(new FileOutputStream(groups)) };
			return output;
		} catch (IOException e) {
			init();
			return getStreams();
		}
	}

	public static boolean serialDump() { // puts all of the arrayLists out to their respective files.
		ObjectOutputStream[] outs = getStreams();
		try {
			outs[0].writeObject(CommLink.students);
			outs[1].writeObject(CommLink.parents);
			outs[2].writeObject(CommLink.teachers);
			outs[3].writeObject(CommLink.messages);
			outs[4].writeObject(CommLink.admins);
			outs[5].writeObject(CommLink.words);
			outs[6].writeObject(CommLink.groups);
			return true;

		} catch (IOException e) {
			e.printStackTrace(System.err);
			return false;
		}

	}

	@SuppressWarnings({ "resource", "unchecked" })
	public static void getArrayLists() {
		try {
			CommLink.students = (ArrayList<Student>) new ObjectInputStream(new FileInputStream(children)).readObject();
			CommLink.parents = (ArrayList<Parent>) new ObjectInputStream(new FileInputStream(parents)).readObject();
			CommLink.teachers = (ArrayList<Teacher>) new ObjectInputStream(new FileInputStream(teachers)).readObject();
			CommLink.messages = (ArrayList<Message>) new ObjectInputStream(new FileInputStream(messages)).readObject();
			CommLink.admins = (ArrayList<Administrator>) new ObjectInputStream(new FileInputStream(admins))
					.readObject();
			CommLink.groups = (ArrayList<Group>) new ObjectInputStream(new FileInputStream(groups)).readObject();
			CommLink.words = (ArrayList<Word>) new ObjectInputStream(new FileInputStream(words)).readObject();
		} catch (IOException e) {
			init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.err);
		}
	}
}