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
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.createMovie(null));
        assertEquals("Movie cannot be null", exception.getMessage());
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
    void testUpdateMovieFail() {
		MovieService movieService = new MovieService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.updateMovie(null));
        assertEquals("Movie cannot be null", exception.getMessage());
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
    void testReadMovieFail() {
		MovieService movieService = new MovieService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.readMovie(null));
        assertEquals("Movie cannot be null", exception.getMessage());
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
        ServiceException exception = assertThrows(ServiceException.class, () -> movieService.deleteMovie(null));
        assertEquals("Movie cannot be null", exception.getMessage());
	}
	
	

}
