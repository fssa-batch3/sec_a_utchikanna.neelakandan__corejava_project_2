package cinephile.services;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cinephile.model.User;
import cinephile.services.exceptions.ServiceException;

public class TestLoginFeature {

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
	public void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("kanna@gmail.com", "kanna123@K");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testEmailPasswordNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInvalidPassword() {
		UserService userService = new UserService();
		User user1 = new User("kanna@gmail.com", "kanna123@");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("kannagmail.com", "kanna123@K");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}




