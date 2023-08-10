package cinephile.services;

import java.util.List;

import cinephile.DAO.RatingDAO;
import cinephile.DAO.exceptions.DAOException;
import cinephile.model.Rating;
import cinephile.services.exceptions.ServiceException;
import cinephile.validation.RatingValidation;
import cinephile.validation.exceptions.ValidationException;

public class RatingService {

	public boolean Rating(Rating rating) throws ServiceException {
		RatingDAO ratingDAO = new RatingDAO();
		try { 
			RatingValidation.validateRating(rating);
			if (ratingDAO.Rating(rating)) {
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
			RatingValidation.validateRating(rating);
			if (ratingDAO.Rating(rating)) {
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
			RatingValidation.validateRating(rating);
			if (ratingDAO.Rating(rating)) {
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
