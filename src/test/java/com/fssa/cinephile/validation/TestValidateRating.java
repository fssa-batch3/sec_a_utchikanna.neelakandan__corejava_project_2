package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

class TestValidateRating {

	@Test
	void testValidRating() {
		try {
			Rating rating = new Rating();
			rating.setRating(3);
			assertTrue(RatingValidation.validateRating(rating));
			System.out.println("rating is valid");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidRating() {
		Rating rating = new Rating();
		rating.setRating(10000);
		ValidationException result = assertThrows(ValidationException.class,
				() -> RatingValidation.validateRating(rating));
		assertEquals("Invalid rating value. Rating must be between 1 and 5.", result.getMessage());
	}
}
