/**
 * 
 */
package com.fssa.cinephile.services;

import java.util.Map;

import com.fssa.cinephile.DAO.RatingDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.RatingValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;



/**
 * 
 */
public class RatingService {

	private RatingDAO ratingDAO = new RatingDAO();

	public boolean submitRating(Rating rating) throws ServiceException {
		try {
			RatingValidation ratingValidator = new RatingValidation();
			ratingValidator.validateRating(rating);

			return ratingDAO.addRating(rating);

		} catch (ValidationException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
    public Map<String, Object> getAverageRatingAndCountByMovie(int movieId) throws ServiceException {
        try {
            return ratingDAO.getRatingByMovie(movieId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public int getRatingByMovieAndUser(int movieId, int userId) throws ServiceException {
        try {
            return ratingDAO.getRatingByMovieAndUser(movieId, userId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}