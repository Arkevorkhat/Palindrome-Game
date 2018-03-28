package users;

import javax.swing.JOptionPane;

import communications.CommLink.listable;
import communications.Message;

public class Student extends Person implements listable{
	private static final long serialVersionUID = -4062870041480934701L;
	int currDifficulty;   //Difficulty relates to the length of words that the child will be shown.
	int currGradeLevel;   //Difficulty should not exceed 10*logn(GradeLevel)
	int score;			  //Each successful identification will increase this number by one.
	private Parent[] parents;
	public Student(String UN, String PW, int curDifficulty, int gradeLevel) {
		super(UN, PW);
		currDifficulty = curDifficulty;
		currGradeLevel = gradeLevel;
		score = 0;
		this.addToSet();
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
		new Message(MessageText, this.getUUID(), chosen.getUUID()).addToSet();
	}
}	