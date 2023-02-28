package com.rajeswari2000.coursemanagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	
  public static boolean validateEmail(String emailId) {
	  Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][c][o][m]");
      Matcher m = p.matcher(emailId);
      if(m.find()) return true;
      else return false;
	  
  }
  
  public static boolean validatePhoneNumber(String phoneNumber) {
	  Pattern p = Pattern.compile("[7-9][0-9]{9}");
      Matcher m = p.matcher(phoneNumber);
      if(m.matches()) return true;
      else return false;
  }
	
}
