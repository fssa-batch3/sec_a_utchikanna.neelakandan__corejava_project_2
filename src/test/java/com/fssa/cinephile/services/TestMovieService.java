 package com.fssa.cinephile.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;


/**
 * Test class for the MovieService methods.
 * 
 *   @author UtchikannaNeelakandan
 */
 class TestMovieService {

	@Test
	 void testAddMovieSuccess() {
		MovieService movieService = new MovieService();
		
		Movie movie = new Movie(3, "Leo", "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.createMovie(null));
        assertEquals("An error occurred while attempting to create movie", exception.getMessage());
	}
	
	
	@Test
	 void testUpdateMovieSuccess() {
		MovieService movieService = new MovieService();

		Movie movie = new Movie("Leo", 11, 2,"https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.updateMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			 fail();
		}
	}
	
	@Test
    void testUpdateMovieFail() {
		MovieService movieService = new MovieService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.updateMovie(null));
        assertEquals("An error occurred while attempting to update movie", exception.getMessage());
	}
	
	
	@Test
    void testReadMovieSuccess() {

		MovieService movieService = new MovieService();
		
		Movie movie = new Movie(3, "Leo" , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.readMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		fail();
		}
	}
	
	@Test
    void testReadMovieFail() {
		MovieService movieService = new MovieService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.readMovie(null));
        assertEquals("An error occurred while attempting to raed movie", exception.getMessage());
	}
	
	@Test
    void testGetAllMovieSuccess() {

		MovieService movieService = new MovieService();
		
		try {
			movieService.listAllMovies();
		} catch (ServiceException e) {
			e.printStackTrace();
		fail();
		}
	}
	
//	@Test
//    void testGetAllMovieFail() {
//		MovieService movieService = new MovieService();
//        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.listAllMovies());
//        assertEquals("An error occurred while attempting to list all movies", exception.getMessage());
//	}
	 
	@Test
     void testDeleteMovieSuccess() {
		MovieService movieService = new MovieService();
		
		Movie movie = new Movie(3, "Leo", "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
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
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.deleteMovie(null));
        assertEquals("An error occurred while attempting to delete movie", exception.getMessage());
	}
	
	

}
