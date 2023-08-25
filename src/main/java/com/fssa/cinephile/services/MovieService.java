package com.fssa.cinephile.services;

import com.fssa.cinephile.DAO.MovieDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.MovieValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * This class provides services related to movie management, such as adding, reading, updating, and deleting books.
 *
 * @author UtchikannaNeelakandan
 */

public class MovieService {
	
	
	/**
	 * Add a new movie.
	 *
	 * @param movie The movie object to be added.
	 * @return A success message if the movie is added successfully, or an error message if not.
	 * @throws ServiceException If there's a problem with the service.
	 */
	public boolean createMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			if(movie == null) {
				throw new ServiceException("Movie cannot be null");
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
	        	if(movie == null) {
					throw new ServiceException("Movie cannot be null");
				}
	        	MovieValidation.validateMovie(movie);
	            return movieDAO.readMovie(movie);

	        } catch (DAOException | ValidationException e) {
	            throw new ServiceException(e);
	        }
	    }
	 
	 /**
		 * Update a movie's information.
		 *
		 * @param book The movie object containing updated information.
		 * @return The updated movie object.
		 * @throws ServiceException If the movie is not found or if there's a problem with the service.
		 */
	    
	public boolean updateMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			if(movie == null) {
				throw new ServiceException("Movie cannot be null");
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
	 * @throws ServiceException If the movie is not found or if there's a problem with the service.
	 */
	
	public boolean deleteMovie(Movie movie) throws ServiceException {
		try { 
			if(movie == null) {
				throw new ServiceException("Movie cannot be null");
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
