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
		user.setUserId(8);
		Movie movie = new Movie();
		movie.setMovieId(3);
       Rating rating = new Rating(4,2,movie,user);
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
        assertEquals("Rating is cannot be null", exception.getMessage());
	}
	
	
	@Test
	 void testValidUpdateRating() {
		RatingService ratingService = new RatingService();
		User user = new User();
		user.setUserId(10);
		Movie movie = new Movie();
		movie.setMovieId(5);
       Rating rating = new Rating(4,2,movie,user);
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
        ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.updateRating(null));
        assertEquals("Rating update is cannot be null", exception.getMessage());
	}
	
	
	
	@Test
	 void testValidReadRating() {
		   int rating_id = 1;

		   Rating rating = new Rating(rating_id);

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
        assertEquals("Rating update is : Invalid", exception.getMessage());
	}
	
	
	@Test
	 void testValidGetAllRating() {
		   int rating_id = 1;

		   Rating rating = new Rating(rating_id);

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
       assertEquals("Rating update is : Invalid", exception.getMessage());
	}
	
	

}
