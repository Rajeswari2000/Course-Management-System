package com.rajeswari2000.coursemanagement.admin;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface AdminViewCallBack {

	void invalidData();

	void fetchCourseList(String option);

	void showCourse(List<Course> courses, String option);

	void additionSuccessFull();

	void additionFailure();

	void removalSuccess();

	void removalFailure();

	void goBack();

	void addCourse();

	void removeCourse();

}
