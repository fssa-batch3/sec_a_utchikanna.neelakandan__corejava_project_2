package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;

 class TestRatingService {

	
	@Test
	 void testValidRating() {
		RatingService ratingService = new RatingService();
		
       Rating rating = new Rating(4,2,1);
		try {
			assertTrue(ratingService.updateRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
 	      }
	}
	@Test
 void testInvalidRating() {

		RatingService ratingService = new RatingService();
	
        Rating rating = new Rating(10 ,2, 1);
		try {
			assertFalse(ratingService.giveRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	
	@Test
	 void testValidUpdateRating() {
		RatingService ratingService = new RatingService();
      
       Rating rating = new Rating(4,2,1,1);
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
		
      Rating rating = new Rating(4,2,-2);
		try {
			assertFalse(ratingService.updateRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	@Test
	 void testValidReadRating() {
		   int rating_id = 1;

		   Rating rating = new Rating(rating_id);

		   RatingService ratingService = new RatingService();

	        try {
	        	ratingService.getAllRatings(rating);
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	}
		
	@Test
	 void testInvalidReadRating() {
		 RatingService ratingService = new RatingService();
	        ServiceException exception = assertThrows(ServiceException.class, () -> ratingService.getAllRatings(null));
	        assertEquals("Rating update is : Invalid", exception.getMessage());
	}
	
	

}
