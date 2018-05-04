package gFX;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JList;
import javax.swing.ListModel;

import communications.CommLink;
import data.*;

public class AdminWindow {
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
	Button B1 = new Button("Student Info");
	Button B2 = new Button("Words");
	Button B3 = new Button("Groups");
	Button B4 = new Button("Teachers");
	Button B5 = new Button("Parents");

	public AdminWindow() {
		for(Student s : CommLink.students) {
			TA.append(s.Score+" : "+s.username+'\n');
		}
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
		this.col1Container.setLayout(new GridLayout(1, 9));
		this.col1Container.add(Box.createHorizontalGlue());
		this.col2Container.setLayout(new GridLayout(1, 3));
		this.col2Container.add(Box.createVerticalGlue());
		this.col2_1Container.add(ml);
		this.col2_1Container.add(B1);
		this.col2_1Container.add(B2);
		this.col2_1Container.add(B3);
		this.col2_1Container.add(B4);
		this.col2_1Container.add(B5);
		this.col2Container.add(this.col2_1Container);
		this.col2Container.add(Box.createVerticalGlue());
		this.col3Container.add(TA);
		WindowFactory.makeWindow("Administrator Console");
		GfxCore.CoreFrame.setLayout(new GridLayout(1, 3));
		GfxCore.CoreFrame.add(this.col1Container);
		GfxCore.CoreFrame.add(this.col2Container);
		GfxCore.CoreFrame.add(this.col3Container);
		GfxCore.CoreFrame.revalidate();
		GfxCore.CoreFrame.setVisible(true);
	}
	
}
