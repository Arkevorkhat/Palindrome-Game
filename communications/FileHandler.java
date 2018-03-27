package communications;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import communications.CommLink;
import users.Child;
import users.Parent;
import users.Teacher;

import javax.swing.filechooser.FileSystemView;

public class FileHandler {
	public static File mainFile = new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
			+ File.separatorChar + ".PalindromeGame");
	/*
	 * The above code requires a bit of explaining.
	 * FileSystemView allows for source-level access to the computer's filesystem.
	 * getFileSystemView().getHomeDirectory().getAbsolutePath() will give back:
	 * Linux: ~/home
	 * MacOS: ~/users/<Your Username>
	 * Windows: Inconsistent, but often C:/users/<Your Username>/desktop
	 * More obscure operating systems may store files in other locations.
	 * 
	 * Linux DirPath: ~/home/.PalindromeGame
	 * MacOS DirPath: ~/users/<Your Username>/.PalindromeGame
	 * Windows DirPath: C:/users/<Your Username>/desktop/.PalindromeGame
	 */

	public static void init() { //ensures that all file system locations are present.
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

	public static File children = new File(mainFile.getAbsolutePath() + "1.pg"); //the .pg filetype is a serialized bytestream containing the ArrayList object that contains the relevant users.
	public static File parents = new File(mainFile.getAbsolutePath() + "2.pg");
	public static File teachers = new File(mainFile.getAbsolutePath() + "3.pg");
	public static File messages = new File(mainFile.getAbsolutePath() + "4.pg");

	@SuppressWarnings("resource")
	public static ObjectOutputStream[] getStreams() { //this code returns a set of object output streams that allow for serialization of arrayList objects containing user data.
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

	public static boolean serialDump() { //puts all of the arrayLists out to their respective files.
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

	@SuppressWarnings({ "resource", "unchecked" })
	public static void getArrayLists() throws ClassNotFoundException {
		try {
			CommLink.children = (ArrayList<Child>) new ObjectInputStream(new FileInputStream(children))
					.readObject();
			CommLink.parents = (ArrayList<Parent>) new ObjectInputStream(new FileInputStream(parents)).readObject();
			CommLink.teachers = (ArrayList<Teacher>) new ObjectInputStream(new FileInputStream(teachers))
					.readObject();
			CommLink.messages = (ArrayList<Message>) new ObjectInputStream(new FileInputStream(messages)).readObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}