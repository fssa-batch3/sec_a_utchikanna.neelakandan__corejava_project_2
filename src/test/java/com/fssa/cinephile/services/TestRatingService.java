package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;

class TestRatingService {

	@Test
	void testValidGiveRating() {
		RatingService ratingService = new RatingService();

	
		Rating rating = new Rating( 2, 1, 1);
		try {
			assertTrue(ratingService.submitRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGiveRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.submitRating(null));
		assertEquals("An error occurred while attempting to add rating", exception.getMessage());
	}

	

	@Test
	void testValidGetMoviesRating() {
		int ratingId = 1;
      int movieId = 2;
		
		RatingService ratingService = new RatingService();

		try {
			ratingService.getRatingByMovieAndUser(ratingId,movieId);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGetMoviesRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.getRatingByMovieAndUser(0,0));
		assertEquals("Rating object is null", exception.getMessage());
	}

	@Test
	void testValidGetAvgRating() {
		int ratingId = 7;

	

		RatingService ratingService = new RatingService();

		try {
			ratingService.getAverageRatingAndCountByMovie(ratingId);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGetAvgRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.getAverageRatingAndCountByMovie(0));
		assertEquals("Rating list is null", exception.getMessage());
	}

}
