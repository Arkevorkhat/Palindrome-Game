package backEnd;

import communications.CommLink;
import users.*;

public class BootSeq {
	public static boolean boot() {
		if (CommLink.children.size()<1) {
			CommLink.children.add(new Child("Admin", "administrator", 100,13));
		}
		if (CommLink.parents.size()<1) {
			CommLink.parents.add(new Parent(null, null, CommLink.children));
		}
		return true;
	}
}
