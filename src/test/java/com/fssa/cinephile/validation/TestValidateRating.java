package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

 class TestValidateRating {
	
	 @Test
	    void testValidRating() {
	        try {
	            assertTrue(RatingValidation.validateRating(5));
	            System.out.println("rating is valid");
	        } catch (ValidationException e) {
	            System.out.println(e.getMessage());
	            fail();
	        }
	    }

	    @Test
	    void testInvalidRating() {
	    	ValidationException result = assertThrows(ValidationException.class, () -> RatingValidation.validateRating(10));
	           assertEquals("The rating is: Invalid", result.getMessage());
	    }

}
