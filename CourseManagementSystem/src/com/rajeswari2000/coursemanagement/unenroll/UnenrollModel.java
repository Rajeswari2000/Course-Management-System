package com.rajeswari2000.coursemanagement.unenroll;

public class UnenrollModel implements UnenrollModelCallBack{
	
	
	private UnenrollModelControllerCallBack unenrollController;
	public UnenrollModel(UnenrollModelControllerCallBack unenrollController) {
		this.unenrollController = unenrollController;
	}

}
