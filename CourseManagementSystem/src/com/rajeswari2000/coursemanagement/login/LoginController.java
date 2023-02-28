package com.rajeswari2000.coursemanagement.login;

import com.rajeswari2000.coursemanagement.util.Utility;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.*;
public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack{

	private LoginModelCallBack loginModel;
	private LoginViewCallBack loginView;
	public LoginController(LoginViewCallBack loginView ) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}
	@Override
	public void decideOption(String option) {
		switch(option) {
		case("1"):
			loginView.Login("1");
			break;
//		case("2"):
//			loginView.Login("2");
//			break;
		case("2"):
			loginView.Login("2");
			break;
		case("3"):
			loginView.studentSignUp();
			break;
		case("4"):
			System.out.println("***************** Thank you ******************");
		    System.exit(0);
			break;
		default:
			loginView.invalidData();
		}
		
	}

	public void adminLogin(String userName, String password) {
		boolean flag;
		flag = loginModel.verifyAdmin(userName, password);
		if(flag) loginView.adminLoginSuccess();
		else loginView.adminLoginFailure();
		
	}
	
	public void teacherLogin(String userName, String password) {
		boolean flag;
		flag = loginModel.verifyTeacher(userName, password);
		if(flag) loginView.teacherLoginSuccess();
		else loginView.teacherLoginFailure();
		
	}
	
	public void studentLogin(String userName, String password) {
		boolean flag;
		flag = loginModel.verifyStudent(userName, password);
		if(flag) loginView.studentLoginSuccess(userName);
		else loginView.studentLoginFailure();
		
	}
	
	public void signUpStudent(String studentName, String userName, String password, String phoneNumber,
			String emailId) {
		
		
		if(!Utility.validateEmail(emailId)) {
			System.out.println("\nInvalid email id\n");
			System.out.println("Enter your details again\n");
			loginView.studentSignUp();
		}
		if(!Utility.validatePhoneNumber(phoneNumber)) {
			System.out.println("\nInvalid phone number\n");
			System.out.println("Enter your details again\n");
			loginView.studentSignUp();
		}
		
		List<Course> courses = loginModel.signUpStudent(studentName,userName,password,phoneNumber,emailId);
		
		if(courses.isEmpty()) loginView.alreadyExist();
		else loginView.signUpSuccess();
	}
}
