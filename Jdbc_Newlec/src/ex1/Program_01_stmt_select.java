package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program_01_stmt_select {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hykim01";
		String pw = "1234";
		
		String sql = "select * from notice where hit >= 10";
		
		Class.forName(dr);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writer_id = rs.getString("writer_id");
			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			
				System.out.printf("id : %d, title : %s, writer_id : %s, content : %s, regDate : %s, hit : %d \n"
						, id, title, writer_id, content, regdate, hit);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}