package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.MovieDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.MovieValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * This class provides services related to movie management, such as adding,
 * reading, updating, and deleting books.
 *
 * @author UtchikannaNeelakandan
 */

public class MovieService {

	/**
	 * Add a new movie.
	 *
	 * @param movie The movie object to be added.
	 * @return A success message if the movie is added successfully, or an error
	 *         message if not.
	 * @throws ServiceException If there's a problem with the service.
	 */
	public boolean createMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try {
			if (movie == null) {
				throw new ServiceException("An error occurred while attempting to create movie");
			}
			MovieValidation.validateMovie(movie);
			if (movieDAO.addMovie(movie)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * Get a list of all movies.
	 *
	 * @return A list of movie objects.
	 * @throws ServiceException If there's a problem with the service.
	 */

	public boolean readMovie(Movie movie) throws ServiceException {

		MovieDAO movieDAO = new MovieDAO();
		try {
			if (movie == null) {
				throw new ServiceException("An error occurred while attempting to raed movie");
			}
			MovieValidation.validateMovie(movie);
			return movieDAO.readMovie(movie);

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of all movies from the database.
	 * 
	 * @param movie
	 *
	 * @return A list of Movie objects representing all the movies in the database.
	 * @throws ServiceException If there is an issue while attempting to retrieve
	 *                          the movies. This exception encapsulates any
	 *                          underlying {@link DAOException}.
	 */
	public List<Movie> listAllMovies() throws ServiceException {
		try {
			MovieDAO movieDAO = new MovieDAO();
			// Retrieve all movies from the database using the MovieDAO
			return movieDAO.getAllMovies();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("An error occurred while attempting to list all movies");
		}
	}

	/**
	 * Update a movie's information.
	 *
	 * @param book The movie object containing updated information.
	 * @return The updated movie object.
	 * @throws ServiceException If the movie is not found or if there's a problem
	 *                          with the service.
	 */

	public boolean updateMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try {
			if (movie == null) {
				throw new ServiceException("An error occurred while attempting to update movie");
			}
			MovieValidation.validateMovie(movie);
			if (movieDAO.updateMovie(movie)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * Delete a movie by its name (title).
	 *
	 * @param movieName The name (title) of the movie to be deleted.
	 * @return True if the movie is deleted successfully, false otherwise.
	 * @throws ServiceException If the movie is not found or if there's a problem
	 *                          with the service.
	 */

	public boolean deleteMovie(Movie movie) throws ServiceException {
		try {
			if (movie == null) {
				throw new ServiceException("An error occurred while attempting to delete movie");
			}
			MovieValidation.validateMovie(movie);
			if (MovieDAO.deleteMovie(movie)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}

	}

}
