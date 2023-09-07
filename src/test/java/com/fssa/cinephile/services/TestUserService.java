package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;

/**
 * Test class for the UserService methods.
 * 
 * @author UtchikannaNeelakandan
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestUserService {

	private static final String email = "saran"+System.nanoTime()+"@gmail.com";
	@Test
	@Order(1)
	void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User(email, "Kanna@3108", "Jonh snow", "Kan na", 1234567890);
		try {
			assertTrue(userService.registerUser(user1));
			User user = userService.getUserByEmail(email);
			assertEquals(user.getFirstName(), user1.getFirstName());
		} catch (ServiceException e) { 
			System.out.println("testRegistrationSuccess");
			e.printStackTrace();
			fail();
		}
	}

	@Order(2)
	@Test
	void testRegistrationFail() {
		UserService userService = new UserService();
		ServiceException exception = assertThrows(ServiceException.class, () -> userService.registerUser(null));
		assertEquals("Registration credentials must not be null", exception.getMessage());

	}

	@Order(3)
	@Test
	void testLoginSuccess() {
		UserService userService = new UserService();
		System.out.println(email);
		User user = new User(email, "Kanna@3108");
		try {
			assertTrue(userService.logInUser(user));
		} catch (ServiceException e) {
			System.out.println("testLoginSuccess");
			e.printStackTrace();
			fail();
		}
	}
	@Order(4)
	@Test
	void testLoginFail() {
		UserService userService = new UserService();
		ServiceException exception = assertThrows(ServiceException.class, () -> userService.logInUser(null));
		assertEquals("Login credentials are not valid", exception.getMessage());

	}

}
