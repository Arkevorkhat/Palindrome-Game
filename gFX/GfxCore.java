package gFX;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.JFrame;
import backEnd.EventListener;
import backEnd.KeyListener;

public class GfxCore {
	public static Dimension screenDim;
	
	public static JFrame CoreFrame = new JFrame();
	private static TextField TF = new TextField(10);
	private static Container GL = new Container();
	private static Button loginButton = new Button("Login");
	private static Button guestButton = new Button("Continue as Guest");
	@Deprecated
	class jDOMCite extends Component {
		private static final long serialVersionUID = -4062870041480934701L;
		String text = "Uses code from the JDOM project";
	}
	static
	{
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		TF.addKeyListener(new KeyListener());
		loginButton.addActionListener(new EventListener());
		
	}
	public static void init()
	{
		CoreFrame.setTitle(engine.CONSTANTS._GAME_NAME);
		CoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CoreFrame.setMinimumSize(new Dimension(600, 400));
		CoreFrame.setVisible(true);
		CoreFrame.setLayout(new GridLayout(2, 1));
		CoreFrame.add(TF);
		GL.setLayout(new GridLayout(1, 2));
		CoreFrame.add(GL);
		GL.add(loginButton);
		GL.add(guestButton);
	}
}
