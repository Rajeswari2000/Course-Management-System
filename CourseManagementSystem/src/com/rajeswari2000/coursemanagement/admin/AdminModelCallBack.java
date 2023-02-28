package com.rajeswari2000.coursemanagement.admin;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface AdminModelCallBack {

	List<Course> fetchCourse();

	boolean createCourse(String courseId, String courseName, String startDate, String endDate, String startTime,
			String endTime, int courseFee, String teacherUserName, String teacherName, String phoneNumber, String emailId);

	boolean courseRemoval(String courseId);

}
