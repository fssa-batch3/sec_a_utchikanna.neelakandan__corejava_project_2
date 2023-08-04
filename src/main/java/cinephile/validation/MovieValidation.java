package cinephile.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cinephile.model.Movie;
import cinephile.validation.exceptions.InvalidUserException;

public class MovieValidation {
	
	public static boolean validateMovie(Movie movie ) throws InvalidUserException {

		if (validateMovieTitle(movie.getMovieTitle())
				&& validateMovieRating(movie.getMovieRating() )
				&& validateMovieImageUrl(movie.getMovieImg() )) {
			return true;
		} else {
			throw new InvalidUserException("Movie details not valid");
		}
	}
	
	public static boolean validateMovieTitle(String title) {
		boolean match = false;

		if (title == null)
			return false;

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(title);
		match = m.matches();
		if (match) {
			System.out.println("The movie title is valid.");
		} else {
			System.out.println("The movie title is not valid");
		}

		return match;
	}
	
	public static boolean validateMovieImageUrl(String imageUrl) throws InvalidUserException {

		if (imageUrl == null || imageUrl.isEmpty()) {		
			throw new InvalidUserException("image is not found");
		}		
		try {
			new URL(imageUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public static boolean validateMovieRating(int rating) {
		boolean isMatch = false;

		if (rating < 0)
			return false;
		String strNumber = String.valueOf(rating);
		String regex = "[0-5]";
		isMatch = Pattern.matches(regex, strNumber);
		if (isMatch) {
			System.out.println("The movie rating is: Valid");
		} else {
			System.out.println("The movie rating is: Invalid");
		}
		return isMatch;

	}

}
