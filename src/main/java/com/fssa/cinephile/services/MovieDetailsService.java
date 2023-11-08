package com.fssa.cinephile.services;

import com.fssa.cinephile.dao.MovieDetailsDAO;
import com.fssa.cinephile.dao.exception.DAOException;
import com.fssa.cinephile.model.MovieDetails;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.MovieDetailsValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * This class provides services related to movie details management, such as adding,
 * reading, updating, and deleting movie details.
 *
 *@author UtchikannaNeelakanda
 *
 */
public class MovieDetailsService {
    /**
     * Add new movie details.
     *
     * @param movieDetails The MovieDetails object to be added.
     * @return True if the operation was successful, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     * @throws ValidationException 
     */
    public boolean createMovieDetails(MovieDetails movieDetails) throws ServiceException, ValidationException {
        MovieDetailsDAO movieDetailsDAO = new MovieDetailsDAO();
        try {
            if (movieDetails == null) {
                throw new ServiceException("An error occurred while attempting to create movie details");
            }
        	MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
        	movieDetailsValidation.validateMovieDetails(movieDetails);
            movieDetailsDAO.addMovieDetails(movieDetails);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    /**
     * Retrieves movie details by its ID.
     *
     * @param movieDetailsId The ID of the movie details to retrieve.
     * @return The MovieDetails object if found, or null if not.
     * @throws ServiceException If there's a problem with the service.
     */
    public MovieDetails getMovieDetailsById(int movieDetailsId) throws ServiceException {
        try {
            MovieDetailsDAO movieDetailsDAO = new MovieDetailsDAO();
            MovieDetails movieDetails = movieDetailsDAO.getAllMovieDetailsWithMovies(movieDetailsId);
            if (movieDetails == null) {
				throw new ServiceException("Movie Details not found");
			}
            return movieDetails;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Update movie details information.
     *
     * @param movieDetails The MovieDetails object with updated information.
     * @return True if the update was successful, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     * @throws ValidationException 
     */
    public boolean updateMovieDetails(MovieDetails movieDetails) throws ServiceException {
        MovieDetailsDAO movieDetailsDAO = new MovieDetailsDAO();
        try {
            if (movieDetails == null) {
                throw new ServiceException("An error occurred while attempting to update movie details");
            }
            MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
        	movieDetailsValidation.validateMovieDetails(movieDetails);
            movieDetailsDAO.updateMovieDetails(movieDetails);
            return true;
        } catch (DAOException | ValidationException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Delete movie details by its ID.
     *
     * @param movieDetailsId The ID of the movie details to be deleted.
     * @return True if the deletion was successful, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     */
    public boolean deleteMovieDetails(int movieDetailsId) throws ServiceException {
      
        try {
        	  MovieDetailsDAO movieDetailsDAO = new MovieDetailsDAO();
        	 boolean movieDetails = movieDetailsDAO.deleteMovieDetails(movieDetailsId);
        	if (!movieDetails) {
				throw new ServiceException("An error occurred while attempting to delete movie details");
			}
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
