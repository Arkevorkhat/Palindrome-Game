package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

import communications.CommLink;
import data.*;
import engine.CONSTANTS;

public class AdminWindow {
	static byte currView = 0;
	Container col1Container = new Container();
	Container col2Container = new Container();
	Container col2_1Container = new Container();
	Container col3Container = new Container();
	Vector<Student> SV = new Vector<Student>();
	Vector<Parent> PV = new Vector<Parent>();
	Vector<Teacher> TV = new Vector<Teacher>();
	Vector<Administrator> AV = new Vector<Administrator>();
	Vector<Word> WV = new Vector<Word>();
	JList<Student> JLst;
	JList<Parent> JLpr;
	JList<Teacher> JLtr;
	JList<Administrator> JLad;
	JList<Word> JLwr;
	TextArea TA = new TextArea();
	Label ml = new Label("Select a view");
	Button B1 = new Button("Student Info"); // View 0
	Button B2 = new Button("Words"); // View 1
	Button B3 = new Button("Groups"); // View 2
	Button B4 = new Button("Teachers"); // View 3
	Button B5 = new Button("Parents"); // View 4
	Label Rl = new Label("Register a User");
	Label Rw = new Label("Add a Word to the dictionary.");
	Button RB = new Button("Register");
	TextField TFRg = new TextField(40);
	TextField TFPW = new TextField(40);
	Container RegCont = new Container();
	Container WorCont = new Container();
	Button YB = new Button("Yes");
	Button NB = new Button("No");
	Label PDL = new Label("Is a Palindrome?");

	public AdminWindow() {
		TFPW.setEchoChar(CONSTANTS.PW_DOT);
		
		SV.addAll(CommLink.students);
		PV.addAll(CommLink.parents);
		TV.addAll(CommLink.teachers);
		AV.addAll(CommLink.admins);
		WV.addAll(CommLink.words);
		JLst = new JList<Student>(SV);
		JLpr = new JList<Parent>(PV);
		JLtr = new JList<Teacher>(TV);
		JLad = new JList<Administrator>(AV);
		JLwr = new JList<Word>(WV);
		this.RegCont.setLayout(new GridLayout(4,1));
		this.RegCont.add(new Label("Register"));
		this.RegCont.add(TFRg);
		this.RegCont.add(TFPW);
		this.RegCont.add(RB);
		this.col1Container.setLayout(new GridLayout(1, 9));
		this.col1Container.add(Box.createHorizontalGlue());
		this.col1Container.setVisible(true);
		this.col2Container.setLayout(new GridLayout(1, 3));
		this.col2_1Container.setLayout(new GridLayout(6, 1));
		this.B1.setActionCommand("S");
		this.B2.setActionCommand("W");
		this.B3.setActionCommand("G");
		this.B4.setActionCommand("T");
		this.B5.setActionCommand("P");
		this.RB.setActionCommand("R");
		this.B1.addActionListener(new AdminButtonListener());
		this.B2.addActionListener(new AdminButtonListener());
		this.B3.addActionListener(new AdminButtonListener());
		this.B4.addActionListener(new AdminButtonListener());
		this.B5.addActionListener(new AdminButtonListener());
		this.RB.addActionListener(new AdminButtonListener());
		this.col2_1Container.add(ml);
		this.col2_1Container.add(B1);
		this.col2_1Container.add(B2);
		this.col2_1Container.add(B3);
		this.col2_1Container.add(B4);
		this.col2_1Container.add(B5);
		this.col2Container.add(this.col2_1Container);
		this.col2Container.repaint();
		this.col2Container.setVisible(true);
		this.col3Container.setLayout(new GridLayout(1, 1));
		this.col3Container.add(TA);
		this.col3Container.setVisible(true);
		// GfxCore.CoreFrame.revalidate();
		flowWindow();
	}

	private void flowWindow() {
		if (GfxCore.CoreFrame == null) {
			GfxCore.CoreFrame = new JFrame();
		}
		GfxCore.CoreFrame.getContentPane().removeAll();
		GfxCore.CoreFrame.revalidate();
		GfxCore.CoreFrame.setLayout(new GridLayout(1, 3));
		GfxCore.CoreFrame.setMinimumSize(CONSTANTS._DEFAULT_MINIMUM_WINDOW_SIZE);
		GfxCore.CoreFrame.add(this.col1Container);
		GfxCore.CoreFrame.add(this.col2Container);
		GfxCore.CoreFrame.add(this.col3Container);
		GfxCore.CoreFrame.repaint();
		GfxCore.CoreFrame.setVisible(true);
	}

	public void setRegView() {

		col1Container.setVisible(true);
		flowWindow();
	}

	public void setAddView() {

	}

	public class AdminButtonListener extends AdminWindow implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (arg0.getActionCommand()) {
			case "S":
				currView = 0;
				TA.setText("");
				for (Student s : CommLink.students) {
					TA.append(s.Score + " : " + s.username + '\n');
				}
			case "W":
				currView = 1;
				TA.setText("");
				for (Word w : CommLink.words) {
					TA.append(w.getContent() + " : " + w.getIsPalindrome());
				}
			case "G":
			case "T":
			case "P":
			case "R":
			}
		}

	}
}
