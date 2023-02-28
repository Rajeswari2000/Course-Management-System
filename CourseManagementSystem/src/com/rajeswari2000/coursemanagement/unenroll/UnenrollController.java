package com.rajeswari2000.coursemanagement.unenroll;

public class UnenrollController implements UnenrollControllerCallBack,UnenrollModelControllerCallBack{

	private UnenrollViewCallBack unenrollView;
	private UnenrollModelCallBack unenrollModel;
	public UnenrollController(UnenrollViewCallBack unenrollView) {
		this.unenrollView = unenrollView;
		this.unenrollModel = new UnenrollModel(this);
	}
}
