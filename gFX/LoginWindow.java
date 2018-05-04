package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import backEnd.Login;
import backEnd.Palindrome;
import data.Person;

public class LoginWindow {
	/**
	 * @author Arkev
	 * @since 23-APR-18
	 */
	TextField UNTF = new TextField(40);
	TextField PWTF = new TextField(40);
	public JDialog JDLogin = new JDialog(gFX.GfxCore.CoreFrame, "Login");

	public LoginWindow() {

		JDLogin.setSize(new Dimension(500, 350));
		JDLogin.setLayout(new GridLayout(4, 1));
		JDLogin.add(new Label("Please Input your Username and Password"));
		Container UNCont = new Container();
		UNCont.setLayout(new FlowLayout());
		UNCont.add(new Label("Username"));
		UNCont.add(UNTF);
		Container PWCont = new Container();
		PWTF.setEchoChar(engine.CONSTANTS.PW_DOT);
		PWCont.setLayout(new FlowLayout());
		PWCont.add(new Label("Password"));
		PWCont.add(PWTF);
		JDLogin.add(UNCont);
		JDLogin.add(PWCont);
		JDLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Button LI = new Button("Submit");
		LI.addActionListener(new submitListener());
		JDLogin.add(LI);
		JDLogin.setVisible(true);
	}

	private class submitListener implements ActionListener {
		private String Username;
		private String Password;

		@Override
		public void actionPerformed(ActionEvent e) {
			Username = UNTF.getText();
			Password = PWTF.getText();
			try {
				Person stor = data.Person.findPersonByName(Username);
				//if (/*Login.checkPassword(stor, Password)*/true==true) {
					stor.setSess(backEnd.Login.logIn(Username, Password));
					JOptionPane.showConfirmDialog(JDLogin, "Logged in Successfully!");
					JDLogin.dispose();
					new GameWindow(new Palindrome());
				//}
			} catch (IllegalArgumentException e1) {
				System.err.println(e1.getMessage());
				new GameWindow(new Palindrome());
			}
		}
	}
}
