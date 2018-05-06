package data;

import communications.CommLink;
import communications.CommLink.listable;

public class Administrator extends Person implements listable<Administrator> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Administrator(String UN, String PW) {
		super(UN, PW);

		isAdmin=true;
	}
	@Override
	public void addToSet() throws IllegalAccessException {
		if (CommLink.admins.add(this)) {}
		else throw new IllegalAccessException();
	}
	@Override
	public Administrator getFromSet(long ID) throws IllegalArgumentException {
		for (Administrator a : CommLink.admins) {
			if(a.getUUID()==ID) {
				return a;
			}
		}
		throw new IllegalArgumentException();
	}
}
	