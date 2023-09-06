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
		int movieId = 3;

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

		Movie movie = new Movie("Leo", 1, 4,
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/75/Leo_%282023_Indian_film%29.jpg/330px-Leo_%282023_Indian_film%29.jpg");
		try {
			movieService.createMovie(movie);
			Movie retrievedMovie = movieService.getMovieById(movie.getMovieId());
			assertNotNull(retrievedMovie);
			assertEquals(movie.getMovieTitle(), retrievedMovie.getMovieTitle());
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
