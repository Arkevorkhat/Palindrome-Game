package backEnd;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	private static final int[] debugSeq = { 38, 38, 40, 40, 37, 39, 37, 39 };
	private static int debugSeqIter = 0;
	private static final int debugSeqEnd = 7;

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
}
