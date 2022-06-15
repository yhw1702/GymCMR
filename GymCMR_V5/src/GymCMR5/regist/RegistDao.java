package GymCMR5.regist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mmpdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//등록 버튼
	public int insertRegist(String name, String program, String week, String time, int maxmember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into registtbl (r_Name, r_Program, r_Week, r_Time, r_Maxmem) values ( ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);//이름
			pstmt.setString(2, program);//프로글래명
			pstmt.setString(3, week);//주
			pstmt.setString(4, time);//타임
			pstmt.setInt(5, maxmember);//최대인
			int result1 = pstmt.executeUpdate();
			return result1;
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
	
	//수정 버튼
	public int changeRegist(String name, String program, String week, String time, int maxmember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "update registtbl set r_Name = ?, r_Program = ?, r_Week = ?, r_Time= ?, r_Maxmem = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);//이름
			pstmt.setString(2, program);//프로글래명
			pstmt.setString(3, week);//주
			pstmt.setString(4, time);//호
			pstmt.setInt(5, maxmember);//최대인
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
	public int deleteRegist(String name, String program, String week, String time, int maxmember) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "delete from registtbl where r_Name = ? and r_Program = ? and r_Week = ? and r_Time = ? and r_Maxmem = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, program);
			pstmt.setString(3, week);
			pstmt.setString(4, time);
			pstmt.setInt(5, maxmember);
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