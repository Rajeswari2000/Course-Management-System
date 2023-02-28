package com.rajeswari2000.coursemanagement.enrollcourse;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface EnrollControllerCallBack {

	void fetchCourses(String userName);

	void checkOption(String userOption,List<Course> courses, String userName);

	void enrollInCourse(String userOption, String userName, List<Course> courses);

}
