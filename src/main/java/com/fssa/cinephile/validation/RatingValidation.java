package com.fssa.cinephile.validation;



import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class RatingValidation {

	public static boolean validateRating(Rating rating)throws ValidationException {
		if (rating.getRating() >= 1 && rating.getRating() <=5) {
			return true ;
		}else {
			throw new ValidationException("The rating is: Invalid");
		}
		
	}
	
	 public static boolean validateUpdateRating(Rating Rating) throws ValidationException {

	        if (Rating != null) {
	            return true;
	        } else {
	            throw new ValidationException("Rating update is : Invalid");
	        }

	    }
	 
	 public static boolean validateGiveRating(Rating Rating) throws ValidationException {

	        if (Rating != null) {
	            return true;
	        } else {
	            throw new ValidationException("Rating update is : Invalid");
	        }

	    }
	 
	 public static boolean validateReadRating(Rating Rating) throws ValidationException {

	        if (Rating != null) {
	            return true;
	        } else {
	            throw new ValidationException("Rating update is : Invalid");
	        }

	    }

}
