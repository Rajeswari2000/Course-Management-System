package com.rajeswari2000.coursemanagement.admin;

import com.rajeswari2000.coursemanagement.login.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.rajeswari2000.coursemanagement.dto.Course;
import com.rajeswari2000.coursemanagement.dto.Student;

public class AdminView implements AdminViewCallBack {

	LoginView loginView;
	private Scanner scanner = new Scanner(System.in);
	private AdminControllerCallBack adminController;

	public AdminView(LoginView loginView) {
		this.loginView = loginView;
		this.adminController = new AdminController(this);
	}

	public void adminMenu() {
		System.out.println("\nEnter 1 to view list of courses");
		System.out.println("Enter 2 to add a course");
		System.out.println("Enter 3 to remove a course");
		//System.out.println("Enter 4 to change teacher for a course");
		System.out.println("Enter 5 to go back");

		String option = scanner.next();
		adminController.selectOption(option);
	}

	public void fetchCourseList(String option) {
		adminController.fetchCourses(option);

	}

	public void showCourse(List<Course> courses, String option) {
		System.out.println("\nList of courses: \n");
		System.out.println("Course Id " + "       " + "  Name");
		for (int i = 0; i < courses.size(); i++) {

			System.out.println("    "+courses.get(i).getCourseId() + "              " + courses.get(i).getName());
		}

		if (option.equals("1"))
			next(option, courses);

	}

	public void next(String option, List<Course> courses) {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Enter 1 to view course details ");
		System.out.println("Enter 2 to go back");

		String courseOption = scanner.next();
		if (courseOption.equals("1"))
			showCourseDescription(option, courses);
		else if (courseOption.equals("2"))
			adminMenu();
		else {
			System.out.println("Invalid data");
			next(option, courses);
		}

	}

	public void addCourse() {
		System.out.println("Enter course id: ");
		String courseId = scanner.next();
		System.out.println("Enter course name");
		String courseName = scanner.next();
		System.out.println("Start date(yyyy-mm-dd)");
		String startDate = scanner.next();
		System.out.println("End date(yyyy-mm-dd)");
		String endDate = scanner.next();
		System.out.println("Start Time(00:00)");
		String startTime = scanner.next();
		System.out.println("End Time(00:00)");
		String endTime = scanner.next();
		System.out.println("Enter course fee");
		int courseFee = scanner.nextInt();
		System.out.println("Enter teacher user name: ");
		String teacherUserName = scanner.next();
		System.out.println("Enter teacher name: ");
		String teacherName = scanner.next();
		System.out.println("Enter phone number ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email id: ");
		String emailId = scanner.next();

		adminController.createCourse(courseId, courseName, startDate, endDate, startTime, endTime, courseFee,
				teacherUserName, teacherName, phoneNumber, emailId);

	}

	public void removeCourse() {
		System.out.println("Enter course id to remove course");
		String courseId = scanner.next();

		adminController.courseRemoval(courseId);
	}

	public void showCourseDescription(String option, List<Course> courses) {
		System.out.println("\n-------------------------------------------\n");
		System.out.printf("%-15s%-25s%-25s%-25s%-25s%n", "Course Id", "Name", "Start Date", "End Date", "Start time",
				"End Time", "Teacher", "Course Fee");
		for (int i = 0; i < courses.size(); i++) {
			System.out.printf("%-15s%-25s%-25s%-25s%-25s%n", courses.get(i).getCourseId(), courses.get(i).getName(),
					courses.get(i).getStartDate(), courses.get(i).getEndDate(), courses.get(i).getStartTime(),
					courses.get(i).getEndTime(), courses.get(i).getTeacher(), courses.get(i).getCourseFee());
		}
		System.out.println("\n-------------------------------------------\n");
		courseDescriptionNext(option, courses);
	}

	public void courseDescriptionNext(String option, List<Course> courses) {

		System.out.println("\nEnter 2 to add a course");
		System.out.println("Enter 3 to delete a course");
		System.out.println("Enter 4 to go back\n");
		String addDeleteOption = scanner.next();
		if (addDeleteOption.equals("2"))
			addCourse();
		else if (addDeleteOption.equals("3"))
			removeCourse();
		else if (addDeleteOption.equals("4"))
			adminMenu();
		else {
			System.out.println("Invalid data");
			courseDescriptionNext(option, courses);
		}
	}

	public void invalidData() {
		System.out.println("\nInvalid data\n");
		adminMenu();

	}

	public void additionSuccessFull() {
		System.out.println("\n------------------- > Course succesfully added < ----------------------\n");
		adminMenu();

	}

	public void additionFailure() {
		System.out.println("\nCourse addition failure\n");
		adminMenu();
	}

	public void removalSuccess() {
		System.out.println("\n--------------------- > Course removal success < -------------------------\n");
		adminMenu();
	}

	public void removalFailure() {
		System.out.println("\nCourse removal failure\n");
		adminMenu();
	}

	public void goBack() {
		loginView.mainMenu();

	}
}
