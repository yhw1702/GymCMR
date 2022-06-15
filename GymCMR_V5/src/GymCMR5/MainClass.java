package GymCMR5;

/* 170줄 부터 회원 페이지
 * 300줄 부터 프로그램 페이지
 * 450줄 부터 프로그램 등록 페이지
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GymCMR5.member.MemberDao;
import GymCMR5.program.ProgramDao;
import GymCMR5.regist.RegistDao;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainClass {

	public JFrame frame;
	// Member 생성자
	private TextField memberNameInput;
	private TextField phoneNumberInput;
	private TextField apartDongInput;
	private TextField apartHoInput;
	private TextField nameSearchInput;
	private JTable memberTable;
	// Program 생성자
	private TextField programNameInput;
	private TextField programWeekInput;
	private TextField programTimeInput;
	private TextField maxMemberInput;
	private TextField programSearchInput;
	private JTable programTable;
	// Regist 생성자
	private TextField memberNameInput2;
	private TextField phoneNumberInput2;
	private TextField apartDongInput2;
	private TextField apartHoInput2;
	private TextField nameSearchInput2;
	private JTable memberTable2;
	private TextField programNameInput2;
	private TextField programWeekInput2;
	private TextField programTimeInput2;
	private TextField maxMemberInput2;
	private TextField programSearchInput2;
	private JTable programTable2;
	private TextField registSearchInput;
	private JTable registTable;
	
	private TextField registMemberName;
	private TextField registProgramName;
	private TextField registProgramWeek;
	private TextField registProgramTime;
	private TextField registMaxMember;
	
	
	int memberRow, programRow, registRow;
	int memberID = 1;
	int programID = 1;
	int registID = 1;
	ArrayList<Member> memberList;
	ArrayList<Member> memberList2;
	ArrayList<Program> programList;
	ArrayList<Program> programList2;
	ArrayList<Regist> registList;
	DefaultTableModel membertbl, programtbl, membertbl2, programtbl2, registtbl;
	
	// 회원 테이블 헤더
	String memberHeader[]= new String[]{"회원ID", "이름", "전화번호", "아파트 동수", "아파트 호수"};
	// 프로그램 테이블 헤더
	String programHeader[]= new String[]{"프로그램ID", "프로그램명", "주(요일)", "타임(오전, 오후)", "최대인원"};
	// 수강등록 테이블 헤더
	String registHeader[]= new String[]{"수강등록ID", "이름", "프로그램명", "주(요일)", "타임(오전, 오후)", "최대인원"};
	
	
	// 회원 테이블에 정보를 저장
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
	
	// 수강등록 페이지 회원 테이블에 정보를 저장
	public void displayMemberDetails2(){
		membertbl2.setRowCount(0);
		for(int i=0; i< memberList.size(); i++){
			Object[] obj2={memberList.get(i).memberID
					, memberList.get(i).memberNameInput
					, memberList.get(i).phoneNumberInput
					, memberList.get(i).apartDongInput
					, memberList.get(i).apartHoInput};
			membertbl2.addRow(obj2);
		}
	}
	
	// 프로그램 테이블 정보를 저장
	public void displayProgramDetails(){
		programtbl.setRowCount(0);
		for(int i=0; i< programList.size(); i++){
			Object[] obj3={programList.get(i).programID
					, programList.get(i).programNameInput
					, programList.get(i).programWeekInput
					, programList.get(i).programTimeInput
					, programList.get(i).maxMemberInput};
			programtbl.addRow(obj3);
		}
	}
	
	// 수강등록 페이지 프로그램 테이블에 정보를 저장
	public void displayProgramDetails2(){
		programtbl2.setRowCount(0);
		for(int i=0; i< programList.size(); i++){
			Object[] obj4={programList.get(i).programID
					, programList.get(i).programNameInput
					, programList.get(i).programWeekInput
					, programList.get(i).programTimeInput
					, programList.get(i).maxMemberInput};
			programtbl2.addRow(obj4);
		}
	}
	
	public void displayRegistDetails(){
		registtbl.setRowCount(0);
		for(int i=0; i< registList.size(); i++){
			Object[] obj5={registList.get(i).registID
					, registList.get(i).registMemberName
					, registList.get(i).registProgramName
					, registList.get(i).registProgramWeek
					, registList.get(i).registProgramTime
					, registList.get(i).registMaxMember};
			registtbl.addRow(obj5);
		}
	}
	
	public MainClass() {
		initialize();
		memberList = new ArrayList<>();
		programList = new ArrayList<>();
		memberList2 = new ArrayList<>();
		programList2 = new ArrayList<>();
		registList = new ArrayList<>();
		membertbl = new DefaultTableModel(memberHeader,0);
		programtbl = new DefaultTableModel(programHeader,0);
		membertbl2 = new DefaultTableModel(memberHeader,0);
		programtbl2 = new DefaultTableModel(programHeader,0);
		registtbl = new DefaultTableModel(registHeader,0);
		memberTable.setModel(membertbl);
		programTable.setModel(programtbl);
		memberTable2.setModel(membertbl2);
		programTable2.setModel(programtbl2);
		registTable.setModel(registtbl);
	}

	private void initialize() {
		
		// 창 화면에 관한 부분
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1100, 600); // 창 사이즈
		
		// 탭 설정
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		Box memberPage = Box.createHorizontalBox();
		tabbedPane.addTab("주민 등록", null, memberPage, null);
		Box programPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 등록", null, programPage, null);
		Box registPage = Box.createHorizontalBox();
		tabbedPane.addTab("프로그램 수강 등록", null, registPage, null);
		
		
		// 회원 등록 페이지 시작
		JPanel memberLeftPanel = new JPanel();
		memberPage.add(memberLeftPanel);
		memberLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원등록"));
		
		JPanel memberRightPanel = new JPanel();
		memberPage.add(memberRightPanel);
		memberRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"회원조회"));
		
		Box memberManageGroup = Box.createVerticalBox(); // 회원관리탭 수직 정렬 박스
		memberLeftPanel.add(memberManageGroup);
		
		Box memberInputGroup = Box.createVerticalBox(); // 회원입력그룹 수직 정렬 박스
		memberManageGroup.add(memberInputGroup);
		
		Box memberButtonGroup = Box.createVerticalBox(); // 회원관리버튼그룹 수직 정렬 박스
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
		
		apartHoInput = new TextField(10); // 아파트 호수 입력 라벨
		memberInputGroup.add(apartHoInput);
		
		// 회원 정보 등록 버튼
		Button memberBtnAdd = new Button("등록");
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
					memberList2.add(memberData);
					memberID = memberID + 1;
					displayMemberDetails();
					displayMemberDetails2();
					
					String name = memberNameInput.getText();
					String phoneNum = phoneNumberInput.getText();
					String apartDong = apartDongInput.getText();
					String apartHo = apartHoInput.getText();
					
					MemberDao dao = new MemberDao();
					int result = dao.insertMember(name, phoneNum, apartDong, apartHo);
			}
		});
		
		// 회원 정보 수정 버튼
		Button memberBtnUpdate = new Button("수정");
		memberButtonGroup.add(memberBtnUpdate);
		memberBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberList.get(memberRow).memberNameInput = memberNameInput.getText();
				memberList.get(memberRow).phoneNumberInput = phoneNumberInput.getText();
				memberList.get(memberRow).apartDongInput = apartDongInput.getText();
				memberList.get(memberRow).apartHoInput = apartHoInput.getText();
				displayMemberDetails();
				displayMemberDetails2();
				
				String name = memberNameInput.getText();
				String phoneNum = phoneNumberInput.getText();
				String apartDong = apartDongInput.getText();
				String apartHo = apartHoInput.getText();
				
				MemberDao dao = new MemberDao();
				int result = dao.changeMember(name, phoneNum, apartDong, apartHo);
			}
		});
		
		// 회원 정보 삭제 버튼
		Button memberBtnDelete = new Button("삭제");
		memberButtonGroup.add(memberBtnDelete);
		memberBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "회원 정보를 삭제 하시겠습니까?"
						, "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					membertbl.removeRow(memberRow);
					memberList.remove(memberRow);
					displayMemberDetails();
					displayMemberDetails2();
					
					String name = memberNameInput.getText();
					String phoneNum = phoneNumberInput.getText();
					String apartDong = apartDongInput.getText();
					String apartHo = apartHoInput.getText();
					
					MemberDao dao = new MemberDao();
					int result = dao.deleteMember(name, phoneNum, apartDong, apartHo);
				}
				
			}
		});
		
		// 회원 정보 초기화 버튼
		Button memberBtnRefresh = new Button("초기화");
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
		Box memberLookUpGroup = Box.createVerticalBox(); // 조회 수직 정렬 박스
		memberRightPanel.add(memberLookUpGroup);
		
		Box memberSearchGroup = Box.createHorizontalBox();  // 검색단을 묶는 박스
		memberLookUpGroup.add(memberSearchGroup);
		
		Label memberNameSearch = new Label("이름"); // 검색단 이름
		memberSearchGroup.add(memberNameSearch);
		memberNameSearch.setAlignment(Label.CENTER);
		
		nameSearchInput = new TextField(10); // 검색단 이름 이력 텍스트 필드
		memberSearchGroup.add(nameSearchInput);
		
		Button nameSearchButton = new Button("검색"); // 검색 버튼
		memberSearchGroup.add(nameSearchButton);
		
		Label memberSearchVoid = new Label("                  "); // 검색단 정렬을 위한 공백
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
		 * 여기부터 프로그램 페이지입니다
		 */
		
		JPanel programLeftPanel = new JPanel();
		programPage.add(programLeftPanel);
		programLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"프로그램등록"));
		
		JPanel programRightPanel = new JPanel();
		programPage.add(programRightPanel);
		programRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"프로그램조회"));
		
		Box programManageGroup = Box.createVerticalBox(); // 프로그램관리 수직 정렬 박스
		programLeftPanel.add(programManageGroup);
		
		Box programInputGroup = Box.createVerticalBox(); // 프로그램 입력단 수직 정렬 박스
		programManageGroup.add(programInputGroup);
		
		Box programBtnGroup = Box.createVerticalBox(); // 프로그램 관리버튼 수직 정렬 박스
		programManageGroup.add(programBtnGroup);
		
		Label programName = new Label("프로그램명"); // 프로그램명 라벨
		programInputGroup.add(programName);
		
		programNameInput = new TextField(10); // 프로그램명 입력 텍스트 필드
		programInputGroup.add(programNameInput);
		
		Label programWeek = new Label("주(요일)"); // 주(요일) 라벨
		programInputGroup.add(programWeek);
		
		programWeekInput = new TextField(10); // 주(요일) 입력 텍스트 필드
		programInputGroup.add(programWeekInput);
		
		Label programTime = new Label("타임(오전, 오후)"); // 타입(오전, 오후) 라벨
		programInputGroup.add(programTime);
		
		programTimeInput = new TextField(10); // 타임(오전, 오후) 입력 텍스트 피ㄹ드
		programInputGroup.add(programTimeInput);
		
		Label maxMember = new Label("최대인원"); // 최대인원 라벨
		programInputGroup.add(maxMember);
		
		maxMemberInput = new TextField(10); // 최대인원 입력 텍스트 필드
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
							programList2.add(programData);
							programID = programID + 1;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "최대인원에 자연수를 입력해주세요");
				}		
				displayProgramDetails();
				displayProgramDetails2();
				
				String name = programNameInput.getText();
				String week = programWeekInput.getText();
				String time = programTimeInput.getText();
				Integer maxMember = Integer.parseInt(maxMemberInput.getText());
				ProgramDao dao = new ProgramDao();
				int result = dao.insertProgram(name, week, time, maxMember);
				
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
				displayProgramDetails();
				displayProgramDetails2();
				
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
				int choice = JOptionPane.showConfirmDialog(null, "프로그램 정보를 삭제하시겠습니까?"
						, "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					programtbl.removeRow(programRow);
					programList.remove(programRow);
					displayProgramDetails();
					displayProgramDetails2();
					
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
		
		Label programSearchVoid = new Label("                  "); // 정렬을 위한 공백 라벨
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
		
		
		/*
		 *여기부터 프로그램 수강등록 페이지 입니다
		 */
		
		Box registTopPage = Box.createVerticalBox(); // 최상위 수직 정렬
		registPage.add(registTopPage);
		
		Box mem_Pro_TopPage = Box.createHorizontalBox(); // 수강 등록 수평 정렬
		registTopPage.add(mem_Pro_TopPage);
		
		
		// 여기부터 텍스트 필드
		JPanel mem_Pro_TextField = new JPanel(); // 텍스트필드 탑 패널
		mem_Pro_TopPage.add(mem_Pro_TextField);
		mem_Pro_TextField.setBorder(new TitledBorder( new EtchedBorder(),"수강등록"));
		
		Box mem_Pro_TextBox = Box.createVerticalBox(); // 텍스트단 텍스트 수직 정렬
		mem_Pro_TextField.add(mem_Pro_TextBox);
		
		Box mem_Pro_Label_Text = Box.createHorizontalBox(); // 텍스트필드 수평 정렬
		mem_Pro_TextBox.add(mem_Pro_Label_Text);
		
		Box memberInputGroup2 = Box.createVerticalBox(); // 회원 텍스트 수직 정렬
		mem_Pro_Label_Text.add(memberInputGroup2);
		
		Label memberName2 = new Label("이름"); // 이름 라벨
		memberInputGroup2.add(memberName2);
		
		memberNameInput2 = new TextField(10); // 이름 출력 텍스트 필드
		memberInputGroup2.add(memberNameInput2);
		
		Label phoneNumber2 = new Label("전화번호"); // 전화번호 라벨
		memberInputGroup2.add(phoneNumber2);
		
		phoneNumberInput2 = new TextField(10); // 전화번호 출력 텍스트 필드
		memberInputGroup2.add(phoneNumberInput2);
		
		Label apartDong2 = new Label("아파트 동수"); // 아파트 동수 라벨
		memberInputGroup2.add(apartDong2);
		
		apartDongInput2 = new TextField(10); // 아파트 동수 출력 텍스트 필드
		memberInputGroup2.add(apartDongInput2);
		
		Label apartHo2 = new Label("아파트 호수"); // 아파트 호수 라벨
		memberInputGroup2.add(apartHo2);
		
		apartHoInput2 = new TextField(10); // 아파트 호수 출력 텍스트 필드
		memberInputGroup2.add(apartHoInput2);
		
		Box programInputGroup2 = Box.createVerticalBox(); // 프로그램 출력 수직 정렬 박스
		mem_Pro_Label_Text.add(programInputGroup2);
		
		Label programName2 = new Label("프로그램명"); // 프로그램명 라벨
		programInputGroup2.add(programName2);
		
		programNameInput2 = new TextField(10); // 프로그램명 출력 텍스트 필드
		programInputGroup2.add(programNameInput2);
		
		Label programWeek2 = new Label("주(요일)"); // 주(요일) 라벨
		programInputGroup2.add(programWeek2);
		
		programWeekInput2 = new TextField(10); // 주(요일) 출력 텍스트 필드
		programInputGroup2.add(programWeekInput2);
		
		Label programTime2 = new Label("타임(오전, 오후)"); // 타임(오전, 오후) 라벨
		programInputGroup2.add(programTime2);
		
		programTimeInput2 = new TextField(10); // 타임(오전, 오후) 출력 텍스트 필드
		programInputGroup2.add(programTimeInput2);
		
		Label maxMember2 = new Label("최대인원"); // 최대 인원 라벨
		programInputGroup2.add(maxMember2);
		
		maxMemberInput2 = new TextField(10); // 최대 인원 출력 텍스트 필드
		programInputGroup2.add(maxMemberInput2);
		
		
		// 여기부터 버튼 필드
		Box mem_Pro_Button = Box.createVerticalBox(); // 텍스트 단 버튼 수직 정렬
		mem_Pro_TextBox.add(mem_Pro_Button);
		
		Box regist_Modify_Btn = Box.createHorizontalBox();
		mem_Pro_Button.add(regist_Modify_Btn);
		 
		Button registBtnAdd = new Button("수강정보등록"); // 등록 버튼
		regist_Modify_Btn.add(registBtnAdd);
		registBtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				Regist registData = new Regist(
						registID,
						memberNameInput2.getText(),
						programNameInput2.getText(),
						programWeekInput2.getText(),
						programTimeInput2.getText(),
						Integer.parseInt(maxMemberInput2.getText())
						);
					registList.add(registData);
					registID = registID + 1;
					displayRegistDetails();
					
						
					String name = memberNameInput2.getText();
					String program = programNameInput2.getText();
					String week = programWeekInput2.getText();
					String time = programTimeInput2.getText();
					Integer maxmember = Integer.parseInt(maxMemberInput2.getText());
					
					RegistDao dao = new RegistDao();
					int result1 = dao.insertRegist(name, program, week, time, maxmember);
			}
		});
		
		Button registBtnUpdate = new Button("수강정보수정"); // 수정 버튼
		regist_Modify_Btn.add(registBtnUpdate);
		registBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
		registList.get(registRow).registMemberName = memberNameInput2.getText();
		registList.get(registRow).registProgramName = programNameInput2.getText();
		registList.get(registRow).registProgramWeek = programWeekInput2.getText();
		registList.get(registRow).registProgramTime= programTimeInput2.getText();
		registList.get(registRow).registMaxMember = Integer.parseInt(maxMemberInput2.getText());
		displayRegistDetails();
		
		String name = memberNameInput2.getText();
		String program = programNameInput2.getText();
		String week = programWeekInput2.getText();
		String time = programTimeInput2.getText();
		int maxmember = Integer.parseInt(maxMemberInput2.getText());
		
		RegistDao dao = new RegistDao();
		int result = dao.changeRegist(name,program,week,time,maxmember);
			}
		});
		
		Button registBtnDelete = new Button("수강정보삭제"); // 삭제 버튼
		regist_Modify_Btn.add(registBtnDelete);
		
		registBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "수강등록을 취소하시겠습니까?"
						, "삭제", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					registtbl.removeRow(registRow);
					registList.remove(registRow);
					displayRegistDetails();
					String name = memberNameInput2.getText();
					String program = programNameInput2.getText();
					String week = programWeekInput2.getText();
					String time = programTimeInput2.getText();
					int maxmember = Integer.parseInt(maxMemberInput2.getText());
					
					RegistDao dao = new RegistDao();
					int result = dao.deleteRegist(name,program,week,time,maxmember);
				}
				
			}
		});
		// 여기부터 테이블 필드
		JPanel mem_Pro_TableField = new JPanel();
		mem_Pro_TopPage.add(mem_Pro_TableField);
		
		Box mem_Pro_TableBox = Box.createVerticalBox();
		mem_Pro_TableField.add(mem_Pro_TableBox);
		
		Box memberSearchGroup2 = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		mem_Pro_TableBox.add(memberSearchGroup2);
		
		Label memberNameSearch2 = new Label("이름"); // 검색단 이름
		memberSearchGroup2.add(memberNameSearch2);
		memberNameSearch2.setAlignment(Label.CENTER);
		
		nameSearchInput2 = new TextField(10); // 검색단 입력
		memberSearchGroup2.add(nameSearchInput2);
		
		Button nameSearchButton2 = new Button("검색"); // 검색 버튼
		memberSearchGroup2.add(nameSearchButton2);
		
		Label memberSearchVoid2 = new Label("                  "); // 공백
		memberSearchGroup2.add(memberSearchVoid2);
		
		JScrollPane memberTableScroll2 = new JScrollPane(); // 테이블 스크롤 기능을 위한 패널
		mem_Pro_TableBox.add(memberTableScroll2);
		
		memberTable2 = new JTable(); // 테이블
		memberTableScroll2.setViewportView(memberTable2);
		memberTableScroll2.setPreferredSize(new Dimension(650, 90));
		memberTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				memberRow = memberTable2.getSelectedRow();
				memberNameInput2.setText(membertbl2.getValueAt(memberRow, 1).toString());
				phoneNumberInput2.setText(membertbl2.getValueAt(memberRow, 2).toString());
				apartDongInput2.setText(membertbl2.getValueAt(memberRow, 3).toString());
				apartHoInput2.setText(membertbl2.getValueAt(memberRow, 4).toString());
			}
		});
		
		
		Box programSearchGroup2 = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		mem_Pro_TableBox.add(programSearchGroup2);
		
		Label programNameSearch2 = new Label("프로그램명"); // 검색단 이름
		programSearchGroup2.add(programNameSearch2);
		programNameSearch2.setAlignment(Label.CENTER);
		
		programSearchInput2 = new TextField(10); // 검색단 입력
		programSearchGroup2.add(programSearchInput2);
		
		Button programSearchButton2 = new Button("검색"); // 검색 버튼
		programSearchGroup2.add(programSearchButton2);
		
		Label programSearchVoid2 = new Label("                  "); // 공백
		programSearchGroup2.add(programSearchVoid2);
		
		JScrollPane programTableScroll2 = new JScrollPane(); // 테이블 스크롤 기능을 위한 패널
		mem_Pro_TableBox.add(programTableScroll2);
		
		programTable2 = new JTable(); // 테이블
		programTableScroll2.setViewportView(programTable2);
		programTableScroll2.setPreferredSize(new Dimension(650, 90));
		programTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				programRow = programTable2.getSelectedRow();
				programNameInput2.setText(programtbl2.getValueAt(programRow, 1).toString());
				programWeekInput2.setText(programtbl2.getValueAt(programRow, 2).toString());
				programTimeInput2.setText(programtbl2.getValueAt(programRow, 3).toString());
				maxMemberInput2.setText(programtbl2.getValueAt(programRow, 4).toString());
			}
		});
		
		
		// 여기부터 등록 테이블
		Box registLookUpGroup = Box.createVerticalBox(); // 조회 수직 정렬 그룹
		registTopPage.add(registLookUpGroup);
		registLookUpGroup.setBorder(new TitledBorder( new EtchedBorder(),"수강등록확인"));
		
		Box registSearchGroup = Box.createHorizontalBox(); // 검색단을 묶는 그룹
		registLookUpGroup.add(registSearchGroup);
		
		Label registNameSearch = new Label("이름"); // 검색단 이름
		registSearchGroup.add(registNameSearch);
		registNameSearch.setAlignment(Label.CENTER);
		
		registSearchInput = new TextField(10); // 검색단 입력
		registSearchGroup.add(registSearchInput);
		
		Button registSearchButton = new Button("검색"); // 검색 버튼
		registSearchGroup.add(registSearchButton);
		
		Label registSearchVoid = new Label("                  "); // 공백
		registSearchGroup.add(registSearchVoid);
		
		JScrollPane registScrollPane = new JScrollPane();
		registTopPage.add(registScrollPane);
		
		registTable = new JTable();
		registScrollPane.setViewportView(registTable);
		registTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registRow = registTable.getSelectedRow();
				registMemberName.setText(registtbl.getValueAt(registRow, 1).toString());
				registProgramName.setText(registtbl.getValueAt(registRow, 2).toString());
				registProgramWeek.setText(registtbl.getValueAt(registRow, 3).toString());
				registProgramTime.setText(registtbl.getValueAt(registRow, 3).toString());
				registMaxMember.setText(registtbl.getValueAt(registRow, 4).toString());
			}
		});
	}

}
