package users;

import java.util.Random;

import org.jdom2.Document;
import org.jdom2.Element;

import communications.FileHandler;
import core.Session;

public class Person {
	UserTypes self;

	public Person(String UN, String PW, UserTypes ut) {
		setUN(UN);
		setUUID();
		pwHash = hashPW(PW);
		self = ut;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public static Person makePerson(String UN, String PW) {
		Person temp = new Person();
		temp.setUN(UN);
		temp.setUUID();
		temp.pwHash = temp.hashPW(PW);
		return temp;
	}

	public String username;
	private long salt; // Yes, Salted Hashes, i know it's overkill.
	private long pwHash;
	private long UID;

	private void setUN(String username) {
		this.username = username;
	}

	public Element getIDElement() {
		Element UID = new Element("UID").addContent(Long.toString(this.UID));
		UID.addContent(new Element("PWHash").addContent(Long.toString(this.pwHash)));
		UID.addContent(new Element("salt").addContent(Long.toString(this.salt)));
		UID.addContent(new Element("Username").addContent(this.username));
		UID.addContent(new Element("Other").addContent(new Element("Type").addContent(this.self.name())));
		return UID;
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

	private Boolean validatePassword(String PW) {
		long storage = (PW + Long.toString(salt)).hashCode();
		if (storage == pwHash) {
			return true;
		} else
			return false;
	}
	public static Session login(long UID, String PW) {
		Document storage = communications.FileHandler.getDoc();
		Element user = storage.getContent((int)UID);
		
	}
}