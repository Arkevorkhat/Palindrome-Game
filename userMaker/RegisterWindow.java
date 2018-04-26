package userMaker;

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
import javax.swing.JFrame;

import backEnd.UserType;
import engine.WindowCloseOperation;

public class RegisterWindow {
	TextField UNTF = new TextField(40);
	TextField PWTF = new TextField(40);
	TextField PWCTF = new TextField(40);
	private JFrame JDLogin = new JFrame();
	
	public RegisterWindow() {
		communications.FileHandler.init();
		communications.FileHandler.getArrayLists();
		JDLogin.setSize(new Dimension(500, 350));
		JDLogin.setLayout(new GridLayout(5, 1));
		JDLogin.add(new Label("Please Choose a Username and Password"));
		Container UNCont = new Container();
		UNCont.setLayout(new FlowLayout());
		UNCont.add(new Label("Username"));
		PWTF.setEchoChar(engine.CONSTANTS.PW_DOT);
		UNCont.add(UNTF);
		Container PWCont = new Container();
		PWCont.setLayout(new FlowLayout());
		PWCont.add(new Label("Password"));
		PWCont.add(PWTF);
		Container PWCCont = new Container();
		PWCCont.setLayout(new FlowLayout());
		PWCCont.add(new Label("Confirm Password"));
		PWCCont.add(PWCTF);
		JDLogin.add(UNCont);
		JDLogin.add(PWCont);
		JDLogin.add(PWCCont);
		JDLogin.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		JDLogin.addWindowListener(new WindowCloseOperation());
		Button RS = new Button("Register Student");
		Button RP = new Button("Register Parent");
		Button RT = new Button("Register Teacher");
		Button RA = new Button("Register Administrator");
		RS.addActionListener(new SubmitListener());
		RP.addActionListener(new SubmitListener());
		RT.addActionListener(new SubmitListener());
		RA.addActionListener(new SubmitListener());
		Container ButtonContainer = new Container();
		ButtonContainer.setLayout(new GridLayout(1,4));
		ButtonContainer.add(RS);
		ButtonContainer.add(RP);
		ButtonContainer.add(RT);
		ButtonContainer.add(RA);
		JDLogin.add(ButtonContainer);
		JDLogin.setVisible(true);
	}

	private class SubmitListener implements ActionListener {
		private String Username;
		private String Password;
		private String PWConfirm;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Username = UNTF.getText();
			Password = PWTF.getText();
			PWConfirm = PWCTF.getText();	
			if(PWConfirm.equals(Password)) {
				switch(e.getActionCommand().replaceAll("Register ", "")) {
				case "Student":
					backEnd.Login.register(Username, Password, UserType.Student);
					break;
				case "Parent":
					backEnd.Login.register(Username, Password, UserType.Parent);
					break;
				case "Teacher":
					backEnd.Login.register(Username, Password, UserType.Teacher);
					break;
				case "Administrator":
					backEnd.Login.adminReg();
					break;
					default:
						
				}
			}
		}
	}
}
