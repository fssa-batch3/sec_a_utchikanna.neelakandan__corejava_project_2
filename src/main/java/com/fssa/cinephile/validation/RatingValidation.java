package com.fssa.cinephile.validation;

import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * This class provides methods to validate Rating objects.
 */
public class RatingValidation {

    /**
     * Validates a Rating object's rating value.
     *
     * @param rating The Rating object to be validated.
     * @return True if the rating is valid (between 1 and 5), false otherwise.
     * @throws ValidationException If the rating is invalid.
     */
    public static boolean validateRating(Rating rating) throws ValidationException {
        if (rating.getRating() >= 1 && rating.getRating() <= 5) {
            return true;
        } else {
            throw new ValidationException("Invalid rating value. Rating must be between 1 and 5.");
        }
    }

    /**
     * Validates a Rating object for an update operation.
     *
     * @param rating The Rating object to be validated for update.
     * @return True if the Rating object is not null, false otherwise.
     * @throws ValidationException If the Rating object is null.
     */
    public static boolean validateUpdateRating(Rating rating) throws ValidationException {
        if (rating != null) {
            return true;
        } else {
            throw new ValidationException("Invalid rating update. Rating object cannot be null.");
        }
    }

    /**
     * Validates a Rating object for adding a new rating.
     *
     * @param rating The Rating object to be validated for adding a rating.
     * @return True if the Rating object is not null, false otherwise.
     * @throws ValidationException If the Rating object is null.
     */
    public static boolean validateGiveRating(Rating rating) throws ValidationException {
        if (rating != null) {
            return true;
        } else {
            throw new ValidationException("Invalid rating addition. Rating object cannot be null.");
        }
    }

    /**
     * Validates a Rating object for reading a rating.
     *
     * @param rating The Rating object to be validated for reading.
     * @return True if the Rating object is not null, false otherwise.
     * @throws ValidationException If the Rating object is null.
     */
    public static boolean validateReadRating(Rating rating) throws ValidationException {
        if (rating != null) {
            return true;
        } else {
            throw new ValidationException("Invalid rating read. Rating object cannot be null.");
        }
    }
}
