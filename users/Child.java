package users;

public class Child extends Person {
	int currDifficulty;
	int currGradeLevel;
	int score;

	public Child(String UN, String PW, int curDifficulty, int gradeLevel) {
		super(UN, PW);
		currDifficulty = curDifficulty;
		currGradeLevel = gradeLevel;
		score = 0;
	}
	public void setCurrDifficulty(int inputDifficulty) {
		this.currDifficulty=inputDifficulty;
	}
	public int getDiff() {
		return 0;
	}
	public void addToSet() {
		communications.CommLink.children.add(this);
	}
}