package users;

import java.io.Serializable;
import java.util.Random;

import backEnd.Session;

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
							// instatiating a Class object, as such a thing would be... untenable.

	public Person(String UN, String PW) {
		setUN(UN);
		setUUID();
		pwHash = hashPW(PW);
	}

	public Person() {
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

	public long getHash() {
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
}