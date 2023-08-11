package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.RatingDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.RatingValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class RatingService {

	public boolean Rating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateRatingDetails(rating);
			if (ratingDAO.rating(rating)) {
				System.out.println(rating.getRatingId()+" added");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	 
	  
	    public List<Rating> getAllRatings() throws ServiceException {
	        try {
	            return RatingDAO.getAllRatings();
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
	    
	    
	public boolean updateRating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateRatingDetails(rating);
			if (ratingDAO.rating(rating)) {
				System.out.println(rating.getRatingId()+" successfully updated");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	


	
	public boolean readRating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateRatingDetails(rating);
			if (ratingDAO.rating(rating)) {
				System.out.println(rating.getRatingId()+" ratings are read!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}

}
