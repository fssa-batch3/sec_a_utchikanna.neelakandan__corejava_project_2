package com.fssa.cinephile.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Utility class for validating Movie objects.
 * 
 * @author UtchikannaNeelakandan
 */
public class MovieValidation {

	/**
	 * Validates a Movie object.
	 *
	 * @param movie The Movie object to be validated.
	 * @throws ValidationException If the Movie details are not valid.
	 */
	public void validateMovie(Movie movie) throws ValidationException {
		if (validateMovieTitle(movie.getMovieTitle()) && validateMovieType(movie.getMovieType()) && validateMovieTrailer(movie.getMovieTrailer())) {
			validateMovieImageUrl(movie.getMovieImgUrl());
		}
	}

	/**
	 * Validates a movie title.
	 *
	 * @param title The movie title to be validated.
	 * @return True if the movie title is valid, false otherwise.
	 * @throws ValidationException If the movie title is not valid.
	 */
	public boolean validateMovieTitle(String title) throws ValidationException {
		boolean match = false;

		if (title == null)
			throw new ValidationException("The movie title cannot be empty");

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(title);
		match = m.matches();
		if (!match) {
			throw new ValidationException("The movie title is not valid");
		}

		return match;
	}

	/**
	 * Validates a movie Type.
	 *
	 * @param movieType The movie Type to be validated.
	 * @return True if the movie Type is valid, false otherwise.
	 * @throws ValidationException If the movie Type is not valid.
	 */
	public boolean validateMovieType(String movieType) throws ValidationException {
		boolean match = false;

		if (movieType == null)
			throw new ValidationException("The movie Type cannot be empty");

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(movieType);
		match = m.matches();
		if (match) {
			System.out.println("The movie Type is valid");
		} else {
			throw new ValidationException("The movie Type is not valid");
		}

		return match;
	}

	/**
	 * Validates a movie image URL.
	 *
	 * @param imageUrl The movie image URL to be validated.
	 * @return True if the image URL is valid, false otherwise.
	 * @throws ValidationException If the image URL is not valid.
	 */
	public boolean validateMovieImageUrl(String imageUrl) throws ValidationException {
		try {
			URL val = new URL(imageUrl);
			System.out.println(val + " image is found");
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("Image is not found");
		}
	}
	
	/**
	 * Validates a movie Trailer.
	 *
	 * @param movieTrailer The movie Trailer URL to be validated.
	 * @return True if the Trailer URL is valid, false otherwise.
	 * @throws ValidationException If the Trailer URL is not valid.
	 */
	public boolean validateMovieTrailer(String movieTrailer) throws ValidationException {
		try {
			URL val = new URL(movieTrailer);
			System.out.println(val + " trailer is found");
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("trailer is not found");
		}
	}

	
}
