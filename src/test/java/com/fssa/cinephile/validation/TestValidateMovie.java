package com.fssa.cinephile.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

 class TestValidateMovie {

	 @Test
	    void testValidMovieTitle() throws ValidationException {
	        String validTitle = "Sample Title";
	        boolean result = MovieValidation.validateMovieTitle(validTitle);
	        Assertions.assertTrue(result);
	    }

	    @Test
	    void testInvalidMovieTitle() {
	        String invalidTitle = "";
	        Assertions.assertThrows(ValidationException.class, () -> MovieValidation.validateMovieTitle(invalidTitle));
	    }
	    
	    @Test
	    void testValidateMovieImageUrl() throws ValidationException {
	        String validImageUrl = "https://example.com";
	        boolean result = MovieValidation.validateMovieImageUrl(validImageUrl);
	        Assertions.assertTrue(result);
	    }

	    @Test
	    void testInvalidMovieImageUrl() {
	        String invalidImageUrl = "";
	        Assertions.assertThrows(ValidationException.class, () -> MovieValidation.validateMovieImageUrl(invalidImageUrl));
	    }
	    
	    @Test
	    void testValidMovieRating() throws ValidationException {
	        int validRating = 3;
	        boolean result = MovieValidation.validateMovieRating(validRating);
	        Assertions.assertTrue(result);
	    }

	    @Test
	    void testInvalidMovieRating() {
	        int invalidRating = 10;
	        Assertions.assertThrows(ValidationException.class, () -> MovieValidation.validateMovieRating(invalidRating));
	    }

}
