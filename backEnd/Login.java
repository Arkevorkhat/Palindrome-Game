package backEnd;

import java.awt.Component;
import java.time.temporal.TemporalField;

import javax.swing.JOptionPane;

import users.Student;
import users.Parent;
import users.Person;
import users.Teacher;

public class Login { // TODO: Create login sequence and implement session creation.
	public static Session logIn(String Username, String Password) {
		/**
		 * @author Arkev
		 * @return a completed session, if user authentication was successful, otherwise null.
		 * @param if  the username does not refer to a registered user, or if the password does not authenticate with that user, null will return.
		 */
		try {
			Person user = Person.findPersonByName(Username);
			if (checkPassword(user, Password) == true) {
				return new Session(Username, 0);
			} else
				return null;
		} catch (IllegalArgumentException e) {
			System.out.println("Login Failed: " + e.getMessage());
			return null;
		}	
	}
	public static void logOut(String Username) {
		Person interim = Person.findPersonByName(Username);
		if (interim.getSess().getTimeRemaining().getLong((TemporalField) interim.getSess().getTimeRemaining())>0) {
			interim.setSess(null);
			JOptionPane.showConfirmDialog(null, "You have been logged out successfully.");
		}		
	}
	public static Boolean checkPassword(Person p, String Password) throws IllegalArgumentException { 
		/**
		 * @return true if the username and password validate.
		 * @author Arkev
		 * @throws IllegalArgumentException if user data does not authenticate.
		 * @param p must be properly initialized, else throws exception.
		 * 
		 */
		if (p.hashPW(Password) == p.getPWHash()) {
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void register() {
		Object[] uType = { "Student", "Parent", "Teacher" };
		String chosen = (String) JOptionPane.showInputDialog((Component) null,
				"What kind of user would you like to register as?", "User Type", JOptionPane.DEFAULT_OPTION, null,
				uType, uType[0]);
		String un = JOptionPane.showInputDialog("Please choose a Username");
		String pw = JOptionPane.showInputDialog(
				"Select a Password, Preferably at least 10 letters, and one that you don't use anywhere else.");
		switch (chosen) {
		case "Student":
			Integer[] levels = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
			int GL = (int) JOptionPane.showInputDialog(null, "What Grade are you in?", "Grade Level",
					JOptionPane.DEFAULT_OPTION, null, levels, levels[3]);
			new Student(pw, un, GL, (int) ((int) 10d * Math.log(GL))).addToSet();
			break;
		case "Parent":
			JOptionPane.showMessageDialog(null,
					"Your account will need to be validated by an administrator, at which time, your children will be associated with you.");
			new Parent(un, pw, null).addToSet();
			break;
		case "Teacher":
			JOptionPane.showMessageDialog(null,
					"Your account will need to be validated by an administrator, at which time, your class will be assigned.");
			new Teacher(un, pw, null, 2).addToSet();
			break;
		default:
			JOptionPane.showMessageDialog(null,
					"I... How in the world did you even manage to do that? Turn back, there is only darkness and pain down this road.");
			// Questioning the user's motives is a truly theraputic endeavour for a
			// programmer.
		}
	}
}
