package engine;

import communications.CommLink;
import communications.Message;
import data.*;

public class Debug {
	public static void DebugCore() {
		System.out.println("Students: ");
		for(Student s : CommLink.students) {
			System.out.print(s.username+" : ");
			System.out.print(s.getPWHash()+" : ");
			System.out.print(s.getUUID()+" : ");
			System.out.println(s.getGroup().GroupID);
		}
		System.out.println("Parents: ");
		for(Parent p : CommLink.parents) {
			System.out.print(p.username+" : ");
			System.out.print(p.getPWHash()+" : ");
			System.out.println(p.getUUID());
		}
		System.out.println("Teachers: ");
		for(Teacher t : CommLink.teachers) {
			System.out.print(t.username+" : ");
			System.out.print(t.getPWHash()+" : ");
			System.out.print(t.getUUID()+" : ");
			System.out.println(t.getGroup().GroupID);
		}
		System.out.println("Administrators: ");
		for(Administrator a : CommLink.admins) {
			System.out.print(a.username+" : ");
			System.out.print(a.getPWHash()+" : ");
			System.out.println(a.getUUID());
		}
		System.out.println("Groups: ");
		for(Group g : CommLink.groups) {
			System.out.println(g.GroupID);
			System.out.println("{");
			g.printStudentUNs();
			System.out.println("}");
		}
		System.out.println("Messages, note: message content not shown without admin credentials: ");
		for(Message m : CommLink.messages) {
			System.out.print(m.getSenderUID()+" : ");
			System.out.println(m.getRecUID());
		}
		System.out.println("Words: ");
		for(Word w : CommLink.words) {
			System.out.print(w.getContent()+" : ");
			System.out.print(w.getIsPalindrome()+" : ");
			System.out.print(w.length()+" : ");
		}
	}
}
