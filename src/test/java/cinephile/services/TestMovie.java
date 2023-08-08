package cinephile.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import cinephile.model.Movie;
import cinephile.model.User;
import cinephile.services.exceptions.ServiceException;

public class TestMovie {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo", id,3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		MovieService movieService = new MovieService();

		try {
			movieService.Movie(movie);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	public void testAddMovieSuccess() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo", id, 3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		   fail();
		}
	}
	
	@Test
	public void testInvalidMovieTitle() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("L",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}

	
	
	@Test
	public void testInvalidMovieRating() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, -5 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	@Test
	public void testInvalidMovieImageUrl() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	public void testUpdateMovie() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("jailer",id, 4, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.updateMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
		}
	}
	
	@Test
	public void testDeleteMovie() {
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
	public void testInvalidUpdateMovie() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
		Movie movie = new Movie("Leo",id, 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	

}
