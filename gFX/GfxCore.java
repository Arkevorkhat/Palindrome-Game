package gFX;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GfxCore {
	public static Dimension screenDim;
	private static final int[] debugSeq = { 38, 38, 40, 40, 37, 39, 37, 39 };
	private static int debugSeqIter = 0;
	private static final int debugSeqEnd = 7;
	public static JFrame CoreFrame = new JFrame();
	private static TextField TF = new TextField(10);

	@Deprecated
	class jDOMCite extends Component {

		private static final long serialVersionUID = -4062870041480934701L;
		String text = "Uses code from the JDOM project";

	}

	static {
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		TF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == debugSeq[debugSeqIter]) {
					if (debugSeqIter < debugSeqEnd) {
						debugSeqIter++;
					} else {
						engine.Debug.DebugCore();
						debugSeqIter = 0;
					}
				}
			}
		});
	}

	public static void init() {
		CoreFrame.setTitle(engine.Core._GAME_NAME);
		CoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CoreFrame.setMinimumSize(new Dimension(600, 400));
		CoreFrame.setVisible(true);
		CoreFrame.add(TF);
	}
}
