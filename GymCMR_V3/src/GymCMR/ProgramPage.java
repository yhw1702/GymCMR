package GymCMR;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ProgramPage extends JPanel{
	public ProgramPage() {
		//������� ȸ�� ��� �г�
		Box box = Box.createHorizontalBox();
		add(box);
		JPanel leftPanel = new JPanel();
		box.add(leftPanel);
		leftPanel.add(Box.createHorizontalBox());
		leftPanel.setBorder(new TitledBorder( new EtchedBorder(),"���α׷� ���"));       

		Label l1 = new Label("���α׷���");
		leftPanel.add(l1);
		
		TextField t1 = new TextField(10);
		leftPanel.add(t1);
		
		
		//������� ��ȸ �г�
		JPanel RightPanel = new JPanel();
		box.add(RightPanel);
		RightPanel.add(Box.createHorizontalBox());
		RightPanel.setBorder(new TitledBorder( new EtchedBorder(),"���α׷� ��ȸ"));
		
		Label l2 = new Label("���α׷���");
		RightPanel.add(l2);
		
		TextField t2 = new TextField(10);
		RightPanel.add(t2);
		
		Button b2 = new Button("�˻�");
		RightPanel.add(b2);
	}
}