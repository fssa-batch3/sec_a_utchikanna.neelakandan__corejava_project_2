package cinephile.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cinephile.model.User;
import cinephile.validation.exceptions.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {

		if (validatePassword(user.getPassword())
				&& validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	
	public static boolean validateFirstName(String firstName) {
		boolean match = false;

		if (firstName == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(firstName);
		match = m.matches();
		if (match) {
			System.out.println("The first name is valid.");
		} else {
			System.out.println("The first name is not valid");
		}

		return match;
	}
	
	public static boolean validateLastName(String lastName) {
		boolean match = false;

		if (lastName == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(lastName);
		match = m.matches();
		if (match) {
			System.out.println("The last name is valid.");
		} else {
			System.out.println("The last name is not valid");
		}

		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}
	
	public static boolean validatePhoneNo(int phoneNo) {
		boolean isMatch = false;

		if (phoneNo == 0)
			return false;
		String strNumber = String.valueOf(phoneNo);
		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		isMatch = Pattern.matches(regex, strNumber);
		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			System.out.println("The phone number is: Invalid");
		}
		return isMatch;

	}
	
	// Checking the loginUser present or not

		public static boolean validateLogIn(User user) throws InvalidUserException {
			if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
				return true;
			} else {
				throw new InvalidUserException("User details not valid");

			}
		}

}