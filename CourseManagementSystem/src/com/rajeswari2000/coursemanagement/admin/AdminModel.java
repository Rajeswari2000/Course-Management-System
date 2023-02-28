package com.rajeswari2000.coursemanagement.admin;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;
import com.rajeswari2000.coursemanagement.repository.CourseRepository;

public class AdminModel implements AdminModelCallBack{
	
	
	private AdminModelControllerCallBack adminController;
	public AdminModel(AdminModelControllerCallBack adminController) {
		this.adminController = adminController;
	}

	
     public List<Course> fetchCourse() {
 		
		return CourseRepository.getInstance().fetchCourseList();
		
	}

	public boolean createCourse(String courseId, String courseName, String startDate, String endDate, String startTime,
			String endTime,int courseFee, String teacherUserName, String teacherName, String phoneNumber, String emailId) {
		if(CourseRepository.getInstance().addCourse(courseId,courseName,startDate,endDate,startTime,endTime,courseFee,teacherUserName,teacherName,phoneNumber,emailId));
		return true;
	}


	public boolean courseRemoval(String courseId) {
		return CourseRepository.getInstance().removeCourse(courseId);
		
	}

}
