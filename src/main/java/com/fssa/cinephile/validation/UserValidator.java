package com.fssa.cinephile.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class UserValidator {

	public static boolean validateUser(User user) throws ValidationException {

		if (validatePassword(user.getPassword())
				&& validateEmail(user.getEmail())
				&& validateFirstName(user.getFirstName())
				&& validateLastName(user.getLastName())
				&& validatePhoneNo(user.getPhoneNo())) {
			return true;
		} else {
			throw new ValidationException("User details not valid");
		}
	}

	
	public static boolean validateFirstName(String firstName) throws ValidationException {
		boolean match = false;
		if (firstName == null)
			return false;

		String regex = "^[A-Za-z'’ -]{1,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(firstName);
		match = m.matches();
		if (match) {
			System.out.println("The first name is valid.");
		} else {
			throw new ValidationException("The first name is not valid");
		}

		return match;
	}
	
	public static boolean validateLastName(String lastName) throws ValidationException {
		boolean match = false;

		if (lastName == null)
			return false;
		String regex = "^[A-Za-z'’ -]{1,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(lastName);
		match = m.matches();
		if (match) {
			System.out.println("The last name is valid.");
		} else {
			throw new ValidationException("The last name is not valid");
		}

		return match;
	}

	public static boolean validatePassword(String password) throws ValidationException {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			throw new ValidationException("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email)throws ValidationException {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new ValidationException("The email address is: Invalid");
		}
		return isMatch;

	}
	
	public static boolean validatePhoneNo(int phoneNo)throws ValidationException {
		boolean isMatch = false;

		if (phoneNo == 0)
			return false;
		String strNumber = String.valueOf(phoneNo);
		String regex = "^\\d{10}$";
		isMatch = Pattern.matches(regex, strNumber);
		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			throw new ValidationException("The phone number is: Invalid");
		}
		return isMatch;

	}
	
	// Checking the loginUser present or not

		public static boolean validateLogIn(User user) throws ValidationException {
			if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
				return true;
			} else {
				throw new ValidationException("User details not valid");

			}
		}

}
