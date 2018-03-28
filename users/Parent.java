package users;

import java.io.Serializable;
import communications.CommLink.listable;

public class Parent extends Adult implements Serializable, listable {
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
}
