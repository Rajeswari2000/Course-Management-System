package com.rajeswari2000.coursemanagement.enrollcourse;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface EnrollViewCallBack {

	void showCourse(List<Course> courses, String userName);

	void showCourseDescription(String userOption, String userName, List<Course> courses);

	void enrollmentSuccessful(String userOption, String userName, List<Course> courses);

	void userAlreadyExist(String userName, List<Course> courses);

	

}
