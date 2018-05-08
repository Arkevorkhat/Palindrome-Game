package gFX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import backEnd.GameLogicController;
import backEnd.Palindrome;

import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PLayWindowGUI {
	private GameLogicController GLC;
	private JFrame frame;
	private JTextField Input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PLayWindowGUI window = new PLayWindowGUI();
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
	public PLayWindowGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GLC = new Palindrome();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 25));
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 808, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea txtrAPalindromeIs = new JTextArea();
		txtrAPalindromeIs.setBounds(38, 41, 735, 140);
		//		txtrAPalindromeIs.setDropMode(DropMode.INSERT_ROWS);
		txtrAPalindromeIs.setRows(5);
		txtrAPalindromeIs.setColumns(35);
		txtrAPalindromeIs.setLineWrap(true);
		txtrAPalindromeIs.setFont(new Font("Arial", Font.BOLD, 24));
		txtrAPalindromeIs.setBackground(new Color(175, 238, 238));
		txtrAPalindromeIs.setTabSize(90);
		txtrAPalindromeIs.setText(
				"A Palindrome is a word or phrase the reads the same backwards and forwards. Is the following word a palindrome?");
		frame.getContentPane().add(txtrAPalindromeIs);

		Input = new JTextField();
		Input.setHorizontalAlignment(SwingConstants.CENTER);
		Input.setBackground(new Color(224, 255, 255));
		Input.setForeground(new Color(148, 0, 211));
		Input.setFont(new Font("Courier 10 Pitch", Font.BOLD, 30));
		Input.setText("RACECAR");
		Input.setBounds(97, 189, 600, 70);
		frame.getContentPane().add(Input);
		Input.setColumns(40);

		JButton btnNewButton = new JButton("TRUE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (GLC.check(Input.getText()) == true) {
					new CorrectWindow();
				} else {
					new WrongAnsWindow();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(89, 396, 200, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("FALSE");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (GLC.check(Input.getText()) == true) {
					new WrongAnsWindow();

				} else {
					new CorrectWindow();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 69, 0));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBounds(504, 396, 200, 50);
		frame.getContentPane().add(btnNewButton_2);
	}
}
