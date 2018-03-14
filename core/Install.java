package core;
import java.io.*;

public class Install {
	public static void flowDirs() {
		String PATH = System.getProperty("user.dir");
		File messages = new File(PATH+File.pathSeparator+"files");
		File users = new File(PATH+File.pathSeparator+"files");
		System.out.println(messages.getAbsoluteFile());
		System.out.println(users.getAbsoluteFile());
		try {
			messages.getParentFile().mkdirs();
			users.getParentFile().mkdirs();
			System.out.println(messages.createNewFile());
			System.out.println(users.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
