package communications;

import java.io.Serializable;

import communications.CommLink.listable;

public class Message implements Serializable, listable<Message> {
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

	public void addToSet() throws IllegalAccessException {
		if (CommLink.messages.add(this)) {
		} else
			throw new IllegalAccessException();
	}

	@Override
	public Message getFromSet(Long ID) throws IllegalArgumentException {
		for (Message i : CommLink.messages) {
			if (i.getRecUID() == ID) {
				CommLink.messages.remove(i);
				return i;
			} else
				continue;

		}
		throw new IllegalArgumentException();
	}

	public boolean exists() {
		return true;
	}
}
