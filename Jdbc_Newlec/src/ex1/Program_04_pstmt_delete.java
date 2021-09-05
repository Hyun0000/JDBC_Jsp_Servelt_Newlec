package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program_04_pstmt_delete {
	public static void main(String[] args) {
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hykim01";
		String pw = "1234";
		int result = 0;
		
		int id = 28;
		
		try {
			Class.forName(dr);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "delete from notice where id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			// 위의 쿼리문(sql)을 세팅해 보자
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}