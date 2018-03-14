package users;

import communications.Message;
import communications.Message.iMSG;

public class Parent extends Adult implements iMSG {

	public Parent(String UN, String PW, Child[] chldrn) {
		super(UN, PW, chldrn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean sendMessage(String Message, Person recipient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message[] getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean broadcastMessage(String Message) {
		System.err.println("user.parent.AccessDeniedException");
		return false;
	}

}
