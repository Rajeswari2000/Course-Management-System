package com.rajeswari2000.coursemanagement.login;

public interface LoginControllerCallBack {

	void decideOption(String option);

	void adminLogin(String userName, String password);

	void teacherLogin(String userName, String password);

	void studentLogin(String userName, String password);

	void signUpStudent(String studentName, String userName, String password, String phoneNumber, String emailId);

}
