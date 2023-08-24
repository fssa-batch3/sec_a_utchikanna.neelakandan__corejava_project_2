package com.fssa.cinephile.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class MovieValidation {

	public static boolean validateMovie(Movie movie) throws ValidationException {

		if (validateMovieTitle(movie.getMovieTitle()) && validateMovieRating(movie.getMovieRating())
				&& validateMovieImageUrl(movie.getMovieImgUrl())) {
			return true;
		} else {
			throw new ValidationException("Movie details not valid");
		}
	}
	 
	public static boolean validateMovieTitle(String title) throws ValidationException {
		boolean match = false;

		if (title == null)
			return false;

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(title);
		match = m.matches();
		if (match) {
			System.out.println("The movie title is valid");
		} else {
			throw new ValidationException("The movie title is not valid");
			
		}
      
		return match;
	}

	public static boolean validateMovieImageUrl(String imageUrl) throws ValidationException {


		try {
			URL val = new URL(imageUrl);
			System.out.println(val + " image is found");
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("image is not found");
		}

		
	}

	public static boolean validateMovieRating(int rating) throws ValidationException {
		boolean isMatch = false;

		if (rating < 0)
			return false;
		String strNumber = String.valueOf(rating);
		String regex = "[0-5]";
		isMatch = Pattern.matches(regex, strNumber);
		if (isMatch) {
			System.out.println("The movie rating is: Valid");
		} else {
			throw new ValidationException("The movie rating is: Invalid");
		}
		return isMatch;

	}

}
