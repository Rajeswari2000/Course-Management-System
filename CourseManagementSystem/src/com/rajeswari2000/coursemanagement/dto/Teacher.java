package com.rajeswari2000.coursemanagement.dto;

import java.util.List;

public class Teacher {

	
	private String userName;
	private String name;
	private String phoneNumber;
	private String emailId;
	private List<Course> listOfCourse;
	
	
	public Teacher(String userName,String name, String phoneNumber, String emailId, List<Course> listOfCourse) {
		super();
		this.userName = userName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.listOfCourse = listOfCourse;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<Course> getListOfCourse() {
		return listOfCourse;
	}
	public void setListOfCourse(List<Course> listOfCourse) {
		this.listOfCourse = listOfCourse;
	}
	
	
	
}
