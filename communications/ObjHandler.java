package communications;

import data.Parent;
import data.Student;
import data.Teacher;

public class ObjHandler extends CommLink {
	public void init() {
		if (students.size()<1) {  //if there are no items in the arraylist
			students.add(new Student("Alex Doe", "123456789", 100,13)); //add a default administrator account.
		}
		if (parents.size()<1) {
			parents.add(new Parent("Alex Doe Sr.", "147896325", (Student[]) students.toArray()));
		}
		if (teachers.size()<1) {
			teachers.add(new Teacher("Admin","Administrator",(Student[]) students.toArray(),1l));
		}
		if (messages.size()<1) {
			messages.add(new Message("test message please ignore.", 0, 0)); //or an empty message.
		}
	}
}
	