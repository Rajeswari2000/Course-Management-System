package com.rajeswari2000.coursemanagement.admin;

import java.util.List;


import com.rajeswari2000.coursemanagement.dto.Course;

public class AdminController implements AdminControllerCallBack,AdminModelControllerCallBack{

	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;
	public AdminController(AdminViewCallBack adminView) {
		this.adminView = adminView;
		this.adminModel = new AdminModel(this);
	}
	@Override
	public void selectOption(String option) {
		switch(option) {
		case("1"):
			adminView.fetchCourseList(option);
			break;
		case("2"):
			adminView.addCourse();
			break;
		case("3"):
			adminView.removeCourse() ;
			break;
//		case("4"):
//			break;
		case("5"):
			adminView.goBack();
			break;
		default:
			adminView.invalidData();
		}
		
	}
	
	public void fetchCourses(String option) {
		List<Course> courses = adminModel.fetchCourse();
		
		
		adminView.showCourse(courses,option);
	}
	
	public void createCourse(String courseId, String courseName, String startDate, String endDate, String startTime,
			String endTime, int courseFee, String teacherUserName, String teacherName, String phoneNumber, String emailId) {
		if(adminModel.createCourse(courseId,courseName,startDate,endDate,startTime,endTime,courseFee,teacherUserName,teacherName,phoneNumber,emailId)) {
			adminView.additionSuccessFull();
		}
		else {
			adminView.additionFailure();
		}
	}
	
	public void courseRemoval(String courseId) {
		if(adminModel.courseRemoval(courseId)) {
			adminView.removalSuccess();
		}
		else {
			adminView.removalFailure();
		}
		
	}

}
