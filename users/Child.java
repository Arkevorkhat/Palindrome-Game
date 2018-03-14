package users;

public class Child extends Person {
	int currDifficulty;
	int currGradeLevel;
	int score;

	public Child(String UN, String PW, int diff, int gradeLevel) {
		super(UN, PW);
		this.currDifficulty = diff;
		this.currGradeLevel = gradeLevel;
		this.score = 0;
	}

}
