package communications;

import java.util.ArrayList;
import users.*;

public abstract class CommLink {
	public static ArrayList<Student> students;
	public static ArrayList<Parent> parents;
	public static ArrayList<Teacher> teachers;
	public static ArrayList<Message> messages;
	public static ArrayList<Administrator> admins;
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> people = new ArrayList<ArrayList>();
	public abstract void init();
	
	public static interface listable<T> {
		public void addToSet() throws IllegalAccessException;
		public T getFromSet(long ID) throws IllegalArgumentException;
	}
}
	