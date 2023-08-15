package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

 class TestValidateMovie {

	 @Test
	    void testValidMovieTitle() {
	        try {
	            assertTrue(MovieValidation.validateMovieTitle("Leo"));
	            System.out.println("movie title is valid");
	        } catch (ValidationException e) {
	            System.out.println(e.getMessage());
	            fail();
	        }
	    }

	    @Test
	    void testInvalidMovieTitle() {
	    	ValidationException result = assertThrows(ValidationException.class, () -> MovieValidation.validateMovieTitle("e"));
	           assertEquals("The movie title is not valid", result.getMessage());
	    }
	    
	    @Test
	    void testValidMovieImageUrl() {
	        try {
	            assertTrue(MovieValidation.validateMovieImageUrl("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
	            System.out.println("movie image is valid");
	        } catch (ValidationException e) {
	            System.out.println(e.getMessage());
	            fail();
	        }
	    }

	    @Test
	    void testInvalidMovieImageUrl() {
	    	ValidationException result = assertThrows(ValidationException.class, () -> MovieValidation.validateMovieImageUrl("httpspbs.twimg.com/media/FoDdg2WXEAomzQX"));
	           assertEquals("image is not found", result.getMessage());
	    }
	    
	    @Test
	    void testValidMovieRating() {
	        try {
	            assertTrue(MovieValidation.validateMovieRating(1));
	            System.out.println("rating is valid");
	        } catch (ValidationException e) {
	            System.out.println(e.getMessage());
	            fail();
	        }
	    }

	    @Test
	    void testInvalidMovieRating() {
	    	ValidationException result = assertThrows(ValidationException.class, () -> MovieValidation.validateMovieRating(10));
	           assertEquals("The movie rating is: Invalid", result.getMessage());
	    }
}
