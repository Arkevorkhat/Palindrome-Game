package communications;

import users.Child;
import users.Parent;
import users.Teacher;

public class ObjHandler extends CommLink {
	@Override
	public void init() {
		if (children.size()<1) {  //if there are no items in the arraylist
			children.add(new Child("Admin", "administrator", 100,13)); //add a default administrator account.
		}
		if (parents.size()<1) {
			parents.add(new Parent("Admin", "administrator", children));
		}
		if (teachers.size()<1) {
			teachers.add(new Teacher("Admin","Administrator",children,1l));
		}
		if (messages.size()<1) {
			messages.add(new Message("test message please ignore.", 0, 0)); //or an empty message.
		}
	}
}
