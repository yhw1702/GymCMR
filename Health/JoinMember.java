package Health;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Health.Program.ProgramDao;


//회원 등록
public class JoinMember extends JFrame {

	public JoinMember() {
		//여기부터 회원 등록 패널
		Box box = Box.createHorizontalBox();
		add(box);
		JPanel leftPanel = new JPanel();
		box.add(leftPanel);
		setSize(800, 600);
		leftPanel.add(Box.createHorizontalBox());
		leftPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원등록"));       

		Label l_name = new Label("이름");
		leftPanel.add(l_name);
		
		TextField t_name = new TextField(10);
		leftPanel.add(t_name);
		
		Label l_phoneNum = new Label("전화번호");
		leftPanel.add(l_phoneNum);
		
		TextField t_phoneNum = new TextField(15);
		leftPanel.add(t_phoneNum);
		
		Label l_apartNum = new Label("동호수");
		leftPanel.add(l_apartNum);
		
		TextField t_apartNum = new TextField(5);
		leftPanel.add(t_apartNum);
		
		Button b_regist = new Button("등록");
		leftPanel.add(b_regist);
		
		//여기부터 조회 패널
		JPanel RightPanel = new JPanel();
		box.add(RightPanel);
		RightPanel.add(Box.createHorizontalBox());
		RightPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원조회"));
		
		Label l2_name = new Label("이름");
		RightPanel.add(l2_name);
		
		TextField t2_name = new TextField(10);
		RightPanel.add(t2_name);
		
		Button b2_search = new Button("검색");
		RightPanel.add(b2_search);
	
		//등록 버튼
		b_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = t_name.getText();
				String phoneNum = t_phoneNum.getText();
				String apartNum = t_apartNum.getText();
				
				
				ProgramDao dao = new ProgramDao();
				int result = dao.insertMember(name,phoneNum,apartNum);
				
				
			}
		});  
	} 
}
