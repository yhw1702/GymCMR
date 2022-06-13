package GymCMR4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;
import java.util.Vector;

public class MainClass {

	public JFrame frame;
	//Member 측 생성자
	private TextField memberNameInput;
	private TextField phoneNumberInput;
	private TextField apartDongInput;
	private TextField apartHoInput;
	private TextField nameSearchInput;
	private JTable memberTable;
	//Program 측 생성자
	private TextField programNameInput;
	private TextField programWeekInput;
	private TextField programTimeInput;
	private TextField maxMemberInput;
	private TextField programSearchInput;
	private JTable programTable;
	
	int memberRow, memberID = 1;
	int programRow, programID = 1;
	ArrayList<Member> memberList;
	ArrayList<Program> programList;
	DefaultTableModel membertbl, programtbl;
	String memberHeader[]= new String[]{"회원ID", "이름", "전화번호", "아파트 동수", "아파트 호수"};
	String programHeader[]= new String[]{"프로그램ID", "프로그램명", "주(요일)", "타임", "최대인원"};
	
	public void displayMemberDetails(){
		membertbl.setRowCount(0);
		for(int i=0; i< memberList.size(); i++){
			Object[] obj={memberList.get(i).memberID
					, memberList.get(i).memberNameInput
					, memberList.get(i).phoneNumberInput
					, memberList.get(i).apartDongInput
					, memberList.get(i).apartHoInput};
			membertbl.addRow(obj);
		}
	}

	public MainClass() {
		initialize();
		memberList = new ArrayList<>();
		membertbl = new DefaultTableModel(memberHeader,0);
		memberTable.setModel(membertbl);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1100, 600);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		Box memberPage = Box.createHorizontalBox();
		tabbedPane.addTab("주민 등록", null, memberPage, null);
		Box programPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 등록", null, programPage, null);
		Box registPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 수강 등록", null, registPage, null);
	
		JPanel memberLeftPanel = new JPanel();
		memberPage.add(memberLeftPanel);
		memberLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원등록"));
		
		JPanel memberRightPanel = new JPanel();
		memberPage.add(memberRightPanel);
		memberRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원조회"));
		
		Box memberManageGroup = Box.createVerticalBox(); // 회원관리 수직 정렬
		memberLeftPanel.add(memberManageGroup);
		
		Box memberInputGroup = Box.createVerticalBox(); // 회원입력 수직 정렬
		memberManageGroup.add(memberInputGroup);
		
		Box memberButtonGroup = Box.createVerticalBox(); // 관리버튼 수직 정렬
		memberManageGroup.add(memberButtonGroup);
		
		Label memberName = new Label("이름"); // 이름 라벨
		memberInputGroup.add(memberName);
		
		memberNameInput = new TextField(10); // 이름 입력 텍스트 필드
		memberInputGroup.add(memberNameInput);
		
		Label phoneNumber = new Label("전화번호"); // 전화번호 라벨
		memberInputGroup.add(phoneNumber);
		
		phoneNumberInput = new TextField(10); // 전화번호 입력 텍스트 필드
		memberInputGroup.add(phoneNumberInput);
		
		Label apartDong = new Label("아파트 동수"); // 아파트 동수 라벨
		memberInputGroup.add(apartDong);
		
		apartDongInput = new TextField(10); // 아파트 동수 입력 텍스트 필드
		memberInputGroup.add(apartDongInput);
		
		Label apartHo = new Label("아파트 호수"); // 아파트 호수 라벨
		memberInputGroup.add(apartHo);
		
		apartHoInput = new TextField(10); // 아파트 호수 입력 텍스트 필드
		memberInputGroup.add(apartHoInput);
		
		Button btnAdd = new Button("등록"); // 회원 정보 등록 버튼
		memberButtonGroup.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member data = new Member(
						memberID,
						memberNameInput.getText(),
						phoneNumberInput.getText(),
						apartDongInput.getText(),
						apartHoInput.getText());
				memberList.add(data);
				displayMemberDetails();
				memberID = memberID + 1;
			}
		});
		
		Button btnUpdate = new Button("수정"); // 회원 정보 수정 버튼
		memberButtonGroup.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberList.get(memberRow).memberNameInput = memberNameInput.getText();
				memberList.get(memberRow).phoneNumberInput = phoneNumberInput.getText();
				memberList.get(memberRow).apartDongInput = apartDongInput.getText();
				memberList.get(memberRow).apartHoInput = apartHoInput.getText();
				displayMemberDetails();
			}
		});
		
		Button btnDelete = new Button("삭제"); // 회원 정보 삭제 버튼
		memberButtonGroup.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "회원 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					membertbl.removeRow(memberRow);
					memberList.remove(memberRow);
					displayMemberDetails();
				}
				
			}
		});
		
		Button btnRefresh = new Button("초기화"); // 회원 정보 초기화 버튼
		memberButtonGroup.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				memberNameInput.setText("");
				phoneNumberInput.setText("");
				apartDongInput.setText("");
				apartHoInput.setText("");
			}
		});
		
		// 여기부터 조회 그룹
		Box lookUpGroup = Box.createVerticalBox(); // 조회 수직 정렬 그룹
		memberRightPanel.add(lookUpGroup);
		
		Box memberSearchGroup = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		lookUpGroup.add(memberSearchGroup);
		
		Label nameSearch = new Label("이름"); // 검색단 이름
		memberSearchGroup.add(nameSearch);
		
		nameSearchInput = new TextField(10); // 검색단 입력
		memberSearchGroup.add(nameSearchInput);
		
		Button nameSearchButton = new Button("검색"); // 검색 버튼
		memberSearchGroup.add(nameSearchButton);
		
		JScrollPane memberTableScroll = new JScrollPane(); // 테이블 스크롤 기능을 위한 패널
		lookUpGroup.add(memberTableScroll);
		
		memberTable = new JTable(); // 테이블
		memberTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				memberRow = memberTable.getSelectedRow();
				memberNameInput.setText(membertbl.getValueAt(memberRow, 1).toString());
				phoneNumberInput.setText(membertbl.getValueAt(memberRow, 2).toString());
				apartDongInput.setText(membertbl.getValueAt(memberRow, 3).toString());
				apartHoInput.setText(membertbl.getValueAt(memberRow, 4).toString());
			}
		});
		memberTableScroll.setViewportView(memberTable);
		
	}

}
