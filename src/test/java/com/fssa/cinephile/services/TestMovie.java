package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.MovieService;
import com.fssa.cinephile.services.exceptions.ServiceException;
 class TestMovie {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo", id,3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		MovieService movieService = new MovieService();

		try {
			movieService.createMovie(movie);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	 void testAddMovieSuccess() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo", id, 3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		   fail();
		}
	}
	
	@Test
    void testAddMovieFail() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo", id, -3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 void testInvalidMovieTitle() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("L",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}

	
	
	@Test
	 void testInvalidMovieRating() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, -5 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	@Test
	 void testInvalidMovieImageUrl() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	 void testUpdateMovie() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("jailer",id, 5, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.updateMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
		}
	}
	
	@Test
	 void testInvalidUpdateMovie() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
    void testReadMovie() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.readMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		fail();
		}
	}
	
	@Test
	 void testInvalidReadMovie() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.readMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
     void testDeleteMovie() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("jailer",id, 4, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.deleteMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
		}
	}
	
	@Test
	 void testDeleteMovieFail() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("jailer",id, 4, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.deleteMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 
		}
	}
	
	

}
