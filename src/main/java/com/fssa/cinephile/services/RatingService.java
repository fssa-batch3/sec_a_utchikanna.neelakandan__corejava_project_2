package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.RatingDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.RatingValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class RatingService {

	public boolean giveRating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateGiveRating(rating);
			if (ratingDAO.addRating(rating)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	 
	  
	
	    
	    
	public boolean updateRating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateUpdateRating(rating);
			if (ratingDAO.updateRating(rating)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	


	
	

}
