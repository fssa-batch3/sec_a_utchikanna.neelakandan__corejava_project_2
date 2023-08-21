package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
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
		Rating rating = new Rating( id,10,2, 3);
		RatingService ratingService = new RatingService();

		try {
			ratingService.giveRating(rating);

		} catch (Exception e) {
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
       Rating rating = new Rating(id,10,1,4);
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
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
        Rating rating = new Rating( id,10 ,2, -1);
		try {
			assertFalse(ratingService.giveRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	
	@Test
	 void testUpdateRating() {
		RatingService ratingService = new RatingService();
		LocalDateTime currentDateTime = LocalDateTime.now();
       Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
       long currentTimestamp = instant.toEpochMilli();
       int absoluteX = (int)currentTimestamp;
       int id =Math.abs(absoluteX);
       Rating rating = new Rating(id,10,2,2);
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
		LocalDateTime currentDateTime = LocalDateTime.now();
      Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
      long currentTimestamp = instant.toEpochMilli();
      int absoluteX = (int)currentTimestamp;
      int id =Math.abs(absoluteX);
      Rating rating = new Rating(id,4,2,-2);
		try {
			assertFalse(ratingService.updateRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	@Test
	 void testReadRating() {
		RatingService ratingService = new RatingService();
		LocalDateTime currentDateTime = LocalDateTime.now();
      Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
      long currentTimestamp = instant.toEpochMilli();
      int absoluteX = (int)currentTimestamp;
      int id =Math.abs(absoluteX);
      Rating rating = new Rating(id,10,2,2);
		try {
			assertTrue(ratingService.readRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
		}
	}
	
	@Test
	 void testInvalidReadRating() {
		RatingService ratingService = new RatingService();
		LocalDateTime currentDateTime = LocalDateTime.now();
     Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
     long currentTimestamp = instant.toEpochMilli();
     int absoluteX = (int)currentTimestamp;
     int id =Math.abs(absoluteX);
     Rating rating = new Rating(id,4,2,-2);
		try {
			assertFalse(ratingService.readRating(rating));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}
	
	

}
