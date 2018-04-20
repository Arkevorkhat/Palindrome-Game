package data;

import communications.CommLink;
import communications.CommLink.listable;

public class Administrator extends Person implements listable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Administrator(String UN, String PW) {
		super(UN, PW);
	}
	@Override
	public void addToSet() throws IllegalAccessException {
		if (CommLink.admins.add(this)) {}
		else throw new IllegalAccessException();
	}
	@Override
	public Object getFromSet(long ID) throws IllegalArgumentException {
		for (Administrator a : CommLink.admins) {
			if(a.getUUID()==ID) {
				return a;
			}
		}
		throw new IllegalArgumentException();
	}
}
	