package data;

import java.io.Serializable;
import java.util.ArrayList;

import communications.CommLink;
import communications.CommLink.listable;

public class Group implements Serializable, listable<Group> {
	private static final long serialVersionUID = 1L;
	public long GroupID;
	private ArrayList<Student> members;
	@Override
	public void addToSet() throws IllegalAccessException {
		if (CommLink.groups.add(this))
			;
		else
			throw new IllegalAccessException();
	}
	
	@Override
	public Group getFromSet(long ID) throws IllegalArgumentException {
		for (Group i : CommLink.groups) {
			if (i.GroupID == ID) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
	public void printStudentUNs() {
		for (Student s : this.members) {
			System.out.println(s.username);
		}
	}
}
