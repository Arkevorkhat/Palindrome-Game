package communications;

import communications.Message;
import java.io.*;
import java.util.*;
import org.jdom2.*;

@SuppressWarnings("unused")
public class MsgFileIO extends FileHandler implements CommIO<Message> {
	private Message[] messages;

	public void pushToTree() { //uses JDOM2, www.JDOM.org
		// TODO Implement XML node addition

	}

	public Message getByID(long ID) {//uses JDOM2, WWW.jdom.org
		Document stor = FileHandler.getDoc();
		List<Element> msgIDs = stor.getRootElement().getChildren("ID");
		for(int i=0;i<msgIDs.size();i++) {
			if (msgIDs.get(i).getContent().get(0).equals(ID)) {
				
			}
		}
		return null;
	}
}
