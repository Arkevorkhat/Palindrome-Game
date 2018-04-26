package engine;

import java.awt.Dimension;
import javax.swing.filechooser.FileSystemView;

public class CONSTANTS {
	public static final char PW_DOT = '\u2022';
	public static final String _VERSION = "1.0.2";
	public static final String _GAME_NAME = "Palindromes with Pals"; //FIXME: set game name.
	public static final int _DEFAULT_WINDOW_WIDTH = 600;
	public static final int _DEFAULT_WINDOW_HEIGHT = 400;
	public static final Dimension _DEFAULT_MINIMUM_WINDOW_SIZE = new Dimension(_DEFAULT_WINDOW_WIDTH,_DEFAULT_WINDOW_HEIGHT);
	public static String PATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
}
