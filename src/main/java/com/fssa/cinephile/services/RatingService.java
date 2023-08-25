package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.RatingDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.RatingValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * A service class responsible for handling operations related to movie ratings.
 * 
 * @author UtchikannaNeelakanda
 */
public class RatingService {

    /**
     * Gives a rating for a movie.
     *
     * @param rating The Rating object containing information about the movie rating.
     * @return {@code true} if the rating was successfully added, {@code false} otherwise.
     * @throws ServiceException If there is an issue while attempting to give the rating.
     *                          This exception encapsulates any underlying {@link DAOException} or {@link ValidationException}.
     */
    public boolean giveRating(Rating rating) throws ServiceException {
        RatingDAO ratingDAO = new RatingDAO();
        try { 
            if (rating == null) {
                throw new ServiceException("Rating cannot be null");
            }
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
    

    /**
     * Retrieves the specified rating from the database.
     *
     * @param rating The Rating object containing information about the rating to be retrieved.
     * @return {@code true} if the specified rating was found in the database, {@code false} otherwise.
     * @throws ServiceException If there is an issue while attempting to retrieve the rating.
     *                          This exception encapsulates any underlying {@link DAOException} or {@link ValidationException}.
     */
    public boolean readRating(Rating rating) throws ServiceException {
        RatingDAO ratingDAO = new RatingDAO();
        try {
            if (rating == null) {
                throw new ServiceException("Rating is null");
            }
            RatingValidation.validateRating(rating);
            return ratingDAO.readRating(rating);

        } catch (DAOException | ValidationException e) {
            throw new ServiceException(e);
        }
    }

	 

    /**
     * Retrieves a list of all ratings from the database.
     * @param rating 
     *
     * @return A list of Rating objects representing all the ratings in the database.
     * @throws ServiceException If there is an issue while attempting to retrieve the ratings.
     *                        This exception encapsulates any underlying {@link DAOException}.
     */
    public List<Rating> listAllRatings(Rating rating) throws ServiceException {
        try {
            // Retrieve all ratings from the database using the RatingDAO
            return RatingDAO.getAllRatings();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Updates an existing rating for a movie.
     *
     * @param rating The Rating object containing updated rating information.
     * @return {@code true} if the rating was successfully updated, {@code false} otherwise.
     * @throws ServiceException If there is an issue while attempting to update the rating.
     *                          This exception encapsulates any underlying {@link DAOException} or {@link ValidationException}.
     */
    public boolean updateRating(Rating rating) throws ServiceException {
        RatingDAO ratingDAO = new RatingDAO();
        try { 
            if (rating == null) {
                throw new ServiceException("Rating update cannot be null");
            }
            RatingValidation.validateUpdateRating(rating);
            if (ratingDAO.updateRating(rating)) {
                return true;
            } else {
            	System.out.println("Utchi");
                return false;
            }

        } catch (DAOException | ValidationException e) { 
            throw new ServiceException(e);
        }
    }
}
