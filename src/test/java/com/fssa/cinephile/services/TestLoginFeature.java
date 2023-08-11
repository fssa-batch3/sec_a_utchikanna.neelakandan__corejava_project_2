package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.UserService;
import com.fssa.cinephile.services.exceptions.ServiceException;

 class TestLoginFeature {

	public static void main(String[] args) {
		User user1 = new User("kanna@gmail.com", "kanna123@K");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);

		} catch (ServiceException e) {
			e.printStackTrace();
       
		}

	}

	@Test
	 void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("kanna@gmail.com", "kanna123@K");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			System.out.println("testLoginSuccess");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
    void testLoginFail() {
		UserService userService = new UserService();
		User user1 = new User("kanna.com", "kanna");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testEmailPasswordNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
     void testInvalidPassword() {
		UserService userService = new UserService();
		User user1 = new User("kanna@gmail.com", "kanna123@");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	 void testInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("kannagmail.com", "kanna123@K");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
