package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

public class TestValidationCasts {
	
	private CastsValidation castsValidation = new CastsValidation();

	@Test
	void testValidActorName() {
		try {
			
			assertTrue(castsValidation.validateActorName("Vijay"));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidActorName() {

		ValidationException result = assertThrows(ValidationException.class,
				() -> castsValidation.validateActorName("V"));
		assertEquals("The actor name is not valid", result.getMessage());
	}
	

	@Test
	void testValidActorImageUrl() {
		try {
			assertTrue(castsValidation.validateActorImage("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
	
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidActorImageUrl() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> castsValidation.validateActorImage("httpspbs.twimg.com/media/FoDdg2WXEAomzQX"));
		assertEquals("actor image is not found", result.getMessage());
	}
	

	@Test
	void testValidMovieImageUrl() {
		try {
			assertTrue(castsValidation.validateActorLink("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
	
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieImageUrl() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> castsValidation.validateActorLink("httpspbs.twimg.com/media/FoDdg2WXEAomzQX"));
		assertEquals("actor link is not found", result.getMessage());
	}
}
