package gFX;

import javax.swing.JFrame;

public class Init {

	/*
	 * TODO: Finish programming initialization tasks
	 * 
	 * 
	 */
	public JFrame prep(int x, int y, String name, Boolean borderless) {
		JFrame jf = new JFrame(name);
		jf.setSize(x, y);
		jf.setDefaultLookAndFeelDecorated(borderless);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jf;
	}

	public void destroy(JFrame input) {
		input.dispose();
	}

	public void resize(JFrame in, int x, int y) { // resizes absolutely.
		in.setSize(x, y);
	}
}
