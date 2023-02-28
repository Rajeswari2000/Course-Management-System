package com.rajeswari2000.coursemanagement.admin;

public interface AdminControllerCallBack {

	void selectOption(String option);

	void fetchCourses(String option);

	void createCourse(String courseId, String courseName, String startDate, String endDate, String startTime,
			String endTime, int courseFee, String teacherUserName, String teacherName, String phoneNumber, String emailId);

	void courseRemoval(String courseId);

}
