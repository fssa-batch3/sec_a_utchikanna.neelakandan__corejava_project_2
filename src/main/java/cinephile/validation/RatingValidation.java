package cinephile.validation;


import java.util.regex.Pattern;

import cinephile.model.Rating;
import cinephile.validation.exceptions.ValidationException;

public class RatingValidation {

	public static boolean validateRating(Rating rating) throws ValidationException {

		if ( validateRating(rating.getRating())) {
			return true;
		} else {
			throw new ValidationException("Rating details not valid");
		}
	}
	

	public static boolean validateRating(int rating) {
		boolean isMatch = false;

		if (rating < 0)
			return false;
		String strNumber = String.valueOf(rating);
		String regex = "[0-5]";
		isMatch = Pattern.matches(regex, strNumber);
		if (isMatch) {
			System.out.println("The rating is: Valid");
		} else {
			System.out.println("The rating is: Invalid");
		}
		return isMatch;

	}

}
