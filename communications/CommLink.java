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
	static {
		students = new ArrayList<Student>();
		parents = new ArrayList<Parent>();
		teachers = new ArrayList<Teacher>();
		messages = new ArrayList<Message>();
		words = new ArrayList<Word>();
		admins = new ArrayList<Administrator>();
		groups = new ArrayList<Group>();
	}

	public static interface listable<T> {
		public void addToSet() throws IllegalAccessException;

		public T getFromSet(long ID) throws IllegalArgumentException;
	}
}
