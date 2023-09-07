package com.fssa.cinephile.validation;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * This class provides methods to validate Rating objects.
 */
public class RatingValidation {
	

	/**
	 * Validates a rating value.
	 *
	 * @param rating The Rating object to be validated.
	 * @return true if the rating is valid (between 1 and 5), false otherwise.
	 * @throws ValidationException if the rating is not within the valid range.
	 */
	public static boolean validateRating(Rating rating) throws ValidationException {
		int minRating = 1;
		int maxRating = 5;
		int ratingValue = rating.getRating();

		if (ratingValue >= minRating && ratingValue <= maxRating) {
			return true;
		} else {
			throw new ValidationException("Invalid rating value. Rating must be between 1 and 5.");
		}
	}






}
