package backEnd;

import java.awt.Component;

import javax.swing.JOptionPane;

import users.Child;
import users.Parent;
import users.Teacher;

public class Login { // TODO: Create login sequence and implement session creation.
	public static boolean logIn(String Username, String Password) {
		return true;
	}

	public static void register() {
		Object[] uType = { "Child", "Parent", "Teacher" };
		String chosen = (String) JOptionPane.showInputDialog((Component) null,
				"What kind of user would you like to register as?", "User Type", JOptionPane.DEFAULT_OPTION, null,
				uType, uType[0]);
		String un = JOptionPane.showInputDialog("Please choose a Username");
		String pw = JOptionPane.showInputDialog(
				"Select a Password, Preferably at least 10 letters, and one that you don't use anywhere else.");
		switch (chosen) {
		case "Child":
			Object[] levels = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
			int GL = (int) JOptionPane.showInputDialog(null, "What Grade are you in?", "Grade Level",
					JOptionPane.DEFAULT_OPTION, null, levels, levels[3]);
			new Child(pw, un, GL, (int) ((int) 10d * Math.log10(GL))).addToSet();
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
