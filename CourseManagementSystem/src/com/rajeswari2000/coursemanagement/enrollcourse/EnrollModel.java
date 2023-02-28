package com.rajeswari2000.coursemanagement.enrollcourse;
import com.rajeswari2000.coursemanagement.dto.*;
import com.rajeswari2000.coursemanagement.repository.CourseRepository;

import java.util.List;

public class EnrollModel implements EnrollModelCallBack{
	
	
	private EnrollModelControllerCallBack enrollController;
	public EnrollModel(EnrollModelControllerCallBack enrollController) {
		this.enrollController = enrollController;
	}
	
	public List<Course> fetchCourse() {
		
		return CourseRepository.getInstance().fetchCourseList();
		
	}

	
	public boolean enrollInCourse(String userOption, String userName, List<Course> courses) {
		return CourseRepository.getInstance().enrollInCourse(userOption,userName,courses);
		
	}
	
	

}
