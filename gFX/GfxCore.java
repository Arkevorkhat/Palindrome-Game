package gFX;
import java.awt.Component;

import javax.swing.JFrame;

public class GfxCore {
	@Deprecated
	class jDOMCite extends Component{
		
		private static final long serialVersionUID = -4062870041480934701L;
		String text = "Uses code from the JDOM project";
		 	
	}
	public static JFrame CoreFrame = new JFrame();
	public static void init() {
		CoreFrame.setTitle(engine.Core._GAME_NAME);
	}
}
