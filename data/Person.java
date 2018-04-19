package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import backEnd.Login;
import backEnd.Session;
import communications.CommLink;
import communications.Message;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062870041480934701L;
	public String username;
	private long salt; // Yes, Salted Hashes, i know it's overkill.
	private long pwHash;
	private long UID;
	private Session sess;
	private long ClassID; // allows for associating a person with a particular class group, without
							// instantiating a Class object, as such a thing would be... untenable.

	public Person(String UN, String PW) {
		setUN(UN);
		setUUID();
		pwHash = hashPW(PW);
	}

	public Person() {
	}
	public boolean exists() {
		return true;
	}
	@Deprecated
	/*public Message[] getMessages() throws NoSuchElementException {
		Message[] storage = {};
		int j = 0;
		for (Message i : CommLink.messages) {
			if (i.getRecUID() == this.getUUID()) {
				storage[j++] = i;
			}
		}
		if (j > 0) {
			return storage;
		} else
			throw new NoSuchElementException();
	}*/

	public Boolean sendMessage(String Message, Person recipient) {
		return null;
	}

	@Deprecated
	public static Person makePerson(String UN, String PW) { // this really needs to just be a constructor.
		Person temp = new Person();
		temp.setUN(UN);
		temp.setUUID();
		temp.pwHash = temp.hashPW(PW);
		return temp;
	}

	private void setUN(String username) {
		this.username = username;
	}

	public long hashPW(String pass) { // makes a salted hash for the user's password, required for functional
										// sessions.
		if (this.salt != 0) {
			return (pass + Long.toString(salt)).hashCode();
		} else {
			setSalt();
			return hashPW(pass);
		}

	}

	private void setSalt() { // this creates a salt value for the user upon which the setSalt method was
								// called. salts are appended to the end of a password string in order to allow
								// for more secure password storage, as the storage file does not actually
								// contain plaintext or serialized passwords.

		Random r = new Random();
		this.salt = r.nextLong();
	}

	private void setUUID() { // this could reasonably be two lines inside of the constructor, however, this
								// is how i chose to write the method.
		Random r = new Random();
		this.UID = r.nextLong();
	}

	public long getUUID() {
		return this.UID;
	}

	public long getPWHash() {
		return this.pwHash;
	}

	public Session getSess() {
		return sess;
	}

	public void setSess(Session sess) {
		this.sess = sess;
	}

	public long getClassID() {
		return ClassID;
	}

	public void setClassID(long classID) {
		ClassID = classID;
	}

	public void resetPassword() {
		String oldPass = JOptionPane.showInputDialog("What was your old password?");
		if (Login.checkPassword(this, oldPass) == true) {
			this.pwHash = this.hashPW(JOptionPane.showInputDialog("What would you like your new password to be?"));
		}
	}

	public static Person findPersonByName(String Username) throws IllegalArgumentException {
		for (Student i : CommLink.students) {
			if (i.username.equals(Username)) {
				return i;
			}
		}
		for (Parent i : CommLink.parents) {
			if (i.username.equals(Username)) {
				return i;
			}
		}
		for (Teacher i : CommLink.teachers) {
			if (i.username.equals(Username)) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
	public Message[] getMessages() {
		ArrayList<Message> Messages = new ArrayList<Message>();
		for (Message m : CommLink.messages) {
			if (m.getRecUID() == this.getUUID()) {
				Messages.add(m);
				CommLink.messages.remove(m);
			}
		}
		return (Message[]) Messages.toArray();
	}
}