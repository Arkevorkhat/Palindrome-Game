package users;

import java.util.Random;

public class Person {
	public Person(String UN, String PW) {
		setUN(UN);
		setUUID();
		pwHash = hashPW(PW);
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public static Person makePerson(String UN, String PW) {
		Person temp = new Person();
		temp.setUN(UN);
		temp.setUUID();
		temp.pwHash=temp.hashPW(PW);
		return temp;
	}

	public String username;
	private long salt; // Yes, Salted Hashes, i know it's overkill.
	private long pwHash;
	private long UID;

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

	public Boolean validateLogin(String PW) {
		long storage = (PW + Long.toString(salt)).hashCode();
		if (storage == pwHash) {
			return true;
		} else
			return false;
	}
}