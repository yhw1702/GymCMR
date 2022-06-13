package GymCMR4;

/*
 * 230~240줄 부터 프로그램 페이
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GymCMR4.member.MemberDao;
import GymCMR4.program.ProgramDao;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	String memberHeader[]= new String[]{"회원ID", "이름", "전화번호", "아파트 동수", "아파트 호수"}; // 회원 테이블 헤더
	String programHeader[]= new String[]{"프로그램ID", "프로그램명", "주(요일)", "타임(오전, 오후)", "최대인원"}; // 프로그램 테이블 헤더
	
	
	// 회원 테이블 초기화에 관한 부분
	public void displayMemberDetails(){
		membertbl.setRowCount(0);
		for(int i=0; i< memberList.size(); i++){
			Object[] obj1={memberList.get(i).memberID
					, memberList.get(i).memberNameInput
					, memberList.get(i).phoneNumberInput
					, memberList.get(i).apartDongInput
					, memberList.get(i).apartHoInput};
			membertbl.addRow(obj1);
		}
	}
	
	// 프로그램 테이블 초기화에 관한 부분
	public void displayProgramDetails(){
		programtbl.setRowCount(0);
		for(int j=0; j< programList.size(); j++){
			Object[] obj2={programList.get(j).programID
					, programList.get(j).programNameInput
					, programList.get(j).programWeekInput
					, programList.get(j).programTimeInput
					, programList.get(j).maxMemberInput};
			programtbl.addRow(obj2);
		}
	}

	public MainClass() {
		initialize();
		memberList = new ArrayList<>(); 
		programList = new ArrayList<>();
		membertbl = new DefaultTableModel(memberHeader,0);
		programtbl = new DefaultTableModel(programHeader,0);
		memberTable.setModel(membertbl);
		programTable.setModel(programtbl);
	}

	private void initialize() {
		
		// 창 화면에 관한 부분
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1100, 600);
		
		// 탭 설정
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		Box memberPage = Box.createHorizontalBox();
		tabbedPane.addTab("주민 등록", null, memberPage, null);
		Box programPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 등록", null, programPage, null);
		Box registPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 수강 등록", null, registPage, null);
		
		
		// 회원 등록에 관한 부분
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
		
		Button memberBtnAdd = new Button("등록"); // 회원 정보 등록 버튼
		memberButtonGroup.add(memberBtnAdd);
		memberBtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member memberData = new Member(
						memberID,
						memberNameInput.getText(),
						phoneNumberInput.getText(),
						apartDongInput.getText(),
						apartHoInput.getText());
				memberList.add(memberData);
				displayMemberDetails();
				memberID = memberID + 1;
				
				String name = memberNameInput.getText();
				String phoneNum = phoneNumberInput.getText();
				String apartDong = apartDongInput.getText();
				String apartHo = apartHoInput.getText();
				
				MemberDao dao = new MemberDao();
				int result = dao.insertMember(name,phoneNum,apartDong,apartHo);
			}
		});
		
		Button memberBtnUpdate = new Button("수정"); // 회원 정보 수정 버튼
		memberButtonGroup.add(memberBtnUpdate);
		memberBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberList.get(memberRow).memberNameInput = memberNameInput.getText();
				memberList.get(memberRow).phoneNumberInput = phoneNumberInput.getText();
				memberList.get(memberRow).apartDongInput = apartDongInput.getText();
				memberList.get(memberRow).apartHoInput = apartHoInput.getText();
				displayMemberDetails();
				
				String name = memberNameInput.getText();
				String phoneNum = phoneNumberInput.getText();
				String apartDong = apartDongInput.getText();
				String apartHo = apartHoInput.getText();
				
				MemberDao dao = new MemberDao();
				int result = dao.changeMember(name,phoneNum,apartDong,apartHo);
			}
		});
		
		Button memberBtnDelete = new Button("삭제"); // 회원 정보 삭제 버튼
		memberButtonGroup.add(memberBtnDelete);
		memberBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "회원 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					membertbl.removeRow(memberRow);
					memberList.remove(memberRow);
					displayMemberDetails();
					
					String name = memberNameInput.getText();
					String phoneNum = phoneNumberInput.getText();
					String apartDong = apartDongInput.getText();
					String apartHo = apartHoInput.getText();
					
					MemberDao dao = new MemberDao();
					int result = dao.deleteMember(name,phoneNum,apartDong,apartHo);
				}
				
			}
		});
		
		Button memberBtnRefresh = new Button("초기화"); // 회원 정보 초기화 버튼
		memberButtonGroup.add(memberBtnRefresh);
		memberBtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				memberNameInput.setText("");
				phoneNumberInput.setText("");
				apartDongInput.setText("");
				apartHoInput.setText("");
				
				
			}
		});
		
		// 여기부터 회원 조회 그룹
		Box memberLookUpGroup = Box.createVerticalBox(); // 조회 수직 정렬 그룹
		memberRightPanel.add(memberLookUpGroup);
		
		Box memberSearchGroup = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		memberLookUpGroup.add(memberSearchGroup);
		
		Label memberNameSearch = new Label("이름"); // 검색단 이름
		memberSearchGroup.add(memberNameSearch);
		memberNameSearch.setAlignment(Label.CENTER);
		
		nameSearchInput = new TextField(10); // 검색단 입력
		memberSearchGroup.add(nameSearchInput);
		
		Button nameSearchButton = new Button("검색"); // 검색 버튼
		memberSearchGroup.add(nameSearchButton);
		
		Label memberSearchVoid = new Label("                  "); // 공백
		memberSearchGroup.add(memberSearchVoid);
		
		JScrollPane memberTableScroll = new JScrollPane(); // 테이블 스크롤 기능을 위한 패널
		memberLookUpGroup.add(memberTableScroll);
		
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
		
		/*
		 * 여기부터 프로그램 창입니다
		 */
		
		JPanel programLeftPanel = new JPanel();
		programPage.add(programLeftPanel);
		programLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"프로그램등록"));
		
		JPanel programRightPanel = new JPanel();
		programPage.add(programRightPanel);
		programRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"프로그램조회"));
		
		Box programManageGroup = Box.createVerticalBox(); // 프로그램관리 수직 정렬
		programLeftPanel.add(programManageGroup);
		
		Box programInputGroup = Box.createVerticalBox(); // 프로그램입력 수직 정렬
		programManageGroup.add(programInputGroup);
		
		Box programBtnGroup = Box.createVerticalBox(); // 프로그램 관리버튼 수직 정렬
		programManageGroup.add(programBtnGroup);
		
		Label programName = new Label("프로그램명"); // 프로그램명 라벨
		programInputGroup.add(programName);
		
		programNameInput = new TextField(10); // 프로그램명 입력 텍스트 필드
		programInputGroup.add(programNameInput);
		
		Label programWeek = new Label("주(요일)"); // 주(요일) 라벨
		programInputGroup.add(programWeek);
		
		programWeekInput = new TextField(10); // 주(요일)입력 텍스트 필드
		programInputGroup.add(programWeekInput);
		
		Label programTime = new Label("타임(오전, 오후)"); // 타임(오전, 오후) 라벨
		programInputGroup.add(programTime);
		
		programTimeInput = new TextField(10); // 타임(오전, 오후) 입력 텍스트 필드
		programInputGroup.add(programTimeInput);
		
		Label maxMember = new Label("최대인원"); // 최대 인원 라벨
		programInputGroup.add(maxMember);
		
		maxMemberInput = new TextField(10); // 최대 인원 입력 텍스트 필드
		programInputGroup.add(maxMemberInput);
		
		Button programBtnAdd = new Button("등록"); // 프로그램 정보 등록 버튼
		programBtnGroup.add(programBtnAdd);
		programBtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Program programData = new Program(
							programID,
							programNameInput.getText(),
							programWeekInput.getText(),
							programTimeInput.getText(),
							Integer.parseInt(maxMemberInput.getText())
							);
							programList.add(programData);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "최대인원에 자연수를 입력해주세요");
				}
				
				displayProgramDetails();
				programID = programID + 1;
				
				String name = programNameInput.getText();
				String week = programWeekInput.getText();
				String time = programTimeInput.getText();
				int maxMember = Integer.parseInt(maxMemberInput.getText());
				
				ProgramDao dao = new ProgramDao();
				int result = dao.insertProgram(name,week,time,maxMember);
			}
		});
		
		Button programBtnUpdate = new Button("수정"); // 프로그램 정보 수정 버튼
		programBtnGroup.add(programBtnUpdate);
		programBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programList.get(programRow).programNameInput = programNameInput.getText();
				programList.get(programRow).programWeekInput = programWeekInput.getText();
				programList.get(programRow).programTimeInput= programTimeInput.getText();
				programList.get(programRow).maxMemberInput = Integer.parseInt(maxMemberInput.getText());
				displayMemberDetails();
				
				String name = programNameInput.getText();
				String week = programWeekInput.getText();
				String time = programTimeInput.getText();
				int maxMember = Integer.parseInt(maxMemberInput.getText());
				
				ProgramDao dao = new ProgramDao();
				int result = dao.changeProgram(name,week,time,maxMember);
			}
		});
		
		Button programBtnDelete = new Button("삭제"); // 프로그램 정보 삭제 버튼
		programBtnGroup.add(programBtnDelete);
		programBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "프로그램 정보를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					programtbl.removeRow(programRow);
					programList.remove(programRow);
					displayMemberDetails();
					
					String name = programNameInput.getText();
					String week = programWeekInput.getText();
					String time = programTimeInput.getText();
					int maxMember = Integer.parseInt(maxMemberInput.getText());
					
					ProgramDao dao = new ProgramDao();
					int result = dao.deleteProgram(name,week,time,maxMember);
				}
				
			}
		});
		
		Button programBtnRefresh = new Button("초기화"); // 프로그램 입력 정보 초기화 버튼
		programBtnGroup.add(programBtnRefresh);
		programBtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				programNameInput.setText("");
				programWeekInput.setText("");
				programTimeInput.setText("");
				maxMemberInput.setText("");
			}
		});
		
		// 여기부터 조회 그룹
		Box programLookUpGroup = Box.createVerticalBox(); // 조회 수직 정렬 그룹
		programRightPanel.add(programLookUpGroup);
		
		Box programSearchGroup = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		programLookUpGroup.add(programSearchGroup);
		
		Label programNameSearch = new Label("이름"); // 검색단 이름
		programSearchGroup.add(programNameSearch);
		programNameSearch.setAlignment(Label.CENTER);
		
		programSearchInput = new TextField(10); // 검색단 입력
		programSearchGroup.add(programSearchInput);
		
		Button programSearchButton = new Button("검색"); // 검색 버튼
		programSearchGroup.add(programSearchButton);
		
		Label programSearchVoid = new Label("                  "); // 공백
		programSearchGroup.add(programSearchVoid);
		
		JScrollPane programTableScroll = new JScrollPane(); // 테이블 스크롤 기능을 위한 패널
		programLookUpGroup.add(programTableScroll);
		
		programTable = new JTable(); // 테이블
		programTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				programRow = programTable.getSelectedRow();
				programNameInput.setText(programtbl.getValueAt(programRow, 1).toString());
				programWeekInput.setText(programtbl.getValueAt(programRow, 2).toString());
				programTimeInput.setText(programtbl.getValueAt(programRow, 3).toString());
				maxMemberInput.setText(programtbl.getValueAt(programRow, 4).toString());
			}
		});
		programTableScroll.setViewportView(programTable);
		
	}

}
