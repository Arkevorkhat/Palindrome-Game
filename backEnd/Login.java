package backEnd;

import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import communications.CommLink;
import data.Administrator;
import data.Parent;
import data.Person;
import data.Student;
import data.Teacher;

public class Login { // TO DO: Create login sequence and implement session creation.

	public static Session logIn(String Username, String Password) {
		/**
		 * @author Arkev
		 * @return a completed session, if user authentication was successful, otherwise
		 *         null.
		 * @param if
		 *            the username does not refer to a registered user, or if the
		 *            password does not authenticate with that user, null will return.
		 */
		try {
			Person user = Person.findPersonByName(Username);
			if (checkPassword(user, Password) == true) {
				CommLink.loggedInUser = user;
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
		if (interim.getSess().getTimeRemaining().until(
				interim.getSess().getCreateTime().plusMinutes(interim.getSess().getDura().toMinutes()),
				ChronoUnit.MINUTES) > 0) {
			interim.setSess(null);
			JOptionPane.showMessageDialog(null, "You have been logged out successfully.");
			CommLink.loggedInUser = null;
		}
	}

	public static Boolean checkPassword(Person p, String Password) throws IllegalArgumentException {
		/**
		 * @return true if the username and password validate.
		 * @author Arkev
		 * @throws IllegalArgumentException
		 *             if user data does not authenticate.
		 * @param p
		 *            must be properly initialized, else throws exception.
		 * 
		 */
		if (p.hashPW(Password) == p.getPWHash()) {
			return true;
		} else {
			throw new IllegalArgumentException("Invalid Username or Password");
		}
	}

	/*
	 * public static void register() { Object[] uType = { "Student", "Parent",
	 * "Teacher" }; String chosen = (String) JOptionPane.showInputDialog(
	 * (Component) null, "What kind of user would you like to register as?",
	 * "User Type", JOptionPane.DEFAULT_OPTION, null, uType, uType[0] ); String un =
	 * JOptionPane.showInputDialog("Please choose a Username"); String pw =
	 * JOptionPane.showInputDialog(
	 * "Select a Password, Preferably at least 10 letters, and one that you don't use anywhere else."
	 * ); switch (chosen) { case "Student": Integer[] levels = { 1, 2, 3, 4, 5, 6,
	 * 7, 8, 9, 10, 11, 12, 13 }; int GL = (int) JOptionPane.showInputDialog( null,
	 * "What Grade are you in?", "Grade Level", JOptionPane.DEFAULT_OPTION, null,
	 * levels, levels[3] ); new Student(pw, un, GL, (int) ((int) 10d *
	 * Math.log(GL))).addToSet(); break; case "Parent":
	 * JOptionPane.showMessageDialog( null,
	 * "Your account will need to be validated by an administrator, at which time, your children will be associated with you."
	 * ); new Parent(un, pw, null).addToSet(); break; case "Teacher":
	 * JOptionPane.showMessageDialog( null,
	 * "Your account will need to be validated by an administrator, at which time, your class will be assigned."
	 * ); try { new Teacher(un, pw, null, 0l).addToSet(); } catch
	 * (IllegalAccessException e) { e.printStackTrace(); } break; default:
	 * JOptionPane.showMessageDialog( null,
	 * "I... How in the world did you even manage to do that? Turn back, there is only darkness and pain down this road."
	 * ); // Questioning the user's motives is a truly theraputic endeavour for a //
	 * programmer. } }
	 */
	public static void register(String Username, String Password, UserType UT) {
		try {
			if (Username.equals("") || Password.equals("")) {
			} else {
				switch (UT) {
				case Parent:
					new Parent(Username, Password, null).addToSet();
					break;
				case Student:
					new Student(Username, Password, 1, 1).addToSet();
					break;
				case Teacher:
					new Teacher(Username, Password, null, 0).addToSet();
					break;
				default:
					System.out.println("Failed to create user.");
				}
			}
		} catch (IllegalAccessException e) {
			communications.FileHandler.getArrayLists();
			register(Username, Password, UT);
		}
	}

	public static void adminReg() {
		String UN = JOptionPane.showInputDialog("Please choose a Username.");
		String PW = JOptionPane.showInputDialog("Please choose a Password.");
		try {
			new Administrator(UN, PW).addToSet();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public class LoginWindow {
	}
}
