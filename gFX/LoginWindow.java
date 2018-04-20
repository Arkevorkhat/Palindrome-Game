package gFX;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JDialog;

public class LoginWindow {
	public LoginWindow()
	{
		JDialog JDLogin = new JDialog(gFX.GfxCore.CoreFrame, "Login");
		JDLogin.setSize(new Dimension(500, 350));
		JDLogin.setLayout(new GridLayout(4, 1));
		JDLogin.add(new Label("Please Input your Username and Password"));
		Container UNCont = new Container();
		UNCont.setLayout(new FlowLayout());
		UNCont.add(new Label("Username"));
		TextField UNTF = new TextField(40);
		TextField PWTF = new TextField(40);
		PWTF.setEchoChar(engine.CONSTANTS.PW_DOT);
		UNCont.add(UNTF);
		Container PWCont = new Container();
		PWCont.setLayout(new FlowLayout());
		PWCont.add(new Label("Password"));
		PWCont.add(PWTF);
		JDLogin.add(UNCont);
		JDLogin.add(PWCont);
		JDLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JDLogin.setVisible(true);
	}
}
