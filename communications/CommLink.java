package communications;

import java.util.Random;
import org.jdom2.*;
import org.jdom2.output.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CommLink{

	public long lastID;

	public void init() {
		Random r = new Random();
		lastID = r.nextLong();
	}

	/*
	 * TODO: Finish Writing Top-Level File Handling Routines.
	 *	When writing a parsing method, ensure that you use Try/Catch in order to handle nullPointerException, as that is required with this single-file structure.
	 * XML Formatted as:
	 * Root
	 * 		ID
	 * 			Username
	 * 			[PasswordHash]
	 * 			[Message]
	 * 			[Salt]
	 * 			[UID]
	 * 			[Difficulty]
	 * 			[GradeLevel]
	 * 			[SenderID]
	 */
	
}
