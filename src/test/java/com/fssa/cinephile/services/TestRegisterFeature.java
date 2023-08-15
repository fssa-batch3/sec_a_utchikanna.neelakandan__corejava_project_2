package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.UserService;
import com.fssa.cinephile.services.exceptions.ServiceException;

 class TestRegisterFeature {

	public static void main(String[] args) {

		User user1 = new User("naveeeeeeeeeeen@gmail.com", "Kanna@123", "kanna", "utchi", 1234567890);
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}
  
	}

	@Test
	 void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("kumar@gmail.com", "Kanna@3108", "Jonh snow", "Kan na", 1234567890);
		try {
			
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			System.out.println("testRegistrationSuccess");
			e.printStackTrace();
			 fail();
		}
	}
	@Test
	 void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "kanna@123", "kanna", "utchi", 1234567890);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
 
	@Test
	 void testInvalidFirstName() {

		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "kanna@123", "k", "u", 1234567890);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
	
	@Test
	 void testInvalidLastName() {

		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "kanna@123", "k", "u", 1234567890);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
	
	@Test
	 void testInvalidPhoneNo() {

		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "kanna@123", "kanna", "utchi", 12345);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
	@Test
	 void testInvalidEmailId() {

		UserService userService = new UserService();
		User user1 = new User("nagmail.com", "kanna@123", "kanna", "utchi", 1234567890);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
	

}
