package GymCMR5.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mmpdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//등록 버튼 연동
	public int insertProgram(String name, String week, String time,int maxMember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into programtbl (p_Name, p_Week, p_Time, p_MaxMem) values ( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);//이름
			pstmt.setString(2, week);//요일
			pstmt.setString(3, time);//시간
			pstmt.setInt(4, maxMember);//최대인원
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
	
	//수정 버튼mysql
	public int changeProgram(String name, String week, String time, int maxMember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update programtbl set p_Name = ?, p_Week = ?, p_Time = ?, p_MaxMem= ? where p_Name = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, week);
			pstmt.setString(3, time);
			pstmt.setInt(4, maxMember);
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
	
	//삭제버튼 
	public int deleteProgram(String name, String week, String time, int maxMember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from programtbl where p_Name = ? and p_Week = ? and p_Time = ? and p_MaxMem = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, week);
			pstmt.setString(3, time);
			pstmt.setInt(4, maxMember);
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
