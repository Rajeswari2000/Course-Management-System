package com.rajeswari2000.coursemanagement.repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import com.rajeswari2000.coursemanagement.dto.*;


public class CourseRepository {
	
	private CourseRepository() {
		
	}
	

	List<Credentials> credentials = new ArrayList<>();
	
	private static CourseRepository courseRepository;
	public static CourseRepository getInstance() {
		
		if(courseRepository==null) {
			courseRepository = new CourseRepository();
			courseRepository.credentialSetUp();
			courseRepository.courseInitialSetUp();
			courseRepository.studentInitialSetUp();
			courseRepository.teacherInitialSetUp();
		}
		
		
		return courseRepository;
	}
	
	/* ------------------------  Required data  --------------------------- */

	List<Student> studentList = new ArrayList<>();
	List<Course> courseList = new ArrayList<>();
	List <Teacher> teacherList = new ArrayList<>();

	
	/* ------------------------  Credentials setup  --------------------------- */

	public void credentialSetUp() {
		credentials.add(new Credentials("1","secure","Teacher"));
		credentials.add(new Credentials("2","pamban","Student"));
		credentials.add(new Credentials("3","kural","Teacher"));
		credentials.add(new Credentials("4","raji","Student"));
		
	}
	
	/* ------------------------  get course by course id  --------------------------- */
	
	
	public Course getCourseByCourseId(String courseId) {
		
		for (Course course: courseList) {
			if (course.getCourseId().equals(courseId)) {
				return course;
			}
		}
		return null;
	}
	
	
	/* ------------------------  get student by user name  --------------------------- */
	
	public Student getStudentByUserName(String userName) {
		
		for(Student student: studentList) {
			if(student.getUserName().equalsIgnoreCase(userName)) {
				return student;
			}
		}
		return null;
	}
	
	 
    /* ------------------------  Student initial setUp  --------------------------- */
    
	
    public void studentInitialSetUp() {

       
    	studentList.add(new Student("lotus","Thamarai Priya","7200014745","thamarai@gmail.com", new ArrayList<>(Arrays.asList(getCourseByCourseId("1"),getCourseByCourseId("2")))));
    	studentList.add(new Student("chiral","Udhayan","9677140335","udhi@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("1"),getCourseByCourseId("2")))));
    	studentList.add(new Student("BDS","Sutharshan","9176066784","sutharshanappu@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("1"),getCourseByCourseId("2")))));
    	credentials.add(new Credentials("lotus","lotus","Student"));
    	credentials.add(new Credentials("chiral","chiral","Student"));
    	credentials.add(new Credentials("BDS","BDS","Student"));
  
    }
    
   /* ------------------------  Course initial setUp  --------------------------- */
    
   
    public void courseInitialSetUp() {
    	
    	courseList.add(new Course("1","Quantum Mechanics",new ArrayList<>(),
    			"2023-04-02","2023-05-03","10:30","11:30","Yogesh",3,1000,3000));
    	courseList.add(new Course("2","Communication Skills",new ArrayList<>(),
    			"2023-04-05","2023-05-04","03:00","05:00","Senthil",2,2000,4000));
    	courseList.add(new Course("3","High Energy Physics",new ArrayList<>(),
    			"2023-04-05","2023-05-10","02:00","03:00","Dr.Senthil",2,1000,2000));
    	courseList.add(new Course("4","Core Java",new ArrayList<>(),
    			"2023-04-10","2023-05-20","08:00","09:00","Murugan",0,2000,0));
    	courseList.add(new Course("5","Tamil illakiyam",new ArrayList<>(),
    			"2023-04-20","2023-05-30","05:30","06:30","Kabil",0,5000,0));
 
    }
    
   /* ------------------------  Teacher initial setUp  --------------------------- */
    
    public void teacherInitialSetUp() {
    	
    	teacherList.add(new Teacher("natesan","Yogesh","9080627245","yogesh@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("1")))));
    	teacherList.add(new Teacher ("selvan","Senthil","9078563412","senthil@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("1"),getCourseByCourseId("3")))));
    	teacherList.add(new Teacher ("statmech","Murugan","9182736450","murugan@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("4")))));
    	teacherList.add(new Teacher ("tamil","Kabilamathavan","9182736456","kabil@gmail.com",new ArrayList<>(Arrays.asList(getCourseByCourseId("5")))));
    	credentials.add(new Credentials("natesan","natesan","Teacher"));
    	credentials.add(new Credentials("statmech","statmech","Teacher"));
    	credentials.add(new Credentials("tamil","tamil","Teacher"));
    	
    }
	
	
	/* ------------------------  Admin Credentials verifying  --------------------------- */

	
	public boolean verifyAdminCredentials(String userName, String password) {
		
		    
			if(userName.equals("admin") && password.equals("admin")) {
				return true;
			}
	        return false;
		
	}
	
	/* ------------------------  Teacher Credentials verifying  --------------------------- */
	
    public boolean verifyTeacherCredentials(String userName, String password) {
    	for(Credentials cred : credentials) {
			if(cred.getUserName().equals(userName) && cred.getPassword().equals(password) && cred.getType().equals("Teacher")) {
				return true;
			}
		}
		return false;
		
		
	}
	
    /* ------------------------  Student Credentials verifying  --------------------------- */
     
    public boolean verifyStudentCredentials(String userName, String password) {
  		
    	for(Credentials cred : credentials) {
			if(cred.getUserName().equals(userName) && cred.getPassword().equals(password) && cred.getType().equals("Student")) {
				return true;
			}
		}
		return false;
		
	}
    
    
    /* ------------------------  Student sign up check  --------------------------- */ 
    
    public List<Course> studentSignUp(String studentName, String userName, String password, String phoneNumber,
			String emailId) {
    	
    	for(Credentials cred : credentials) {
			if(!cred.getUserName().equals(userName)) {
				credentials.add(new Credentials(userName,password,"Student"));
				studentList.add(new Student(userName,studentName,phoneNumber,emailId,new ArrayList<>()));
				return courseList;
			}
		}
		return null; 	
    }
    
    /* ------------------------ fetch course list --------------------------- */ 
   
    public List<Course> fetchCourseList(){
    	return courseList;
    }

    
    /* ------------------------ enroll student in course --------------------------- */
    
	public boolean enrollInCourse(String userOption, String userName, List<Course> courses) {
		
		for(Course course: courses) {
			if(course.getCourseId().equals(userOption) /* && !getStudentByUserName(userName).getUserName().equals(userName)*/) {
				course.getStudentList().add(getStudentByUserName(userName));
				course.setNoOfStudents(course.getNoOfStudents()+1);
				course.setAmountCollected(course.getAmountCollected()+course.getCourseFee());
				return true;
			}
		}
		
		return false;
		
	}

	 /* ------------------------ add course --------------------------- */
    
	public boolean addCourse(String courseId, String courseName, String startDate, String endDate, String startTime,
			String endTime,int courseFee, String teacherUserName, String teacherName, String phoneNumber, String emailId) {
		
		courseList.add(new Course(courseId,courseName,new ArrayList<>(), startDate,endDate,startTime,endTime,teacherName,0,courseFee,0));
		addTeacher(teacherUserName,teacherName,phoneNumber,emailId,courseId);
		
		return true;
	}
	
    /* ------------------------ remove course --------------------------- */
	
	public boolean removeCourse(String courseId) {
		Course course = getCourseByCourseId(courseId);
		String teacher = course.getTeacher();
		for(Teacher t: teacherList) {
			if(t.getName().equals(teacher)) {
				t.getListOfCourse().remove(course);
			}
		}
		courseList.remove(course);
		return true;
	}
	
	 /* ------------------------ add teacher --------------------------- */
    
    public boolean addTeacher(String teacherUserName, String teacherName, String phoneNumber, String emailId,String courseId) {
    	teacherList.add(new Teacher(teacherUserName,teacherName,phoneNumber,emailId,new ArrayList<>(Arrays.asList(getCourseByCourseId(courseId)))));
    	return true;
    }
}

	












