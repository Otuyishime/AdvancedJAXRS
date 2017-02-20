package org.olixtech.messenger.resources.filterbeans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @QueryParam("year") int year; 
	private @QueryParam("offset") int offset; 
	private @QueryParam("size") int size;
	
	public int getYear() {
		return year;
	}
	public int getOffset() {
		return offset;
	}
	public int getSize() {
		return size;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
