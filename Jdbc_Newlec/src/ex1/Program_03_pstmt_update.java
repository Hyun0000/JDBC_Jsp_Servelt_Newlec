package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program_03_pstmt_update {
	public static void main(String[] args) {
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hykim01";
		String pw = "1234";
		int result = 0;
		
		String title = "GITHub란 무엇인가?";
		String writer_id = "RedVelvet";
		String content = "kkk";
		String files = "";
		int id = 28;
		
		try {
			Class.forName(dr);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "update notice set title = ?, writer_id = ?, content = ?, files = ? where id = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 위의 쿼리문(sql)을 세팅해 보자
			pstmt.setString(1, title);
			pstmt.setString(2, writer_id);
			pstmt.setString(3, content);
			pstmt.setString(4, files);
			pstmt.setInt(5, id);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}