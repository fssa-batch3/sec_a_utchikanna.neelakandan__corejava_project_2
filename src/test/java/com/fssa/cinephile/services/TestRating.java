package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.RatingService;
import com.fssa.cinephile.services.exceptions.ServiceException;

 class TestRating {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Rating rating = new Rating( id,1 ,654321, 678901);
		RatingService ratingService = new RatingService();

		try {
			ratingService.Rating(rating);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
 void testInvalidRating() {

		RatingService ratingService = new RatingService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
        Rating rating = new Rating( id,-1 ,654321231, 678901231);
		try {
			assertFalse(ratingService.Rating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	 void testRatingUpdate() {
		RatingService ratingService = new RatingService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX); 
        Rating rating = new Rating(id,65432132,67890123,4);
		try {
			assertTrue(ratingService.updateRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
  	}
	}

}
