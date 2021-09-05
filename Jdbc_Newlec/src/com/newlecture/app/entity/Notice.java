package com.newlecture.app.entity;

import java.sql.Date;

public class Notice {
	private String title;
	private String writer_id;
	private String content;
	private String files;
	private Date regdate;
	private int id;
	private int hit;
	
	public Notice() {
		
	}
	
	public Notice(String title, String writer_id, String content, String files, Date regdate, int id, int hit) {
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.files = files;
		this.regdate = regdate;
		this.id = id;
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
}
