package com.fssa.cinephile.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;
 class TestValidateUser {

	
	@Test
    void testValidEmail() throws ValidationException {
        String validEmail = "kanna@gmail.com";
        boolean result = UserValidator.validateEmail(validEmail);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidEmail() {
        String invalidEmail = "";
        Assertions.assertThrows(ValidationException.class, () -> UserValidator.validateEmail(invalidEmail));
    }

   
    @Test
    void testValidPassword() throws ValidationException {
        String validPassword = "kanna@123K";
        boolean result = UserValidator.validatePassword(validPassword);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidPassword() {
        String invalidPassword = "";
        Assertions.assertThrows(ValidationException.class, () -> UserValidator.validatePassword(invalidPassword));
    }
    
    @Test
    void testValidFirstName() throws ValidationException {
        String validFirstName = "kanna";
        boolean result = UserValidator.validateFirstName(validFirstName);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidFirstName() {
        String invalidFirstName = "";
        Assertions.assertThrows(ValidationException.class, () -> UserValidator.validateFirstName(invalidFirstName));
    }
    
    
    @Test
    void testValidLastName() throws ValidationException {
        String validLastName = "kanna";
        boolean result = UserValidator.validateLastName(validLastName);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidLastName() {
        String invalidLastName = "";
        Assertions.assertThrows(ValidationException.class, () -> UserValidator.validateLastName(invalidLastName));
    }
    
    @Test
    void testValidPhoneNo() throws ValidationException {
        int validPhoneNo = 1548824945;
        boolean result = UserValidator.validatePhoneNo(validPhoneNo);
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidPhoneNo() {
        int invalidPhoneNo = -3;
        Assertions.assertThrows(ValidationException.class, () -> UserValidator.validatePhoneNo(invalidPhoneNo));
    }

	

}
