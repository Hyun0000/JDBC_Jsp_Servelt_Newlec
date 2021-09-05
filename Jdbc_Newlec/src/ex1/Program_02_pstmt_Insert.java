package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program_02_pstmt_Insert {
	public static void main(String[] args) {
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hykim01";
		String pw = "1234";
		int result = 0;
		
		String title = "GIT란 무엇인가?";
		String writer_id = "RV";
		String content = "jjj";
		String files = "";
		
		try {
			Class.forName(dr);
			Connection connection = DriverManager.getConnection(url, user, pw);
			
			String sql = "insert into notice (title, writer_id, content, files) values (?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// 위의 쿼리문(sql)을 세팅해 보자
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, writer_id);
			preparedStatement.setString(3, content);
			preparedStatement.setString(4, files);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}