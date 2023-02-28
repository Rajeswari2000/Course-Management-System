package com.rajeswari2000.coursemanagement.login;
import java.util.*;

import com.rajeswari2000.coursemanagement.dto.*;
import com.rajeswari2000.coursemanagement.repository.CourseRepository;

public class LoginModel implements LoginModelCallBack{
    private LoginModelControllerCallBack loginModelController;
	
	public LoginModel(LoginModelControllerCallBack loginModelController) {
		this.loginModelController = loginModelController;
	}

	
	public boolean verifyAdmin(String userName, String password) {
		return CourseRepository.getInstance().verifyAdminCredentials(userName, password);
		
	}


	public boolean verifyTeacher(String userName, String password) {
		return CourseRepository.getInstance().verifyTeacherCredentials(userName, password);
		
	}

	
	public boolean verifyStudent(String userName, String password) {
		return CourseRepository.getInstance().verifyStudentCredentials(userName, password);
		
	}


	public List<Course> signUpStudent(String studentName, String userName, String password, String phoneNumber,
			String emailId) {
		return CourseRepository.getInstance().studentSignUp(studentName,userName,password,phoneNumber,emailId);
		 
		
	}
	
	
	
}
