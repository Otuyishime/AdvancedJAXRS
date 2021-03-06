package org.olixtech.messenger.model;

import java.util.Date;

public class Comment {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getCreated() {
		return created;
	}
	public String getAuthor() {
		return author;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Comment() {
		super();
	}
	
	public Comment(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
}
