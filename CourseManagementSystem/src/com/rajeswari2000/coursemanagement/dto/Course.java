package com.rajeswari2000.coursemanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Course {

	
     public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public int getAmountCollected() {
		return amountCollected;
	}
	public void setAmountCollected(int amountCollected) {
		this.amountCollected = amountCollected;
	}

	 public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	 private String courseId;
	 private String name;
     private List<Student> studentList;
     private LocalDate startDate;
     private LocalDate endDate;
     private LocalTime startTime;
     private LocalTime endTime;
     private String teacher;
     private int noOfStudents;
     private int courseFee;
     private int amountCollected;
	 public Course(String courseId,String name, List<Student> studentList, String startDate, String endDate, String startTime,
			String endTime, String teacher, int noOfStudents, int courseFee, int amountCollected) {
		super();
		this.courseId=courseId;
		this.name = name;
		this.studentList = studentList;
		LocalDate dateStart = LocalDate.parse(startDate);
		this.startDate = dateStart;
		LocalDate dateEnd = LocalDate.parse(endDate);
		this.endDate = dateEnd;
		LocalTime timeStart = LocalTime.parse(startTime);
		this.startTime = timeStart;
		LocalTime timeEnd = LocalTime.parse(endTime);
		this.endTime = timeEnd;
		this.teacher = teacher;
		this.noOfStudents = noOfStudents;
		this.courseFee = courseFee;
		this.amountCollected = amountCollected;
	}
     
     
     
     
     
}
