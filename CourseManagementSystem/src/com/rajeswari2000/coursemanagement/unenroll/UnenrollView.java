package com.rajeswari2000.coursemanagement.unenroll;

import java.util.Scanner;


public class UnenrollView implements UnenrollViewCallBack{

	
	private Scanner scanner = new Scanner(System.in);
	private UnenrollControllerCallBack unenrollController;
	public UnenrollView() {
		this.unenrollController = new UnenrollController(this);
	}
	
}
