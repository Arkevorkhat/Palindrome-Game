package data;

import javax.swing.JOptionPane;

import communications.CommLink;
import communications.CommLink.listable;
import communications.Message;

public class Student extends Person implements listable<Student>{
	private static final long serialVersionUID = -4062870041480934701L;
	int currDifficulty;   //difficulty*5 = the time for each identification.
	int currGradeLevel; 
	int score;			  //Each successful identification will increase this number by one.
	private Parent[] parents;
	public Student(String UN, String PW, int curDifficulty, int gradeLevel) {
		super(UN, PW);
		currDifficulty = curDifficulty;
		currGradeLevel = gradeLevel;
		score = 0;
		this.addToSet();
	}
	public Student(String username, String password) {
		
	}
	public void setCurrDifficulty(int inputDifficulty) {
		this.currDifficulty=inputDifficulty;
	}
	public int getDiff() {
		return this.currDifficulty;
	}
	public void addToSet() {
		communications.CommLink.students.add(this); //Add this class instance to the arrayList used for storing child objects.
	}
	public void setParents(Parent[] input) {
		this.parents=input;
	}
	public Parent[] getParents() {
		return this.parents;
	}
	public void sendMessage() {
		Parent chosen = (Parent) JOptionPane.showInputDialog(null, "Who do you want to send this to?", "Send Message", JOptionPane.DEFAULT_OPTION, null, this.parents, this.parents[0]);
		String MessageText = JOptionPane.showInputDialog("What would you like to say?");
		try {
			new Message(MessageText, this.getUUID(), chosen.getUUID()).addToSet();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Student getFromSet(long ID) throws IllegalArgumentException {
		for (Student i : CommLink.students) {
			if (i.getUUID()==ID) {
				return i;
			}
			else continue;
		}
		throw new IllegalArgumentException();
	}
}	