package gFX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWindowGUI {

	private JFrame frame;
	private JTextField txtTextField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindowGUI window = new AdminWindowGUI();
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
	public AdminWindowGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 65, 90, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(340, 65, 90, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(637, 65, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtTextField = new JTextField();
		txtTextField.setText("text field");
		txtTextField.setBounds(12, 157, 114, 19);
		frame.getContentPane().add(txtTextField);
		txtTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(340, 159, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(323, 299, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrTextArea = new JTextArea();
		txtrTextArea.setText("text area");
		txtrTextArea.setBounds(677, 159, 1, 15);
		frame.getContentPane().add(txtrTextArea);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(323, 214, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(323, 262, 117, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(323, 376, 117, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(323, 214, 117, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton_5.setBounds(323, 447, 117, 25);
		frame.getContentPane().add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBounds(12, 230, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 329, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		TextArea output = new TextArea();
		output.setEditable(false);
		output.setColumns(40);
		output.setBounds(588, 110, 179, 362);
		frame.getContentPane().add(output);
		frame.setBounds(100, 100, 800, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
