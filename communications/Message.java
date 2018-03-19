package communications;

import users.Person;

public class Message extends CommLink {
	private String msg;
	private long senderUID;
	private long recipientUID;

	public Message(String message, long UID, long UID2) { // UID: User IDentifier
		msg = message;
		senderUID = UID;
		recipientUID = UID2;
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
