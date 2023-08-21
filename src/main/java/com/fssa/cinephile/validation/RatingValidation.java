package com.fssa.cinephile.validation;



import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class RatingValidation {

	public static boolean validateRating(Rating rating)throws ValidationException {
		if (rating.getRating() <= 1 && rating.getRating() >=5) {
			throw new ValidationException("The rating is: Invalid");
		} 
		return true ;
	}

}
