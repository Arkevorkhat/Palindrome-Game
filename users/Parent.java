package users;

import java.io.Serializable;

import communications.CommLink;
import communications.CommLink.listable;

public class Parent extends Adult implements Serializable, listable<Parent> {
	private static final long serialVersionUID = -4062870041480934701L;

	public Parent(String UN, String PW, Student[] children) {
		super(UN, PW, children);
	}

	@Deprecated
	public Boolean broadcastMessage(String Message) {
		System.err.println("user.parent.AccessDeniedException");
		return false;
	}

	public void addToSet() {
		communications.CommLink.parents.add(this);
	}

	@Override
	public Parent getFromSet(long ID) throws IllegalArgumentException {
		for(Parent i : CommLink.parents) {
			if( i.getUUID()==ID) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
}
