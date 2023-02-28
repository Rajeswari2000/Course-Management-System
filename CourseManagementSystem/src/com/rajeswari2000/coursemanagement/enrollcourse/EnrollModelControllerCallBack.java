package com.rajeswari2000.coursemanagement.enrollcourse;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface EnrollModelControllerCallBack {

	void checkOption(String userOption, List<Course> courses, String userName);

}
