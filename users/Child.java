package users;

public class Child extends Person {
	int currDifficulty;   //Difficulty relates to the length of words that the child will be shown.
	int currGradeLevel;   //Difficulty should not exceed 10*log10(GradeLevel)
	int score;			  //Each successful identification will increase this number by one.
	public Child(String UN, String PW, int curDifficulty, int gradeLevel) {
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
		communications.CommLink.children.add(this); //Add this class instance to the arrayList used for storing child objects.
	}
}