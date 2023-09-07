package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;

class TestRatingService {

	@Test
	void testValidGiveRating() {
		RatingService ratingService = new RatingService();

		User user = new User();
		user.setUserId(1);
		Movie movie = new Movie();
		movie.setMovieId(10);
		Rating rating = new Rating( 2, movie, user);
		try {
			assertTrue(ratingService.giveRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGiveRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.giveRating(null));
		assertEquals("Rating object cannot be null", exception.getMessage());
	}

	@Test
	void testValidUpdateRating() {
		RatingService ratingService = new RatingService();
		User user = new User();
		user.setUserId(1);
		Movie movie = new Movie();
		movie.setMovieId(10);
		Rating rating = new Rating(3, movie, user);
		try {
			assertTrue(ratingService.updateRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidUpdateRating() {
		RatingService ratingService = new RatingService();
		int rate = 4;
		Movie movie = new Movie();
		movie.setMovieId(345);
		User user = new User();
		user.setUserId(432);
		Rating rating = new Rating(rate,movie,user);
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.updateRating(rating));
		assertEquals("Rating not found", exception.getMessage());
	}

	@Test
	void testValidReadRating() {
		int ratingId = 15;

		Rating rating = new Rating(ratingId);
		RatingService ratingService = new RatingService();

		try {
			ratingService.readRating(rating);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidReadRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.readRating(null));
		assertEquals("Rating object is null", exception.getMessage());
	}

	@Test
	void testValidGetAllRating() {
		int ratingId = 15;

		Rating rating = new Rating(ratingId);

		RatingService ratingService = new RatingService();

		try {
			ratingService.listAllRatings(rating);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGetAllRating() {
		RatingService ratingService = new RatingService();
		ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.listAllRatings(null));
		assertEquals("Rating list is null", exception.getMessage());
	}

}
