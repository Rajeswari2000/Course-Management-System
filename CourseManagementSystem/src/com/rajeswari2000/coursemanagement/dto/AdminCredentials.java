package com.rajeswari2000.coursemanagement.dto;

public class AdminCredentials extends Admin {

	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminCredentials(String userName,String password) {
		super(userName);
		this.password = password;
		
	}

	
	
	
	
}
