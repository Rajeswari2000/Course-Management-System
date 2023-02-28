package com.rajeswari2000.coursemanagement.login;
import com.rajeswari2000.coursemanagement.dto.*;
import java.util.*;
public interface LoginModelCallBack {

	boolean verifyAdmin(String userName, String password);

	boolean verifyTeacher(String userName, String password);

	boolean verifyStudent(String userName, String password);

	List<Course> signUpStudent(String studentName, String userName, String password, String phoneNumber, String emailId);

}
