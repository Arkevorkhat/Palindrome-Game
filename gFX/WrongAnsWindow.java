package gFX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;

public class WrongAnsWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrongAnsWindow window = new WrongAnsWindow();
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
	public WrongAnsWindow() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 69, 0));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrIncorrectAnswerTry = new JTextArea();
		txtrIncorrectAnswerTry.setBounds(0, 60, 560, 36);
		txtrIncorrectAnswerTry.setLineWrap(true);
		txtrIncorrectAnswerTry.setWrapStyleWord(true);
		txtrIncorrectAnswerTry.setBackground(new Color(255, 69, 0));
		txtrIncorrectAnswerTry.setText("INCORRECT ANSWER. Try again");
		txtrIncorrectAnswerTry.setFont(new Font("Arial", Font.BOLD, 30));
		txtrIncorrectAnswerTry.setColumns(4);
		frame.getContentPane().add(txtrIncorrectAnswerTry);
		frame.setBounds(100, 100, 560, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
