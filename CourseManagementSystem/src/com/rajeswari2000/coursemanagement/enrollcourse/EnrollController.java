package com.rajeswari2000.coursemanagement.enrollcourse;
import java.util.*;
import com.rajeswari2000.coursemanagement.dto.*;
public class EnrollController implements EnrollControllerCallBack,EnrollModelControllerCallBack{
     
	private EnrollViewCallBack enrollView;
	private EnrollModelCallBack enrollModel;
	public EnrollController(EnrollViewCallBack enrollView) {
		this.enrollView = enrollView;
		this.enrollModel = new EnrollModel(this);
	}
	
	
	
	public void fetchCourses(String userName) {
		List<Course> courses = enrollModel.fetchCourse();
		
		
		enrollView.showCourse(courses,userName);
	}



	
	public void checkOption(String userOption,List<Course> courses, String userName) {
		for(Course course:courses ) {
			if(course.getCourseId().equals(userOption)) {
				enrollView.showCourseDescription(userOption,userName,courses);
				return;
			}
			
		}
		System.out.println("\nInvalid option. Choose the correct option\n");
		enrollView.showCourse(courses, userName);
	
	}


	public void enrollInCourse(String userOption, String userName, List<Course> courses) {
		boolean flag = enrollModel.enrollInCourse(userOption,userName,courses);
		
		if(flag)enrollView.enrollmentSuccessful(userOption,userName,courses);
		else enrollView.userAlreadyExist(userName,courses);
		
		
		
	}
}
