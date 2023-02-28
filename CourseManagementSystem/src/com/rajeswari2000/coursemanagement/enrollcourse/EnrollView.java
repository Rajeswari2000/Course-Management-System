package com.rajeswari2000.coursemanagement.enrollcourse;
import com.rajeswari2000.coursemanagement.login.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.rajeswari2000.coursemanagement.dto.Course;
import com.rajeswari2000.coursemanagement.login.*;

public class EnrollView implements EnrollViewCallBack{

	
	private Scanner scanner = new Scanner(System.in);
	LoginView loginView ;
	private EnrollControllerCallBack enrollController;
	public EnrollView(LoginView loginView) {
		this.enrollController = new EnrollController(this);
		this.loginView = loginView;
	}
	
	
	public void fetchCourseList(String userName) {
		enrollController.fetchCourses(userName);
		
	}


	
	public void showCourse(List<Course> courses, String userName) {
		System.out.println("\nList of available courses: \n");
		for(int i=0;i<courses.size();i++) {
		    System.out.println(courses.get(i).getCourseId()+"  ==> "+courses.get(i).getName());
		}
		
		System.out.println("\nEnter the course id to enroll\n");
		String userOption = scanner.next();
		
		enrollController.checkOption(userOption,courses,userName);
		
	}
	
	public void showCourseDescription(String userOption, String userName, List<Course> courses) {
		String fee="";
		for(int i=0;i<courses.size();i++) {
			if(courses.get(i).getCourseId().equals(userOption)) {
				System.out.println("\nCourse Id"+"          "+"Course name"+"         "+"Start Date"+"         "+"End Date"+"        "+"Start time"+"      "+"End Time"+"      "+"Teacher"+"      "+"Course Fee");
			    System.out.println(courses.get(i).getCourseId()+"             "+courses.get(i).getName()+"      "+courses.get(i).getStartDate()+"         "+courses.get(i).getEndDate()+"      "+courses.get(i).getStartTime()+"          "+courses.get(i).getEndTime()+"        "+courses.get(i).getTeacher()+"        "+courses.get(i).getCourseFee());
			    fee = String.valueOf(courses.get(i).getCourseFee());
			}
		}
		
		
		System.out.println("\nEnter 1 to proceed for payment");
		System.out.println("Enter 2 to go back to view course list\n");
		
		
		String option=scanner.next();
		if(option.equals("1"))payment(userOption,userName,courses,fee);
		else if(option.equals("2"))showCourse(courses,userName);
		
	}
	
	public void payment(String userOption, String userName, List<Course> courses,String fee) {
		System.out.println("\nEnter the course fee to confirm payment("+fee+")");
		String fees = scanner.next();
		if(fees.equals(fee)) enrollController.enrollInCourse(userOption,userName,courses);
		else {
			System.out.println("\nInvalid data\n");
			payment(userOption,userName,courses,fee);
		}
	}


	public void enrollmentSuccessful(String userOption, String userName, List<Course> courses) {
		System.out.println("\n------------- > Enrollment successful < -------------\n");
		
		next(courses,userName);
	
	}
	
	public void next(List<Course> courses,String userName) {
	
		System.out.println("\nEnter 1 to view list of courses");
		System.out.println("Enter 2 to go back\n");
		
		String userOpt = scanner.next();
		if(userOpt.equals("1"))showCourse(courses,userName);
		else if(userOpt.equals("2")) loginView.nextStep(userName);
			
	}


	public void userAlreadyExist(String userName, List<Course> courses) {
		System.out.println("\nEnrollment failure");
		System.out.println("You have already enrolled in this course\n");
		next(courses,userName);
		
		
	}

	
	
	
	
	
}
