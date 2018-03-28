package users;
import java.util.ArrayList;

import communications.CommLink.listable;
import communications.Message;
import communications.Message.iMSG;
public class Teacher extends Adult implements iMSG, listable { //TODO: Finish iMSG implementation
	private static final long serialVersionUID = -4062870041480934701L;
	public Teacher(String UN, String PW, ArrayList<Child> chldrn, long CID) {
		super(UN, PW, chldrn);
	}
	public Boolean sendMessage(String Message, Person recipient) {
		
		return null;
	}
	public Message[] getMessages() {
		
		return null;
	}
	public Boolean broadcastMessage(String Message) {
		
		return null;
	}
	public void addToSet() {
		communications.CommLink.teachers.add(this);
	}
}
