package gFX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class SplashAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashAdmin window = new SplashAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplashAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 714, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("PLAY!!!!!");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setBounds(42, 36, 300, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEE SCORES");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(173, 255, 47));
		btnNewButton_1.setBounds(42, 175, 300, 75);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(173, 255, 47));
		btnNewButton_2.setBounds(42, 313, 300, 75);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea txtrWelcomeTopalindrome = new JTextArea();
		txtrWelcomeTopalindrome.setForeground(new Color(255, 165, 0));
		txtrWelcomeTopalindrome.setBackground(new Color(0, 0, 139));
		txtrWelcomeTopalindrome.setFont(new Font("Arial", Font.BOLD, 35));
		txtrWelcomeTopalindrome.setLineWrap(true);
		txtrWelcomeTopalindrome.setWrapStyleWord(true);
		txtrWelcomeTopalindrome.setRows(5);
		txtrWelcomeTopalindrome.setText("WELCOME to \"Palindromes With Pals\"");
		txtrWelcomeTopalindrome.setBounds(427, 84, 242, 300);
		frame.getContentPane().add(txtrWelcomeTopalindrome);
	}

}
