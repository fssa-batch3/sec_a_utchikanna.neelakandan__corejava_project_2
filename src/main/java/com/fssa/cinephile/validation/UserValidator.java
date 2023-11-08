package com.fssa.cinephile.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Utility class for validating User objects and credentials.
 * 
 * @author UtchikannaNeelakandan
 */
public class UserValidator {
	
	public UserValidator(){
		// Default constructor
	}

	/**
	 * Validates a User object.
	 *
	 * @param user The User object to be validated.
	 * @throws ValidationException If the User details are not valid.
	 */
	public void validateUser(User user) throws ValidationException {
		if (validatePassword(user.getPassword()) && validateEmail(user.getEmail())
				&& validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())) {
			validatePhoneNo(user.getPhoneNo());
		}else {
			throw new ValidationException("update failure");
		}
	}
	
	/**
	 * Validates a User object.
	 *
	 * @param user The User object to be validated.
	 * @throws ValidationException If the User details are not valid.
	 */
	public void validateUpdateUser(User user) throws ValidationException {
		if (validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())) {
			validatePhoneNo(user.getPhoneNo());
		}else {
			throw new ValidationException("update failure");
		}
	}

	/**
	 * Validates a first name.
	 *
	 * @param firstName The first name to be validated.
	 * @return True if the first name is valid, false otherwise.
	 * @throws ValidationException If the first name is not valid.
	 */
	public boolean validateFirstName(String firstName) throws ValidationException {
		boolean match = false;
		if (firstName == null)
			throw new ValidationException("Name cannot be empty");

		String regex = "^[A-Za-z'’ -]{1,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(firstName);
		match = m.matches();
		if (!match) {
			throw new ValidationException("The first name is not valid");
		} 

		return match;
	}

	/**
	 * Validates a last name.
	 *
	 * @param lastName The last name to be validated.
	 * @return True if the last name is valid, false otherwise.
	 * @throws ValidationException If the last name is not valid.
	 */
	public boolean validateLastName(String lastName) throws ValidationException {
		boolean match = false;

		if (lastName == null)
			return false;
		String regex = "^[A-Za-z'’ -]{1,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(lastName);
		match = m.matches();
		if (!match) {
			throw new ValidationException("The last name is not valid");
		}

		return match;
	}
	

	/**
	 * Validates a password.
	 *
	 * @param password The password to be validated.
	 * @return True if the password is valid, false otherwise.
	 * @throws ValidationException If the password is not valid.
	 */
	public boolean validatePassword(String password) throws ValidationException {
		boolean match = false;

		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);

		if (!match) {
			throw new ValidationException(
					"The provided password is invalid. Password should contain at least one uppercase letter, one lowercase letter, one symbol, one number, and have a minimum length of 8 characters.");
		}

		return match;
	}

	/**
	 * Validates an email address.
	 *
	 * @param email The email address to be validated.
	 * @return True if the email address is valid, false otherwise.
	 * @throws ValidationException If the email address is not valid.
	 */
	public boolean validateEmail(String email) throws ValidationException {
		boolean isMatch = false;
		
		if (email == null) {
			throw new ValidationException("Email cannot be empty");			
		}

		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		isMatch = Pattern.compile(regex).matcher(email).matches();
		if (!isMatch) {
			throw new ValidationException(
					"Bad credentials");
		}
		return isMatch;
	}
	

	/**
	 * Validates a phone number.
	 *
	 * @param phoneNo The phone number to be validated.
	 * @return True if the phone number is valid, false otherwise.
	 * @throws ValidationException If the phone number is not valid.
	 */
	public boolean validatePhoneNo(long phoneNo) throws ValidationException {
		boolean isMatch = false;

		if (phoneNo == 0)
			return false;
		String strNumber = String.valueOf(phoneNo);
		String regex = "^\\d{10}$";
		isMatch = Pattern.matches(regex, strNumber);
		if (!isMatch) {
			throw new ValidationException(
					"The provided phone number is invalid. A valid phone number should consist of 10 digits.");
		}
		return isMatch;
	}

	/**
	 * Validates a User object for login.
	 *
	 * @param user The User object representing login credentials.
	 * @return True if the User object is valid for login, false otherwise.
	 * @throws ValidationException If the User object is not valid for login.
	 */
	public boolean validateLogIn(User user) throws ValidationException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true; 
		} else {
			throw new ValidationException("Login credentials are not valid");
		}
	}
}
