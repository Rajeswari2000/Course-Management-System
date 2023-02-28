package com.rajeswari2000.coursemanagement.dto;

import java.util.List;

public class Student {

	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String name;
	private String phoneNumber;
	private String emailId;
	private List<Course> courseList;
	
	
	
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
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public Student(String userName,String name, String phoneNumber, String emailId, List<Course> courseList) {
		super();
		this.userName = userName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.courseList = courseList;
	}
	
	public String toString() {
		return "userName: " + userName + "\n name: " + name + "\n phoneNumber: " + phoneNumber + "\n emailId: "
				+ emailId + "\n courseList: " + courseList;
	}
    
	
}
