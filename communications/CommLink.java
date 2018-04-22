package communications;

import java.util.ArrayList;

import data.*;

public abstract class CommLink {

	public static ArrayList<Student> students;
	public static ArrayList<Parent> parents;
	public static ArrayList<Teacher> teachers;
	public static ArrayList<Message> messages;
	public static ArrayList<Word> words;
	public static ArrayList<Administrator> admins;
	public static ArrayList<Group> groups;
	public static Person loggedInUser;
	static {
		students = new ArrayList<Student>();
		parents = new ArrayList<Parent>();
		teachers = new ArrayList<Teacher>();
		messages = new ArrayList<Message>();
		words = new ArrayList<Word>();
		admins = new ArrayList<Administrator>();
		groups = new ArrayList<Group>();
		loggedInUser = new Person();
	}

	public static interface listable<T> {
		public void addToSet() throws IllegalAccessException;

		public Object getFromSet(long ID) throws IllegalArgumentException;
	}
}
