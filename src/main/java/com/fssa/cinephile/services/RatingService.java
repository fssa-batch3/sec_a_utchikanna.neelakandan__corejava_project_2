/**
 * 
 */
package com.fssa.cinephile.services;

import java.util.Map;

import com.fssa.cinephile.dao.RatingDAO;
import com.fssa.cinephile.dao.exception.DAOException;
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
			boolean add = ratingDAO.addRating(rating);
			if(!add) {
        		throw new ServiceException("An error occurred while attempting to add rating");
        	}else {
            return add;
        	}
		

		} catch (ValidationException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
    public Map<String, Object> getAverageRatingAndCountByMovie(int movieId) throws ServiceException {
        try {
        	Map<String, Object> rating = ratingDAO.getRatingByMovie(movieId);
        	if(rating == null) {
        		throw new ServiceException("Rating list is null");
        	}else {
            return rating;
        	}
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public int getRatingByMovieAndUser(int movieId, int userId) throws ServiceException {
        try {
        	int avg = ratingDAO.getRatingByMovieAndUser(movieId, userId);
        	if(avg < 0) {
        		throw new ServiceException("Rating object is null");
        	}else {
            return avg;
        	} 
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}