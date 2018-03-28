package users;

import java.io.Serializable;
import java.util.ArrayList;

import communications.CommLink.listable;
import communications.Message;
import communications.Message.iMSG;

public class Parent extends Adult implements iMSG, Serializable, listable {
	private static final long serialVersionUID = -4062870041480934701L;

	public Parent(String UN, String PW, ArrayList<Child> children) {
		super(UN, PW, children);
	}

	@Override
	public Boolean sendMessage(String Message, Person recipient) {
		return null;
	}

	@Override
	public Message[] getMessages() {
		return null;
	}

	@Deprecated
	public Boolean broadcastMessage(String Message) {
		System.err.println("user.parent.AccessDeniedException");
		return false;
	}

	public void addToSet() {
		communications.CommLink.parents.add(this);
	}
}
