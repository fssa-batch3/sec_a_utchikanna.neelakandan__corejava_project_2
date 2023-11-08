package com.fssa.cinephile.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fssa.cinephile.model.MovieDetails;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Utility class for validating MovieDetails objects.
 * 
 * @author [Your Name]
 */
public class MovieDetailsValidation {

    /**
     * Validates a MovieDetails object.
     *
     * @param movieDetails The MovieDetails object to be validated.
     * @throws ValidationException If the MovieDetails are not valid.
     */
    public void validateMovieDetails(MovieDetails movieDetails) throws ValidationException {
        if (movieDetails == null) {
            throw new ValidationException("MovieDetails cannot be null");
        }
         
        validateStory(movieDetails.getStory());
        validateReleaseDate(movieDetails.getReleaseDate());
        validateAwardName(movieDetails.getAwardName());
        validateAwardWiki(movieDetails.getAwardWiki());
        validateMovieLink(movieDetails.getMovieLink());
    }

    /**
     * Validates a movie story.
     *
     * @param story The movie story to be validated.
     * @throws ValidationException If the movie story is not valid.
     */
    public boolean validateStory(String story) throws ValidationException {
        if (story == null || story.trim().isEmpty()) {
            throw new ValidationException("The movie story cannot be empty");
        }else {
        return true;
        }
    }

    /**
     * Validates a release date string in the format "yyyy-MM-dd".
     *
     * @param releaseDate The release date string to be validated.
     * @throws ValidationException If the release date is not valid.
     */
    public boolean validateReleaseDate(String releaseDate) throws ValidationException {
        if (releaseDate == null || releaseDate.trim().isEmpty()) {
            throw new ValidationException("The release date cannot be empty");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(releaseDate);
            // Check if the parsed date is equal to the input date, which ensures a valid date format.
            if (!releaseDate.equals(dateFormat.format(date))) {
                throw new ValidationException("Invalid release date format. Please use yyyy-MM-dd");
            }
            return true;
        } catch (ParseException e) {
            throw new ValidationException("Invalid release date format. Please use yyyy-MM-dd");
        }
    }

    /**
     * Validates an award name.
     *
     * @param awardName The award name to be validated.
     * @throws ValidationException If the award name is not valid.
     */
    public boolean validateAwardName(String awardName) throws ValidationException {
        if (awardName == null || awardName.trim().isEmpty()) {
            throw new ValidationException("The award name cannot be empty");
        }else {
        	return true;	
        }
    }

    /**
     * Validates an award wiki URL.
     *
     * @param awardWiki The award wiki URL to be validated.
     * @throws ValidationException If the award wiki URL is not valid.
     */
    public boolean validateAwardWiki(String awardWiki) throws ValidationException {
        if (awardWiki == null || awardWiki.trim().isEmpty()) {
            throw new ValidationException("The award wiki URL cannot be empty");
        }
        try {
			new URL(awardWiki);
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("URL is not found");
		}
    }

    /**
     * Validates a movie link URL.
     *
     * @param movieLink The movie link URL to be validated.
     * @throws ValidationException If the movie link URL is not valid.
     */
    public boolean validateMovieLink(String movieLink) throws ValidationException {
        if (movieLink == null || movieLink.trim().isEmpty()) {
            throw new ValidationException("The movie link URL cannot be empty");
        }
        try {
			new URL(movieLink);
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("URL is not found");
		}
    }
}
