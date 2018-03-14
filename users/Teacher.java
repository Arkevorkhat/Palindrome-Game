package users;
import communications.Message;
import communications.Message.iMSG;
public class Teacher extends Adult implements iMSG {
	private long ClassID;
	public Teacher(String UN, String PW, Child[] chldrn, long CID) {
		super(UN, PW, chldrn);
		setClassID(CID);
		// TODO Auto-generated constructor stub
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
		
		return null;
	}
	public long getClassID() {
		return ClassID;
	}
	public void setClassID(long classID) {
		ClassID = classID;
	}

}
