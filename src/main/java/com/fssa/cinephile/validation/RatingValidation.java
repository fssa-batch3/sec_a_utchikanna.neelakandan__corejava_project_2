package com.fssa.cinephile.validation;



import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class RatingValidation {

	public static boolean validateRatingDetails(Rating rating) throws ValidationException {

		if (!validateRating(rating.getRating())) {
			
			throw new ValidationException("Rating details not valid");
		}
		return true;
	}
	

	public static boolean validateRating(int rating)throws ValidationException {
	
	
		if (rating >= 1 && rating <=5) {
			System.out.println("The rating is: Valid");
			return true ;
		} else {
			throw new ValidationException("The rating is: Invalid");
			
		}
		
	}

}
