package users;

import java.util.Random;

import core.Session;

public class Person implements Serializable{
	
	public String username;
	private long salt; // Yes, Salted Hashes, i know it's overkill.
	private long pwHash;
	private long UID;
	private Session sess;
	public Person(String UN, String PW) {
		setUN(UN);
		setUUID();
		pwHash = hashPW(PW);
	}

	public Person() {
	}

	public static Person makePerson(String UN, String PW) {
		Person temp = new Person();
		temp.setUN(UN);
		temp.setUUID();
		temp.pwHash = temp.hashPW(PW);
		return temp;
	}

	private void setUN(String username) {
		this.username = username;
	}

	public long hashPW(String pass) {
		if (this.salt != 0) {
			return (pass + Long.toString(salt)).hashCode();
		} else {
			setSalt();
			return hashPW(pass);
		}

	}

	private void setSalt() {
		Random r = new Random();
		this.salt = r.nextLong();
	}

	private void setUUID() {
		Random r = new Random();
		this.UID = r.nextLong();
	}

	public long getUUID() {
		return this.UID;
	}
}