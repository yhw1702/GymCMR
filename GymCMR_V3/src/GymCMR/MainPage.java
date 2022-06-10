package GymCMR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JTabbedPane;


public class MainPage extends JFrame {

	private JPanel contentPane;
	
	public MainPage() {
		// ������ ��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		// setBounds(������ǥx, ������ǥy, â ũ��x, â ũ��y)
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Font font1 = new Font("���� ���", Font.BOLD, 20);
		tabbedPane.setFont(font1);
		
		tabbedPane.addTab("�ֹ� ���", null, new MemberPage(), null);
		tabbedPane.addTab("���α׷� ���", null, new ProgramPage(), null);
		tabbedPane.addTab("���α׷� ���� ���", null, new RegistPage(), null);
		
	}

}
