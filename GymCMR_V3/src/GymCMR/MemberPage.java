package GymCMR;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.*;

public class MemberPage extends JPanel{
	public MemberPage() {
		//������� ȸ�� ��� �г�
		Box box = Box.createHorizontalBox();
		add(box);
		JPanel leftPanel = new JPanel();
		box.add(leftPanel);
		leftPanel.add(Box.createHorizontalBox());
		leftPanel.setBorder(new TitledBorder( new EtchedBorder(),"ȸ�����"));       

		Label l1 = new Label("�̸�");
		leftPanel.add(l1);
		
		TextField t1 = new TextField(10);
		leftPanel.add(t1);
		
		
		//������� ��ȸ �г�
		JPanel RightPanel = new JPanel();
		box.add(RightPanel);
		RightPanel.add(Box.createHorizontalBox());
		RightPanel.setBorder(new TitledBorder( new EtchedBorder(),"ȸ����ȸ"));
		
		Label l2 = new Label("�̸�");
		RightPanel.add(l2);
		
		TextField t2 = new TextField(10);
		RightPanel.add(t2);
		
		Button b2 = new Button("�˻�");
		RightPanel.add(b2);
	}
}
