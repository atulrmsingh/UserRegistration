package com.usermanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
	Scanner sc = new Scanner(System.in);
	public Boolean checkPattern(String value,String field){
		Boolean result = null;
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		Pattern namePattern = Pattern.compile("[A-Z][a-z]*");
		Pattern mobilePattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$");
		if (field.equalsIgnoreCase("email")) {
			Matcher emailMatch = emailPattern.matcher(value);
			if (emailMatch.matches()) {
				result = true;
			} else {
				result = false;
			}
		}else if (field.equalsIgnoreCase("name")) {
			Matcher nameMatch = namePattern.matcher(value);
			if (nameMatch.matches()) {
				result = true;
			} else {
				result = false;
			}
		}else if (field.equalsIgnoreCase("mobile")) {
			Matcher mobileMatch = mobilePattern.matcher(value);
			if (mobileMatch.matches()) {
				result = true;
			} else {
				result = false;
			}
		}else if (field.equalsIgnoreCase("password")) {
			Matcher passwordMatch = passwordPattern.matcher(value);
			if (passwordMatch.matches()) {
				result = true;
			} else {
				result = false;
			}
		}else{
			result = false;
		}
		return result;
	}
	
	public void addUsers(){
		System.out.println("Enter First name : ");
		String fname = sc.next();
		if(checkPattern(fname,"name")){
			System.out.println("Enter Last name : ");
			String lname = sc.next();
			if(checkPattern(lname,"name")){
				System.out.println("Enter Email : ");
				String email = sc.next();
				if(checkPattern(email,"email")){
					System.out.println("Enter mobile : ");
					String mobile = sc.next();
					if(checkPattern(mobile,"mobile")){
						System.out.println("Enter password: ");
						String password = sc.next();
						if(checkPattern(password,"password")){
							Users user = new Users();
							user.setFirstName(fname);
							user.setLastName(lname);
							user.setMobile(mobile);
							user.setEmail(email);
							user.setPassword(password);
							System.out.println("User added successfully!!!");
						}else{
							System.out.println("Invalid password !!!");
						}
					}else{
						System.out.println("Invalid mobile number !!!");
					}
				}else{
					System.out.println("Invalid Email !!!");
				}
			}else{
				System.out.println("Invalid Last name !!! First letter should be capital and contain minimum 3 characters");
			}
		}else{
			System.out.println("Invalid First name !!! First letter should be capital and contain minimum 3 characters");
		}
		
	}
}
