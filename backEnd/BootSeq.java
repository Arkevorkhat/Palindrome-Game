package backEnd;

import communications.CommLink;

public class BootSeq extends CommLink {
	public static boolean boot() {
		
		return true;
	}
	public void init() {
		CommLink.people.add(CommLink.students);
		CommLink.people.add(CommLink.parents);
		CommLink.people.add(CommLink.teachers);
	}
}
