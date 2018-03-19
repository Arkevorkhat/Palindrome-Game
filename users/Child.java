package users;

public class Child extends Person {
	int currDifficulty;
	int currGradeLevel;
	int score;

	public Child(String UN, String PW, int currDifficulty, int gradeLevel) {
		super(UN, PW);
		this.currDifficulty = currDifficulty;
		this.currGradeLevel = gradeLevel;
		this.score = 0;
	}
	public void setCurrDifficulty(int inputDifficulty) {
		this.currDifficulty=inputDifficulty;
	}
	public int getDiff() {
		return 0;
	}
}