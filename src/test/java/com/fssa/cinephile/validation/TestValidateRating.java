package com.fssa.cinephile.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

 class TestValidateRating {
	
	 @Test
	    void testValidRating() throws ValidationException {
	        int validRating = 3;
	        boolean result = RatingValidation.validateRating(validRating);
	        Assertions.assertTrue(result);
	    }

	    @Test
	    void testInvalidRating() {
	        int invalidRating = -1;
	        Assertions.assertThrows(ValidationException.class, () -> RatingValidation.validateRating(invalidRating));
	    }

}
