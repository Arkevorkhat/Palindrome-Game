package backEnd;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	private static final int[] debugSeq =
	{ 38, 38, 40, 40, 37, 39, 37, 39 };
	private static final int[] adminLogin =
	{ 37, 38, 39, 40, 37, 38, 39, 40 };
	private static int adminLoginIter = 0;
	private static int adminLoginEnd = 7;
	private static int debugSeqIter = 0;
	private static final int debugSeqEnd = 7;
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == debugSeq[debugSeqIter] && adminLoginIter == 0)
		{
			if (debugSeqIter < debugSeqEnd)
			{
				debugSeqIter++;
			} else
			{
				engine.Debug.DebugCore();
				debugSeqIter = 0;
			}
		} else if (e.getKeyCode() == adminLogin[adminLoginIter] && debugSeqIter == 0)
		{
			if (adminLoginIter < adminLoginEnd)
			{
				adminLoginIter++;
			} else
			{
				Login.adminReg();
				adminLoginIter = 0;
			}
		}
	}
}
