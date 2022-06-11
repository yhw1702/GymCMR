package Health.Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/health";
	String userid = "root";
	String password = "1234";

	Connection conn = null; 
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	//회원 정보 등록 메소드
	public int insertMember( String name, String phoneNum, String apartNum) {
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "insert into member (name, phoneNum, apartNum) values ( ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, apartNum);
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
