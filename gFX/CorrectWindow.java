package gFX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class CorrectWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorrectWindow window = new CorrectWindow();
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
	public CorrectWindow() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 0));
		
		JLabel lblThatsCorrect = new JLabel("THAT'S CORRECT!!!!!!!");
		lblThatsCorrect.setFont(new Font("Arial", Font.BOLD, 35));
		lblThatsCorrect.setBackground(new Color(0, 255, 0));
		frame.getContentPane().add(lblThatsCorrect, BorderLayout.CENTER);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
