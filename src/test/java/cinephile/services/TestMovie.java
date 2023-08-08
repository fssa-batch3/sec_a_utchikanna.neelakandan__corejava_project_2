package cinephile.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.print.Book;
import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import cinephile.DAO.exceptions.DAOException;
import cinephile.model.Movie;
import cinephile.DAO.MovieDAO;
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
	public void testInvalidMovieId() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int)currentTimestamp;
        int id =Math.abs(absoluteX);
        
		Movie movie = new Movie("Leo",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
		Movie movie = new Movie("Leo",id, 5 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
	
    
	

}
