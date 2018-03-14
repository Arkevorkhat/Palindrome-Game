package communications;

import java.util.Random;

public class CommLink {

	public long lastID;

	public void init() {
		Random r = new Random();
		lastID = r.nextLong();
	}

	/*
	 * TODO: write file handling to allow a parent or teacher to leave a message for
	 * the student. Parents can only leave messages for their child, teachers can
	 * leave blanket messages to the entire class.
	 */
	public class FileHandler {

	}
}
