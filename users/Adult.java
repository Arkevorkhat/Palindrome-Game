package users;
import users.Child;
public class Adult extends Person{
	Child[] children;
	public Adult(String UN, String PW, Child[] chldrn) {
		super(UN, PW);
		children = chldrn;
	}	
	
}