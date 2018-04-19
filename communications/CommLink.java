package communications;

import java.util.ArrayList;

import data.*;

public abstract class CommLink {

	public static ArrayList<Student> students;
	public static ArrayList<Parent> parents;
	public static ArrayList<Teacher> teachers;
	public static ArrayList<Message> messages;
	//public static ArrayList<>
	public static ArrayList<Administrator> admins;
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> people = new ArrayList<ArrayList>();
	static {
		people.add(students);
		people.add(parents);
		people.add(teachers);
		people.add(admins);
	}
	public static interface listable<T> {
		public void addToSet() throws IllegalAccessException;

		public T getFromSet(long ID) throws IllegalArgumentException;
	}
}
