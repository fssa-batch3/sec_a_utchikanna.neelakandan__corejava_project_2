package cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestValidateUser {

	@Test
	public void testValidPassword() {

		assertTrue(UserValidator.validatePassword("Password@123"));

	}

	@Test
	public void testInvalidPasswordWithoutSpecialCharacters() {
		assertFalse(UserValidator.validatePassword("Password123"));

	}

	@Test
	public void testInvalidPasswordWithoutNumbers1() {
		assertFalse(UserValidator.validatePassword("Password@"));

	}

	@Test
	public void testInvalidPasswordWithoutNumbers() {
		assertFalse(UserValidator.validatePassword("Password@"));

	}
	

}
