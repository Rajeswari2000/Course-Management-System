package com.rajeswari2000.coursemanagement.login;

import java.util.List;

import com.rajeswari2000.coursemanagement.dto.Course;

public interface LoginViewCallBack {

	

	void studentSignUp();

	void adminLoginSuccess();

	void adminLoginFailure();

	void teacherLoginSuccess();

	void teacherLoginFailure();

	void studentLoginSuccess(String userName);

	void studentLoginFailure();

	void Login(String string);

	void alreadyExist();

	void signUpSuccess();

	void mainMenu();

	void invalidData();

}
