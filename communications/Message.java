package communications;

import users.Person;

public class Message extends CommLink {
	private String msg;
	private long senderUID;

	public Message(String message, long UID) { // UID: User IDentifier
		this.msg = message;
		this.senderUID = UID;
	}

	public String getMessage() {
		return this.msg;
	}

	public long getSenderUID() {
		return this.senderUID;
	}
	public interface iMSG{
		public Boolean sendMessage(String Message, Person recipient);
		public Message[] getMessages();
		public Boolean broadcastMessage(String Message);
	}
}
