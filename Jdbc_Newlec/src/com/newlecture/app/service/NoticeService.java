package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String dr = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hykim01";
	private String pw = "1234";
	
	public List<Notice> getList(int page, String searchField, String searchWord) throws SQLException, ClassNotFoundException {
		List<Notice> list = new ArrayList<Notice>();
		
		int start = 1 + (page - 1)*10;
		// 1, 11, 21, 31...
		// 등차 수열 공식을 이용했다.
				
		int end = 10 * page;
		// 10, 20, 30, 40....
		
		String sql = "select * from notice_view where " + searchField + " like ? and rown between ? and ?";
		
			Class.forName(dr);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String title = rs.getString("title");
				String writer_id = rs.getString("writer_id");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Date regdate = rs.getDate("regdate");
				int id = rs.getInt("id");
				int hit = rs.getInt("hit");
				
				Notice notice = new Notice(title, writer_id, content, files, regdate, id, hit);
				
				list.add(notice);
			}
			
			rs.close(); pstmt.close(); conn.close();
			
		return list;
	}
//======================================================================================
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writer_id = notice.getWriter_id();
		String content = notice.getContent();
		String files = notice.getFiles();
		
			Class.forName(dr);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "insert into notice (title, writer_id, content, files) values (?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 위의 쿼리문(sql)을 세팅해 보자
			pstmt.setString(1, title);
			pstmt.setString(2, writer_id);
			pstmt.setString(3, content);
			pstmt.setString(4, files);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		return result;
	}
//======================================================================================
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writer_id = notice.getWriter_id();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
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
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		
		return result;
	}
//======================================================================================
	public int delete(int id) throws ClassNotFoundException, SQLException  {
		
			Class.forName(dr);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "delete from notice where id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			// 위의 쿼리문(sql)을 세팅해 보자
			int result = pstmt.executeUpdate();
		
			pstmt.close();
			conn.close();
			
		return result;
	}
//======================================================================================
	public int getCount() throws ClassNotFoundException, SQLException {
		Class.forName(dr);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		
		String sql = "select count(*) from notice";
		
		ResultSet rsCount = stmt.executeQuery(sql);
		
		int count = 0;
		
		if (rsCount.next()) {
			count = rsCount.getInt(1);
		}
		
		rsCount.close(); stmt.close(); conn.close();
		
		return count;
	}
}