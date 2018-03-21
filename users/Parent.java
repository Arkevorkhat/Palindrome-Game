package users;

import java.io.Serializable;

import communications.Message;
import communications.Message.iMSG;

public class Parent extends Adult implements iMSG, Serializable{

	public Parent(String UN, String PW, Child[] chldrn) {
		super(UN, PW, chldrn);
	}

	@Override
	public Boolean sendMessage(String Message, Person recipient) {
		return null;
	}

	@Override
	public Message[] getMessages() {
		return null;
	}

	@Override
	public Boolean broadcastMessage(String Message) {
		System.err.println("user.parent.AccessDeniedException");
		return false;
	}
	public void addToSet() {
		communications.CommLink.parents.add(this);
	}
}
