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
		// 프레임 설정영역
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		// setBounds(실행좌표x, 실행좌표y, 창 크기x, 창 크기y)
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
		tabbedPane.setFont(font1);
		
		tabbedPane.addTab("주민 등록", null, new MemberPage(), null);
		tabbedPane.addTab("프로그램 등록", null, new ProgramPage(), null);
		tabbedPane.addTab("프로그램 수강 등록", null, new RegistPage(), null);
		
	}

}
