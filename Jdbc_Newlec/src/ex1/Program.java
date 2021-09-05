package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hykim01";
		String pw = "1234";
		
		String sql = "select * from notice";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			String title = rs.getString("TITLE");
			System.out.println(title);
		} else {
			System.out.println("뭔가 잘못 됐군요");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
}
