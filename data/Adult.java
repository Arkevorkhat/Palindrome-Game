package data;
import data.Student;
public class Adult extends Person{
	private static final long serialVersionUID = -4062870041480934701L;
	Student[] children;
	public Adult(String UN, String PW, Student[] children) {
		super(UN, PW);
		this.children = children;
	}
	public static void register() {
	}	
}