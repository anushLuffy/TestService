package com.company.testService.utils;

import java.util.regex.*;
import javax.validation.Valid;

import com.company.testService.model.User;

public class Util {

	public static String validations(User user ) {
		if(user.getEmailId() == null || user.getEmailId().isEmpty()) {
			return "Email is a mandatory  !! please try again ";
		}
		else if(user.getPassword() == null || user.getPassword().isEmpty()) {
			return  "Password is a mandatory  !! please try again ";
		}else if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
			return  "Name is a mandatory  !! please try again ";
		}
		else if ( user.getMobileNumber() == null || user.getMobileNumber().isEmpty()) {
			return  "Mobile is a mandatory  !! please try again ";
		}
		else if(!emailValidation(user.getEmailId())) {
			return  "Email is not valid  !! please try again ";
		}
		else if(!mobileNumberValidation(user.getMobileNumber())) {
			return  "Mobile is not valid  !! please try again ";
		}
		return null;
	}

	public static String loginValidations(@Valid User user) {
		if(user.getEmailId() == null || user.getEmailId().isEmpty()) {
			return "Email is a mandatory  !! please try again ";
		}
		else if(user.getPassword() == null || user.getPassword().isEmpty()) {
			return  "Password is a mandatory  !! please try again ";
		}
		else if(!emailValidation(user.getEmailId())) {
			return  "Email is not valid  !! please try again ";
		}
		return null;
	}
	
	public static boolean  mobileNumberValidation(String mobileNumber) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(mobileNumber); 
        return (m.find() && m.group().equals(mobileNumber));
	}
	
	public static boolean  emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
		return false; 
		return pat.matcher(email).matches(); 
	}

}
