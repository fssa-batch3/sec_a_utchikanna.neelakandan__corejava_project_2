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
 *   @author UtchikannaNeelakandan
 */
public class MovieValidation {

    /**
     * Validates a Movie object.
     *
     * @param movie The Movie object to be validated.
     * @return True if the Movie is valid, false otherwise.
     * @throws ValidationException If the Movie details are not valid.
     */
    public static boolean validateMovie(Movie movie) throws ValidationException {
        if (validateMovieTitle(movie.getMovieTitle())
                && validateMovieRating(movie.getMovieRating())
                && validateMovieImageUrl(movie.getMovieImgUrl())) {
            return true;
        } else {
            throw new ValidationException("Movie details not valid");
        }
    }

    /**
     * Validates a movie title.
     *
     * @param title The movie title to be validated.
     * @return True if the movie title is valid, false otherwise.
     * @throws ValidationException If the movie title is not valid.
     */
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

    /**
     * Validates a movie image URL.
     *
     * @param imageUrl The movie image URL to be validated.
     * @return True if the image URL is valid, false otherwise.
     * @throws ValidationException If the image URL is not valid.
     */
    public static boolean validateMovieImageUrl(String imageUrl) throws ValidationException {
        try {
            URL val = new URL(imageUrl);
            System.out.println(val + " image is found");
            return true;
        } catch (MalformedURLException e) {
            throw new ValidationException("Image is not found");
        }
    }

    /**
     * Validates a movie rating.
     *
     * @param rating The movie rating to be validated.
     * @return True if the movie rating is valid, false otherwise.
     * @throws ValidationException If the movie rating is not valid.
     */
    public static boolean validateMovieRating(int rating) throws ValidationException {
        boolean isMatch = false;

        if (rating < 0)
            return false;

        String strNumber = String.valueOf(rating);
        String regex = "[0-5]";
        isMatch = Pattern.matches(regex, strNumber);
        if (isMatch) {
            System.out.println("The movie rating is valid");
        } else {
            throw new ValidationException("The movie rating is invalid");
        }
        return isMatch;
    }
}
