package communications;

import communications.Message;
import java.io.*;
import java.util.*;
import org.jdom2.*;

@SuppressWarnings("unused")
public class MsgFileIO extends CommLink implements CommIO<Message> {
	private Message[] messages;

	public void pushToFile() {
		// TODO Implement XML node addition

	}

	public Message getByID(long ID) {
		// TODO Implement XML Parsing

		return new Message(null, ID);
	}
}
