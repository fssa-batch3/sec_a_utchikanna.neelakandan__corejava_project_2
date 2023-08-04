package cinephile.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import cinephile.model.User;
import cinephile.services.exceptions.ServiceException;

public class TestRegisterFeature {

	public static void main(String[] args) {

		User user1 = new User("na@gmail.com", "Kanna@123", "kanna", "utchi", 1234567890);
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "Kanna@123", "kanna", "utchi", 1234567890);
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("na@gmail.com", "kanna@123", "kanna", "utchi", 1234567890);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) { 
			e.printStackTrace();

		}
	}
 
	@Test
	public void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
