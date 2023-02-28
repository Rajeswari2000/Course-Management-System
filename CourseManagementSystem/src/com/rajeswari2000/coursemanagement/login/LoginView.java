package com.rajeswari2000.coursemanagement.login;
import com.rajeswari2000.coursemanagement.enrollcourse.*;
import java.util.List;
import java.util.Scanner;

import com.rajeswari2000.coursemanagement.admin.AdminView;
import com.rajeswari2000.coursemanagement.dto.Course;
import com.rajeswari2000.coursemanagement.enrollcourse.EnrollView;

public class LoginView implements LoginViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private LoginControllerCallBack loginController;
	AdminView adminView = new AdminView(this);
	public LoginView() {
		this.loginController = new LoginController(this);
	}
	EnrollView enrollView = new EnrollView(this);
	
	
	public static void main(String args[]) {
		LoginView loginView = new LoginView();
		loginView.mainMenu();
	}
	
	public void mainMenu() {
		
		System.out.println("\n************** Welcome to online Course Management System ****************\n");
		System.out.println(" ==> Enter 1 for admin login");
//		System.out.println("Enter  for teacher login");
		System.out.println(" ==> Enter 2 for student login");
		System.out.println(" ==> Enter 3 for student sign up");
		System.out.println(" ==> Enter 4 to exit");
		
		String option = scanner.next();
		
		
		loginController.decideOption(option);
		
	}
	

	public void Login(String option) {
		System.out.println("Enter user name: ");  
        String userName = scanner.next();   
        System.out.println("Enter password: ");
        String password = scanner.next();
        
        if(option.equals("1"))loginController.adminLogin(userName,password);
       // else if(option.equals("2"))loginController.teacherLogin(userName,password);
        else if(option.equals("2"))loginController.studentLogin(userName,password);
	}

	

	public void studentSignUp() {
		System.out.println("Enter your name: ");
		String studentName = scanner.next();
		System.out.println("Enter user name: ");
		String userName = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email id: ");
        String emailId = scanner.next();
        
        
        loginController.signUpStudent(studentName,userName,password,phoneNumber,emailId);
        
        
        
	}



	@Override
	public void adminLoginSuccess() {
		System.out.println("\n------------------ > Login successful < ----------------------\n");
		adminView.adminMenu();
	}



	@Override
	public void adminLoginFailure() {
		System.out.println("\nInvalid credentials");
		System.out.println("Enter your details again\n");
		Login("1");
		
	}



	public void teacherLoginSuccess() {
	
		System.out.println("\nLogin successful\n");
	}



	public void teacherLoginFailure() {
		System.out.println("\nInvalid credentials");
		System.out.println("Enter your details again\n");
		Login("2");
		
	}



	public void studentLoginSuccess(String userName) {
		System.out.println("\nLogin successful\n");
		
		
		enrollView.fetchCourseList(userName);
		
	}
	
	public void nextStep(String userName) {
		
		System.out.println("\nEnter 1 to enroll in course ");
		//System.out.println("Enter 2 to unenroll ");
		System.out.println("Enter 3 to go back\n");
		
		String option = scanner.next();
		
		
		
		
	}
	
    public void signUpSuccess() {
    	System.out.println("\nSign up successful");
    	System.out.println("\nPlease login to continue\n");
		Login("2");
    	
		
	}



	public void studentLoginFailure() {
		System.out.println("\nInvalid credentials");
		System.out.println("Enter your details again\n");
		Login("2");
		
	}


	public void alreadyExist() {
	   System.out.println("User name alraedy exist. Please login");
	   Login("2");
	}

	@Override
	public void invalidData() {
		System.out.println("\nInvalid data\n");
		mainMenu();
		
	}




	

}
