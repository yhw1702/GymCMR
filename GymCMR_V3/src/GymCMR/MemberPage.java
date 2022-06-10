package GymCMR;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.*;

public class MemberPage extends JPanel{
	public MemberPage() {
		//여기부터 회원 등록 패널
		Box box = Box.createHorizontalBox();
		add(box);
		JPanel leftPanel = new JPanel();
		box.add(leftPanel);
		leftPanel.add(Box.createHorizontalBox());
		leftPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원등록"));       

		Label l1 = new Label("이름");
		leftPanel.add(l1);
		
		TextField t1 = new TextField(10);
		leftPanel.add(t1);
		
		
		//여기부터 조회 패널
		JPanel RightPanel = new JPanel();
		box.add(RightPanel);
		RightPanel.add(Box.createHorizontalBox());
		RightPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원조회"));
		
		Label l2 = new Label("이름");
		RightPanel.add(l2);
		
		TextField t2 = new TextField(10);
		RightPanel.add(t2);
		
		Button b2 = new Button("검색");
		RightPanel.add(b2);
	}
}
