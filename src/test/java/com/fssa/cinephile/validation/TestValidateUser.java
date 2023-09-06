package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Test class for the UserValidator methods.
 * 
 * @author UtchikannaNeelakandan
 */
class TestValidateUser {

	@Test
	void testValidUserFirstname() {
		try {
			assertTrue(UserValidator.validateFirstName("Kanna"));
			System.out.println("firstname is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidFirstName() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> UserValidator.validateFirstName("3kanna"));
		assertEquals("The first name is not valid", result.getMessage());
	}

	@Test
	void testValidUserLastname() {
		try {
			assertTrue(UserValidator.validateLastName("Utchi"));
			System.out.println("lastname is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidLastName() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> UserValidator.validateLastName("utchi7"));
		assertEquals("The last name is not valid", result.getMessage());
	}

	@Test
	void testValidUserEmail() {
		try {
			assertTrue(UserValidator.validateEmail("utchi@gmail.com"));
			System.out.println("email is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidEmail() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> UserValidator.validateEmail("utchi.com"));
		assertEquals("The provided email Invalid. A valid email should look like this: Kanna@gmail.com",
				result.getMessage());
	}

	@Test
	void testValidUserPhoneNo() {
		try {
			assertTrue(UserValidator.validatePhoneNo(1234567890));
			System.out.println("phone no is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidPhoneNo() {
		ValidationException result = assertThrows(ValidationException.class, () -> UserValidator.validatePhoneNo(1223));
		assertEquals("The provided phone number is invalid. A valid phone number should consist of 10 digits.",
				result.getMessage());
	}

	@Test
	void testValidUserPassword() {
		try {
			assertTrue(UserValidator.validatePassword("Kanna@3108"));
			System.out.println("password is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidPassword() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> UserValidator.validatePassword("kanna"));
		assertEquals(
				"The provided password is invalid. Password should contain at least one uppercase letter, one lowercase letter, one symbol, one number, and have a minimum length of 8 characters.",
				result.getMessage());
	}

}
