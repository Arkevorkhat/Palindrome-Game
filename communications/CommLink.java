package communications;

import java.util.ArrayList;
import users.*;

public abstract class CommLink {
	public static ArrayList<Child> children;
	public static ArrayList<Parent> parents;
	public static ArrayList<Teacher> teachers;
	public static ArrayList<Message> messages;
	public abstract void init();
	public interface listable{
		public void addToSet();
		
	}
}
