package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;
 class TestMovieService {

	@Test
	 void testAddMovieSuccess() {
		MovieService movieService = new MovieService();
		
		Movie movie = new Movie("Leo", 3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
	
		Movie movie = new Movie("Leo", -3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 void testInvalidMovieTitle() {

		MovieService movieService = new MovieService();
		
		Movie movie = new Movie("L", 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}

	
	
	@Test
	 void testInvalidMovieRating() {

		MovieService movieService = new MovieService();
	
		Movie movie = new Movie("Leo", -5 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	@Test
	 void testInvalidMovieImageUrl() {

		MovieService movieService = new MovieService();
		
		Movie movie = new Movie("Leo", 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	 void testUpdateMovie() {
		MovieService movieService = new MovieService();

		Movie movie = new Movie("Leo", 3, 2,"https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
	
		Movie movie = new Movie("Leo", 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.createMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
    void testReadMovie() {

		MovieService movieService = new MovieService();
		
		Movie movie = new Movie("Leo", 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
		Movie movie = new Movie("Leo", 3 , "htp://example.com/image.jpg");
		try {
			assertFalse(movieService.readMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
     void testDeleteMovie() {
		MovieService movieService = new MovieService();
		
		Movie movie = new Movie("Leo", 3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
		
		Movie movie = new Movie("jailer", -4, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.deleteMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 
		}
	}
	
	

}
