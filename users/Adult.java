package users;
import java.util.ArrayList;

import users.Child;
public class Adult extends Person{
	private static final long serialVersionUID = -4062870041480934701L;
	Child[] children;
	public Adult(String UN, String PW, ArrayList<Child> children2) {
		super(UN, PW);
		children = (Child[]) children2.toArray();
	}	
	
}