package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

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
		User user1 = new User(email, "Kanna@3108", "Jonh snow", "Kanna", 1234567890);
		try {
			userService.registerUser(user1);
		} catch (ServiceException e) { 
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
		User user = new User(email, "Kanna@3108");
		try {
			assertTrue(userService.logInUser(user));
		} catch (ServiceException e) {
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
	@Order(5)
	  @Test
	    void testUpdateUserSuccess() {
	        UserService userService = new UserService();

	        User user = new User(1234567890,3,"John", "Doe");
	        try {
	            assertTrue(userService.updateUser(user));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	@Order(6)
	    @Test
	    void testUpdateUserNullDetails() {
	        UserService userService = new UserService();
	        ServiceException exception = assertThrows(ServiceException.class, () -> userService.updateUser(null));
	        assertEquals("An error occurred while attempting to update user", exception.getMessage());
	    }
	@Order(7)
	 @Test
	    void testDeleteUserSuccess() {
	        UserService userService = new UserService();
	        int userId = 1;

	        try {
	            boolean isDelete = userService.deleteUser(userId);
	            assertTrue(isDelete);
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	@Order(8)
	    @Test
	    void testDeleteUserNullDetails() {
	        UserService userService = new UserService();
	        ServiceException exception = assertThrows(ServiceException.class, () -> userService.deleteUser(0));
	        assertEquals("An error occurred while attempting to delete the user", exception.getMessage());
	    }

}
