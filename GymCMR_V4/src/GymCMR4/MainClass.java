package GymCMR4;

/* 120~130�� ���� ȸ�� ��� ������
 * 250~260�� ���� ���α׷� ������
 * 390~400�� ���� ���α׷� ���������
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
	//Member ������
	private TextField memberNameInput;
	private TextField phoneNumberInput;
	private TextField apartDongInput;
	private TextField apartHoInput;
	private TextField nameSearchInput;
	private JTable memberTable;
	//Program ������
	private TextField programNameInput;
	private TextField programWeekInput;
	private TextField programTimeInput;
	private TextField maxMemberInput;
	private TextField programSearchInput;
	private JTable programTable;
	//Regist ������
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

	int memberRow, memberID = 1;
	int programRow, programID = 1;
	ArrayList<Member> memberList;
	ArrayList<Program> programList;
	DefaultTableModel membertbl, programtbl;
	String memberHeader[]= new String[]{"ȸ��ID", "�̸�", "��ȭ��ȣ", "����Ʈ ����", "����Ʈ ȣ��"}; // ȸ�� ���̺� ���
	String programHeader[]= new String[]{"���α׷�ID", "���α׷���", "��(����)", "Ÿ��(����, ����)", "�ִ��ο�"}; // ���α׷� ���̺� ���
	
	
	// ȸ�� ���̺� �ʱ�ȭ�� ���� �κ�
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
	
	// ���α׷� ���̺� �ʱ�ȭ�� ���� �κ�
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
		
		// â ȭ�鿡 ���� �κ�
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1100, 600);
		
		// �� ����
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		Box memberPage = Box.createHorizontalBox();
		tabbedPane.addTab("�ֹ� ���", null, memberPage, null);
		Box programPage = Box.createHorizontalBox();
		tabbedPane.addTab("���α׷� ���", null, programPage, null);
		Box registPage = Box.createHorizontalBox();
		tabbedPane.addTab("���α׷� ���� ���", null, registPage, null);
		
		
		// ȸ�� ��� ������ ����
		JPanel memberLeftPanel = new JPanel();
		memberPage.add(memberLeftPanel);
		memberLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"ȸ�����"));
		
		JPanel memberRightPanel = new JPanel();
		memberPage.add(memberRightPanel);
		memberRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"ȸ����ȸ"));
		
		Box memberManageGroup = Box.createVerticalBox(); // ȸ������ ���� ����
		memberLeftPanel.add(memberManageGroup);
		
		Box memberInputGroup = Box.createVerticalBox(); // ȸ���Է� ���� ����
		memberManageGroup.add(memberInputGroup);
		
		Box memberButtonGroup = Box.createVerticalBox(); // ������ư ���� ����
		memberManageGroup.add(memberButtonGroup);
		
		Label memberName = new Label("�̸�"); // �̸� ��
		memberInputGroup.add(memberName);
		
		memberNameInput = new TextField(10); // �̸� �Է� �ؽ�Ʈ �ʵ�
		memberInputGroup.add(memberNameInput);
		
		Label phoneNumber = new Label("��ȭ��ȣ"); // ��ȭ��ȣ ��
		memberInputGroup.add(phoneNumber);
		
		phoneNumberInput = new TextField(10); // ��ȭ��ȣ �Է� �ؽ�Ʈ �ʵ�
		memberInputGroup.add(phoneNumberInput);
		
		Label apartDong = new Label("����Ʈ ����"); // ����Ʈ ���� ��
		memberInputGroup.add(apartDong);
		
		apartDongInput = new TextField(10); // ����Ʈ ���� �Է� �ؽ�Ʈ �ʵ�
		memberInputGroup.add(apartDongInput);
		
		Label apartHo = new Label("����Ʈ ȣ��"); // ����Ʈ ȣ�� ��
		memberInputGroup.add(apartHo);
		
		apartHoInput = new TextField(10); // ����Ʈ ȣ�� �Է� �ؽ�Ʈ �ʵ�
		memberInputGroup.add(apartHoInput);
		
		Button memberBtnAdd = new Button("���"); // ȸ�� ���� ��� ��ư
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
			}
		});
		
		Button memberBtnUpdate = new Button("����"); // ȸ�� ���� ���� ��ư
		memberButtonGroup.add(memberBtnUpdate);
		memberBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberList.get(memberRow).memberNameInput = memberNameInput.getText();
				memberList.get(memberRow).phoneNumberInput = phoneNumberInput.getText();
				memberList.get(memberRow).apartDongInput = apartDongInput.getText();
				memberList.get(memberRow).apartHoInput = apartHoInput.getText();
				displayMemberDetails();
			}
		});
		
		Button memberBtnDelete = new Button("����"); // ȸ�� ���� ���� ��ư
		memberButtonGroup.add(memberBtnDelete);
		memberBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "ȸ�� ������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					membertbl.removeRow(memberRow);
					memberList.remove(memberRow);
					displayMemberDetails();
				}
				
			}
		});
		
		Button memberBtnRefresh = new Button("�ʱ�ȭ"); // ȸ�� ���� �ʱ�ȭ ��ư
		memberButtonGroup.add(memberBtnRefresh);
		memberBtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				memberNameInput.setText("");
				phoneNumberInput.setText("");
				apartDongInput.setText("");
				apartHoInput.setText("");
			}
		});
		
		// ������� ȸ�� ��ȸ �׷�
		Box memberLookUpGroup = Box.createVerticalBox(); // ��ȸ ���� ���� �׷�
		memberRightPanel.add(memberLookUpGroup);
		
		Box memberSearchGroup = Box.createHorizontalBox(); // �˻����� ���� �׷�
		memberLookUpGroup.add(memberSearchGroup);
		
		Label memberNameSearch = new Label("�̸�"); // �˻��� �̸�
		memberSearchGroup.add(memberNameSearch);
		memberNameSearch.setAlignment(Label.CENTER);
		
		nameSearchInput = new TextField(10); // �˻��� �Է�
		memberSearchGroup.add(nameSearchInput);
		
		Button nameSearchButton = new Button("�˻�"); // �˻� ��ư
		memberSearchGroup.add(nameSearchButton);
		
		Label memberSearchVoid = new Label("                  "); // ����
		memberSearchGroup.add(memberSearchVoid);
		
		JScrollPane memberTableScroll = new JScrollPane(); // ���̺� ��ũ�� ����� ���� �г�
		memberLookUpGroup.add(memberTableScroll);
		
		memberTable = new JTable(); // ���̺�
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
		 * ������� ���α׷� â�Դϴ�
		 */
		
		JPanel programLeftPanel = new JPanel();
		programPage.add(programLeftPanel);
		programLeftPanel.setBorder(new TitledBorder( new EtchedBorder(),"���α׷����"));
		
		JPanel programRightPanel = new JPanel();
		programPage.add(programRightPanel);
		programRightPanel.setBorder(new TitledBorder( new EtchedBorder(),"���α׷���ȸ"));
		
		Box programManageGroup = Box.createVerticalBox(); // ���α׷����� ���� ����
		programLeftPanel.add(programManageGroup);
		
		Box programInputGroup = Box.createVerticalBox(); // ���α׷��Է� ���� ����
		programManageGroup.add(programInputGroup);
		
		Box programBtnGroup = Box.createVerticalBox(); // ���α׷� ������ư ���� ����
		programManageGroup.add(programBtnGroup);
		
		Label programName = new Label("���α׷���"); // ���α׷��� ��
		programInputGroup.add(programName);
		
		programNameInput = new TextField(10); // ���α׷��� �Է� �ؽ�Ʈ �ʵ�
		programInputGroup.add(programNameInput);
		
		Label programWeek = new Label("��(����)"); // ��(����) ��
		programInputGroup.add(programWeek);
		
		programWeekInput = new TextField(10); // ��(����)�Է� �ؽ�Ʈ �ʵ�
		programInputGroup.add(programWeekInput);
		
		Label programTime = new Label("Ÿ��(����, ����)"); // Ÿ��(����, ����) ��
		programInputGroup.add(programTime);
		
		programTimeInput = new TextField(10); // Ÿ��(����, ����) �Է� �ؽ�Ʈ �ʵ�
		programInputGroup.add(programTimeInput);
		
		Label maxMember = new Label("�ִ��ο�"); // �ִ� �ο� ��
		programInputGroup.add(maxMember);
		
		maxMemberInput = new TextField(10); // �ִ� �ο� �Է� �ؽ�Ʈ �ʵ�
		programInputGroup.add(maxMemberInput);
		
		Button programBtnAdd = new Button("���"); // ���α׷� ���� ��� ��ư
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
					JOptionPane.showMessageDialog(null, "�ִ��ο��� �ڿ����� �Է����ּ���");
				}
				
				displayProgramDetails();
				programID = programID + 1;
			}
		});
		
		Button programBtnUpdate = new Button("����"); // ���α׷� ���� ���� ��ư
		programBtnGroup.add(programBtnUpdate);
		programBtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programList.get(programRow).programNameInput = programNameInput.getText();
				programList.get(programRow).programWeekInput = programWeekInput.getText();
				programList.get(programRow).programTimeInput= programTimeInput.getText();
				programList.get(programRow).maxMemberInput = Integer.parseInt(maxMemberInput.getText());
				displayMemberDetails();
			}
		});
		
		Button programBtnDelete = new Button("����"); // ���α׷� ���� ���� ��ư
		programBtnGroup.add(programBtnDelete);
		programBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "���α׷� ������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					programtbl.removeRow(programRow);
					programList.remove(programRow);
					displayMemberDetails();
				}
				
			}
		});
		
		Button programBtnRefresh = new Button("�ʱ�ȭ"); // ���α׷� �Է� ���� �ʱ�ȭ ��ư
		programBtnGroup.add(programBtnRefresh);
		programBtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				programNameInput.setText("");
				programWeekInput.setText("");
				programTimeInput.setText("");
				maxMemberInput.setText("");
			}
		});
		
		// ������� ��ȸ �׷�
		Box programLookUpGroup = Box.createVerticalBox(); // ��ȸ ���� ���� �׷�
		programRightPanel.add(programLookUpGroup);
		
		Box programSearchGroup = Box.createHorizontalBox(); // �˻����� ���� �׷�
		programLookUpGroup.add(programSearchGroup);
		
		Label programNameSearch = new Label("�̸�"); // �˻��� �̸�
		programSearchGroup.add(programNameSearch);
		programNameSearch.setAlignment(Label.CENTER);
		
		programSearchInput = new TextField(10); // �˻��� �Է�
		programSearchGroup.add(programSearchInput);
		
		Button programSearchButton = new Button("�˻�"); // �˻� ��ư
		programSearchGroup.add(programSearchButton);
		
		Label programSearchVoid = new Label("                  "); // ����
		programSearchGroup.add(programSearchVoid);
		
		JScrollPane programTableScroll = new JScrollPane(); // ���̺� ��ũ�� ����� ���� �г�
		programLookUpGroup.add(programTableScroll);
		
		programTable = new JTable(); // ���̺�
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
		 * ������� ���α׷� ������� ������ �Դϴ�
		 */
		
		Box registTopPage = Box.createVerticalBox(); // �ֻ��� ���� ����
		registPage.add(registTopPage);
		
		Box mem_Pro_TopPage = Box.createHorizontalBox(); // ���� ��� ���� ����
		registTopPage.add(mem_Pro_TopPage);
		
		
		// ������� �ؽ�Ʈ �ʵ�
		JPanel mem_Pro_TextField = new JPanel(); // �ؽ�Ʈ�ʵ� ž �г�
		mem_Pro_TopPage.add(mem_Pro_TextField);
		
		Box mem_Pro_TextBox = Box.createVerticalBox(); // �ؽ�Ʈ �� �ؽ�Ʈ ���� ����
		mem_Pro_TextField.add(mem_Pro_TextBox);
		
		Box mem_Pro_Label_Text = Box.createHorizontalBox(); // �ؽ�Ʈ�ʵ� ���� ����
		mem_Pro_TextBox.add(mem_Pro_Label_Text);
		
		Box memberInputGroup2 = Box.createVerticalBox(); // ȸ�� �ؽ�Ʈ ���� ����
		mem_Pro_Label_Text.add(memberInputGroup2);
		
		Label memberName2 = new Label("�̸�"); // �̸� ��
		memberInputGroup2.add(memberName2);
		
		memberNameInput2 = new TextField(10); // �̸� ��� �ؽ�Ʈ �ʵ�
		memberInputGroup2.add(memberNameInput2);
		
		Label phoneNumber2 = new Label("��ȭ��ȣ"); // ��ȭ��ȣ ��
		memberInputGroup2.add(phoneNumber2);
		
		phoneNumberInput2 = new TextField(10); // ��ȭ��ȣ ��� �ؽ�Ʈ �ʵ�
		memberInputGroup2.add(phoneNumberInput2);
		
		Label apartDong2 = new Label("����Ʈ ����"); // ����Ʈ ���� ��
		memberInputGroup2.add(apartDong2);
		
		apartDongInput2 = new TextField(10); // ����Ʈ ���� ��� �ؽ�Ʈ �ʵ�
		memberInputGroup2.add(apartDongInput2);
		
		Label apartHo2 = new Label("����Ʈ ȣ��"); // ����Ʈ ȣ�� ��
		memberInputGroup2.add(apartHo2);
		
		apartHoInput2 = new TextField(10); // ����Ʈ ȣ�� ��� �ؽ�Ʈ �ʵ�
		memberInputGroup2.add(apartHoInput2);
		
		Box programInputGroup2 = Box.createVerticalBox(); // ���α׷� ��� ���� ����
		mem_Pro_Label_Text.add(programInputGroup2);
		
		Label programName2 = new Label("���α׷���"); // ���α׷��� ��
		programInputGroup2.add(programName2);
		
		programNameInput2 = new TextField(10); // ���α׷��� ��� �ؽ�Ʈ �ʵ�
		programInputGroup2.add(programNameInput2);
		
		Label programWeek2 = new Label("��(����)"); // ��(����) ��
		programInputGroup2.add(programWeek2);
		
		programWeekInput2 = new TextField(10); // ��(����) ��� �ؽ�Ʈ �ʵ�
		programInputGroup2.add(programWeekInput2);
		
		Label programTime2 = new Label("Ÿ��(����, ����)"); // Ÿ��(����, ����) ��
		programInputGroup2.add(programTime2);
		
		programTimeInput2 = new TextField(10); // Ÿ��(����, ����) ��� �ؽ�Ʈ �ʵ�
		programInputGroup2.add(programTimeInput2);
		
		Label maxMember2 = new Label("�ִ��ο�"); // �ִ� �ο� ��
		programInputGroup2.add(maxMember2);
		
		maxMemberInput2 = new TextField(10); // �ִ� �ο� ��� �ؽ�Ʈ �ʵ�
		programInputGroup2.add(maxMemberInput2);
		
		
		// ������� ��ư �ʵ�
		Box mem_Pro_Button = Box.createVerticalBox(); // �ؽ�Ʈ �� ��ư ���� ����
		mem_Pro_TextBox.add(mem_Pro_Button);
		
		Box regist_Modify_Btn = Box.createHorizontalBox();
		mem_Pro_Button.add(regist_Modify_Btn);
		
		Button registBtnAdd = new Button("�����������"); // ��� ��ư
		regist_Modify_Btn.add(registBtnAdd);
		
		Button registBtnUpdate = new Button("������������"); // ���� ��ư
		regist_Modify_Btn.add(registBtnUpdate);
		
		Box delete_Refresh_Btn = Box.createHorizontalBox();
		mem_Pro_Button.add(delete_Refresh_Btn);
		
		Button registBtnDelete = new Button("������������"); // ���� ��ư
		regist_Modify_Btn.add(registBtnDelete);
		
		Button registBtnRefresh = new Button("�ʱ�ȭ"); // ���� �ʱ�ȭ ��ư
		regist_Modify_Btn.add(registBtnRefresh);
		
		
		// ������� ���̺� �ʵ�
		JPanel mem_Pro_TableField = new JPanel();
		mem_Pro_TopPage.add(mem_Pro_TableField);
		
		Box mem_Pro_TableBox = Box.createVerticalBox();
		mem_Pro_TableField.add(mem_Pro_TableBox);
		
		Box memberSearchGroup2 = Box.createHorizontalBox(); // �˻����� ���� �׷�
		mem_Pro_TableBox.add(memberSearchGroup2);
		
		Label memberNameSearch2 = new Label("�̸�"); // �˻��� �̸�
		memberSearchGroup2.add(memberNameSearch2);
		memberNameSearch2.setAlignment(Label.CENTER);
		
		nameSearchInput2 = new TextField(10); // �˻��� �Է�
		memberSearchGroup2.add(nameSearchInput2);
		
		Button nameSearchButton2 = new Button("�˻�"); // �˻� ��ư
		memberSearchGroup2.add(nameSearchButton2);
		
		Label memberSearchVoid2 = new Label("                  "); // ����
		memberSearchGroup2.add(memberSearchVoid2);
		
		JScrollPane memberTableScroll2 = new JScrollPane(); // ���̺� ��ũ�� ����� ���� �г�
		mem_Pro_TableBox.add(memberTableScroll2);
		
		memberTable2 = new JTable(); // ���̺�
		
		
		Box programSearchGroup2 = Box.createHorizontalBox(); // �˻����� ���� �׷�
		mem_Pro_TableBox.add(programSearchGroup2);
		
		Label programNameSearch2 = new Label("�̸�"); // �˻��� �̸�
		programSearchGroup2.add(programNameSearch2);
		programNameSearch2.setAlignment(Label.CENTER);
		
		programSearchInput2 = new TextField(10); // �˻��� �Է�
		programSearchGroup2.add(programSearchInput2);
		
		Button programSearchButton2 = new Button("�˻�"); // �˻� ��ư
		programSearchGroup2.add(programSearchButton2);
		
		Label programSearchVoid2 = new Label("                  "); // ����
		programSearchGroup2.add(programSearchVoid2);
		
		JScrollPane programTableScroll2 = new JScrollPane(); // ���̺� ��ũ�� ����� ���� �г�
		mem_Pro_TableBox.add(programTableScroll2);
		
		
		programTable2 = new JTable(); // ���̺�
		
		
		
		// ������� ��� ���̺�
		Box registLookUpGroup = Box.createVerticalBox(); // ��ȸ ���� ���� �׷�
		registTopPage.add(registLookUpGroup);
		
		Box registSearchGroup = Box.createHorizontalBox(); // �˻����� ���� �׷�
		registLookUpGroup.add(registSearchGroup);
		
		Label registNameSearch = new Label("�̸�"); // �˻��� �̸�
		registSearchGroup.add(registNameSearch);
		registNameSearch.setAlignment(Label.CENTER);
		
		registSearchInput = new TextField(10); // �˻��� �Է�
		registSearchGroup.add(registSearchInput);
		
		Button registSearchButton = new Button("�˻�"); // �˻� ��ư
		registSearchGroup.add(registSearchButton);
		
		Label registSearchVoid = new Label("                  "); // ����
		registSearchGroup.add(registSearchVoid);
		
		JScrollPane registScrollPane = new JScrollPane();
		registTopPage.add(registScrollPane);
		
		registTable = new JTable();
		
	}

}
