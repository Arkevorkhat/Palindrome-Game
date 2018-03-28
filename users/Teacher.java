package users;
import communications.CommLink.listable;
import communications.Message;
import communications.Message.iMSG;
public class Teacher extends Adult implements iMSG, listable { 
	private static final long serialVersionUID = -4062870041480934701L;
	public Teacher(String UN, String PW, Student[] chldrn, long CID) {
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
