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
	//Member �� ������
	private TextField memberNameInput;
	private TextField phoneNumberInput;
	private TextField apartDongInput;
	private TextField apartHoInput;
	private TextField nameSearchInput;
	private JTable memberTable;
	//Program �� ������
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
	String memberHeader[]= new String[]{"ȸ��ID", "�̸�", "��ȭ��ȣ", "����Ʈ ����", "����Ʈ ȣ��"};
	String programHeader[]= new String[]{"���α׷�ID", "���α׷���", "��(����)", "Ÿ��", "�ִ��ο�"};
	
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
		tabbedPane.addTab("�ֹ� ���", null, memberPage, null);
		Box programPage = Box.createHorizontalBox();
		tabbedPane.addTab("���α׷� ���", null, programPage, null);
		Box registPage = Box.createHorizontalBox();
		tabbedPane.addTab("���α׷� ���� ���", null, registPage, null);
	
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
		
		Button btnAdd = new Button("���"); // ȸ�� ���� ��� ��ư
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
		
		Button btnUpdate = new Button("����"); // ȸ�� ���� ���� ��ư
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
		
		Button btnDelete = new Button("����"); // ȸ�� ���� ���� ��ư
		memberButtonGroup.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "ȸ�� ������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if(choice==0){
					membertbl.removeRow(memberRow);
					memberList.remove(memberRow);
					displayMemberDetails();
				}
				
			}
		});
		
		Button btnRefresh = new Button("�ʱ�ȭ"); // ȸ�� ���� �ʱ�ȭ ��ư
		memberButtonGroup.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				memberNameInput.setText("");
				phoneNumberInput.setText("");
				apartDongInput.setText("");
				apartHoInput.setText("");
			}
		});
		
		// ������� ��ȸ �׷�
		Box lookUpGroup = Box.createVerticalBox(); // ��ȸ ���� ���� �׷�
		memberRightPanel.add(lookUpGroup);
		
		Box memberSearchGroup = Box.createHorizontalBox(); // �˻����� ���� �׷�
		lookUpGroup.add(memberSearchGroup);
		
		Label nameSearch = new Label("�̸�"); // �˻��� �̸�
		memberSearchGroup.add(nameSearch);
		
		nameSearchInput = new TextField(10); // �˻��� �Է�
		memberSearchGroup.add(nameSearchInput);
		
		Button nameSearchButton = new Button("�˻�"); // �˻� ��ư
		memberSearchGroup.add(nameSearchButton);
		
		JScrollPane memberTableScroll = new JScrollPane(); // ���̺� ��ũ�� ����� ���� �г�
		lookUpGroup.add(memberTableScroll);
		
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
		
	}

}
