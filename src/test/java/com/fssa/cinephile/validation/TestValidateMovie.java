package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Test class for the MovieValidation methods.
 * 
 * @author UtchikannaNeelakandan
 */

class TestValidateMovie {

	@Test
	void testValidMovieTitle() {
		try {
			MovieValidation movieValidation = new MovieValidation();
			assertTrue(movieValidation.validateMovieTitle("Leo"));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieTitle() {
		MovieValidation movieValidation = new MovieValidation();
		ValidationException result = assertThrows(ValidationException.class,
				() -> movieValidation.validateMovieTitle("e"));
		assertEquals("The movie title is not valid", result.getMessage());
	}
	
	@Test
	void testValidMovieType() {
		try {
			MovieValidation movieValidation = new MovieValidation();
			assertTrue(movieValidation.validateMovieType("Kollywood"));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieType() {
		MovieValidation movieValidation = new MovieValidation();
		ValidationException result = assertThrows(ValidationException.class,
				() -> movieValidation.validateMovieType("e"));
		assertEquals("The movie Type is not valid", result.getMessage());
	}
	

	@Test
	void testValidMovieImageUrl() {
		try {
			MovieValidation movieValidation = new MovieValidation();
			assertTrue(movieValidation
					.validateMovieImageUrl("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
	
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieImageUrl() {
		MovieValidation movieValidation = new MovieValidation();
		ValidationException result = assertThrows(ValidationException.class,
				() -> movieValidation.validateMovieImageUrl("httpspbs.twimg.com/media/FoDdg2WXEAomzQX"));
		assertEquals("Image is not found", result.getMessage());
	}
	
	@Test
	void testValidMovieTrailer() {
		try {
			MovieValidation movieValidation = new MovieValidation();
			assertTrue(movieValidation
					.validateMovieTrailer("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieTrailer() {
		MovieValidation movieValidation = new MovieValidation();
		ValidationException result = assertThrows(ValidationException.class,
				() -> movieValidation.validateMovieTrailer("httpspbs.twimg.com/media/FoDdg2WXEAomzQX"));
		assertEquals("trailer is not found", result.getMessage());
	}
}
