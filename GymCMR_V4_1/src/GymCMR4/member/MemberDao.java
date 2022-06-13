package GymCMR4.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mmpdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//��� ��ư ������ mysql �����ؼ� �߰�
	public int insertMember(String name, String phoneNum, String apartDong, String apartHo) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into membertbl (m_Name, m_Phone, m_dong, m_ho) values ( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);// �̸�
			pstmt.setString(2, phoneNum);// ��ȭ��ȣ
			pstmt.setString(3, apartDong);// ��
			pstmt.setString(4, apartHo);//ȣ
			int result = pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}
	
	//���� ��ư mysql
	public int changeMember(String name, String phoneNum, String apartDong, String apartHo) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update membertbl set m_Name = ?, m_phone = ?, m_dong = ?, m_ho= ? where m_Name = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, apartDong);
			pstmt.setString(4, apartHo);
			pstmt.setString(5, name);
			int result = pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}
	
	//������ư mysql
	public int deleteMember(String name, String phoneNum, String apartDong, String apartHo) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from membertbl where m_Name = ? and m_Phone = ? and m_dong = ? and m_ho = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, apartDong);
			pstmt.setString(4, apartHo);
			int result = pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}

}
