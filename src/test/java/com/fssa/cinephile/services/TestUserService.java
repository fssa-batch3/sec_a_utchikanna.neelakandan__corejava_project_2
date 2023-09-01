package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;


/**
 * Test class for the UserService methods.
 * 
 *   @author UtchikannaNeelakandan
 */

 class TestUserService {


	@Test
	 void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "Kanna@3108", "Jonh snow", "Kan na", 1234567890);
		try {
			
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			System.out.println("testRegistrationSuccess");
			e.printStackTrace();
			 fail();
		}
	}

	@Test
    void testRegistrationFail() {
		UserService userService = new UserService();
        ServiceException exception = assertThrows(ServiceException.class, () -> userService.registerUser(null));
        assertEquals("Registration credentials must not be null", exception.getMessage());
		
	}

	@Test
	 void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("kumar@gmail.com", "Kanna@3108");
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
        ServiceException exception = assertThrows(ServiceException.class, () -> userService.logInUser(null));
        assertEquals("User details not valid", exception.getMessage());
		
	}

	

}
