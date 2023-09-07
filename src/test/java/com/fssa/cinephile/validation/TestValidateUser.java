package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Test class for the UserValidator methods.
 * 
 * @author UtchikannaNeelakandan
 */
class TestValidateUser {
	UserValidator userValidator = new UserValidator();

	@Test
	void testValidUserFirstname() {
		assertDoesNotThrow(()->userValidator.validateFirstName("Kanna"));
	}

	@Test
	void testInvalidFirstName() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateFirstName("3kanna"));
		assertEquals("The first name is not valid", result.getMessage());
	}

	@Test
	void testValidUserLastname() {
		assertDoesNotThrow(()->userValidator.validateLastName("Utchi"));
	}

	@Test
	void testInvalidLastName() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateLastName("utchi7"));
		assertEquals("The last name is not valid", result.getMessage());
	}

	@Test
	void testValidUserEmail() {
		assertDoesNotThrow(()->userValidator.validateEmail("utchi@gmail.com"));
	}

	@Test
	void testInvalidEmail() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateEmail("utchi.com"));
		assertEquals("The provided email Invalid. A valid email should look like this: Kanna@gmail.com",
				result.getMessage());
	}

	@Test
	void testValidUserPhoneNo() {
		assertDoesNotThrow(()-> userValidator.validatePhoneNo(1234567890));
	}

	@Test
	void testInvalidPhoneNo() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validatePhoneNo(1223));
		assertEquals("The provided phone number is invalid. A valid phone number should consist of 10 digits.",
				result.getMessage());
	}

	@Test
	void testValidUserPassword() {
		assertDoesNotThrow(()->userValidator.validatePassword("Kanna@3108"));
	}

	@Test
	void testInvalidPassword() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validatePassword("kanna"));
		assertEquals(
				"The provided password is invalid. Password should contain at least one uppercase letter, one lowercase letter, one symbol, one number, and have a minimum length of 8 characters.",
				result.getMessage());
	}

}
