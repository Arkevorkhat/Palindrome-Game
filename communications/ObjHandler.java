package communications;

import users.Student;
import users.Parent;
import users.Teacher;

public class ObjHandler extends CommLink {
	@Override
	public void init() {
		if (students.size()<1) {  //if there are no items in the arraylist
			students.add(new Student("Admin", "administrator", 100,13)); //add a default administrator account.
		}
		if (parents.size()<1) {
			parents.add(new Parent("Admin", "administrator", (Student[]) students.toArray()));
		}
		if (teachers.size()<1) {
			teachers.add(new Teacher("Admin","Administrator",(Student[]) students.toArray(),1l));
		}
		if (messages.size()<1) {
			messages.add(new Message("test message please ignore.", 0, 0)); //or an empty message.
		}
	}
}
