package users;
import communications.CommLink.listable;
import communications.Message;
public class Teacher extends Adult implements listable<Teacher> { 
	private static final long serialVersionUID = -4062870041480934701L;
	public Teacher(String UN, String PW, Student[] chldrn, long CID) {
		super(UN, PW, chldrn);
	}
	public Boolean sendMessage(String Message, Person recipient) {
		try {
			new Message(Message, this.getUUID(), recipient.getUUID()).addToSet();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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
	@Override
	public Teacher getFromSet(Long ID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
