package com.aia.firstspring.domain;

import java.util.Date;

public class GuestMessage2 {
	
	private int id;
	private String message;
	private Date regDate;

	public GuestMessage2() {
	}

	public GuestMessage2(int id, String message, Date regDate) {
		this.id = id;
		this.message = message;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	

}