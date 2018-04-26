package gFX;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GfxCore {
	@Deprecated
	class jDOMCite extends Component {
		private static final long serialVersionUID = -4062870041480934701L;
		String text = "Uses code from the JDOM project";
	}
	static
	{
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	}
	public interface iWindow {
		public void init();
	}
	public static Dimension screenDim;
	public static JFrame CoreFrame = new JFrame();
}
