package communications;

import java.io.Serializable;

import communications.CommLink.listable;
import users.Person;

public class Message implements Serializable, listable {
	public interface iMSG {
		public Boolean sendMessage(String Message, Person recipient);

		public Message[] getMessages();

		public Boolean broadcastMessage(String Message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public long getRecUID() {
		return this.recipientUID;
	}

	public void addToSet() {
		CommLink.messages.add(this);
	}
}
