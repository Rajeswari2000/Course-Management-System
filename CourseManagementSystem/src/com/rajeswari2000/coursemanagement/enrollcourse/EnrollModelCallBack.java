package com.rajeswari2000.coursemanagement.enrollcourse;
import com.rajeswari2000.coursemanagement.dto.*;
import java.util.List;

public interface EnrollModelCallBack {

	List<Course> fetchCourse();

	boolean enrollInCourse(String userOption, String userName, List<Course> courses);

}
