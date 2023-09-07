package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;

/**
 * Test class for the MovieService methods.
 * 
 * @author UtchikannaNeelakandan
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
	void testAddMovieNullDetails() {
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.createMovie(null));
		assertEquals("An error occurred while attempting to create movie", exception.getMessage());
	}

	@Test
	void testUpdateMovieSuccess() {
		MovieService movieService = new MovieService();

		Movie movie = new Movie("Leo", 1, 2, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.updateMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testUpdateMovieNullDetails() {
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.updateMovie(null));
		assertEquals("An error occurred while attempting to update movie", exception.getMessage());
	}
	@Test
	void testUpdateMovieInvalidDetails() {
		Movie movie = new Movie();
		movie.setMovieImgUrl(null);
		movie.setMovieRating(0);
		movie.setMovieTitle(null);
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.updateMovie(movie));
		assertEquals("The movie title cannot be empty", exception.getMessage());
	}

	@Test
	void testReadMovieSuccess() {

		MovieService movieService = new MovieService();

		Movie movie = new Movie(3, "Leo", "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.readMovie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testReadMovieNullDetails() {
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.readMovie(null));
		assertEquals("An error occurred while attempting to raed movie", exception.getMessage());
	}
	
	@Test
	void testReadMovieInvalidDetails() {
		Movie movie = new Movie();
		movie.setMovieImgUrl(null);
		movie.setMovieRating(0);
		movie.setMovieTitle(null);
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.readMovie(movie));
		assertEquals("The movie title cannot be empty", exception.getMessage());
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

	@Test
	void testDeleteMovieSuccess() {
		MovieService movieService = new MovieService();
		int movieId = 1;

		try {
			boolean isDelete = movieService.deleteMovie(movieId);
			assertTrue(isDelete);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testDeleteMovieNullDetails() {
		MovieService movieService = new MovieService();
		ServiceException exception = assertThrows(ServiceException.class, () -> movieService.deleteMovie(0));
		assertEquals("An error occurred while attempting to delete movie", exception.getMessage());
	}

	@Test

	void testValidGetMovieById() {
		MovieService movieService = new MovieService();

		try {
			Movie retrievedMovie = movieService.getMovieById(2);
			assertNotNull(retrievedMovie);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test

	void testInvalidGetMovieById() {
		MovieService movieService = new MovieService();
		int invalidMovieId = 4321;
		ServiceException exception = assertThrows(ServiceException.class,
				() -> movieService.getMovieById(invalidMovieId));
		assertEquals("Movie not found", exception.getMessage());
	}

}
