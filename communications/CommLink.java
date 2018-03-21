package communications;

import java.util.HashSet;
import java.util.Random;

import users.*;

public class CommLink {
	public static HashSet<Child> children;
	public static HashSet<Parent> parents;
	public static HashSet<Teacher> teachers;
	public static HashSet<Message> messages;
	public long lastID;

	public void init() {
		Random r = new Random();
		lastID = r.nextLong();
	}
}
