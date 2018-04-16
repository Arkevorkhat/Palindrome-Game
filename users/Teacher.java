package users;
import communications.CommLink.listable;
import communications.CommLink;
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
	public Boolean broadcastMessage(String message) { //FIXME: add valid return statement.
		for(Student i : CommLink.students) {
			try {
				new Message(message,i.getUUID(),this.getUUID()).addToSet();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public void addToSet() {
		communications.CommLink.teachers.add(this);
	}
	@Override
	public Teacher getFromSet(long ID) throws IllegalArgumentException {
		for (Teacher i : CommLink.teachers) {
			if(i.getUUID()==ID) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
}
