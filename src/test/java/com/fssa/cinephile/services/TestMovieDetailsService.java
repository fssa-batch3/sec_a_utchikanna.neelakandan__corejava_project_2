package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.MovieDetails;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Test class for the MovieDetailsService methods.
 * 
 * @author UtchikannaNeelakanda
 */
class TestMovieDetailsService {

    @Test
    void testCreateMovieDetailsSuccess() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        Movie movie = new Movie();
      		movie.setMovieId(7);
              MovieDetails movieDetails = new MovieDetails("Updated story", "2023-09-20", "Updated Award",
                      "https://example.com/updated-award", "https://example.com/updated-movie",movie,"https://example.com/updated-award","Atlee");
        
        try {
            assertTrue(movieDetailsService.createMovieDetails(movieDetails));
        } catch (ServiceException | ValidationException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testCreateMovieDetailsNullDetails() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieDetailsService.createMovieDetails(null));
        assertEquals("An error occurred while attempting to create movie details", exception.getMessage());
    }


    @Test
    void testUpdateMovieDetailsSuccess() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        Movie movie = new Movie();
		movie.setMovieId(5);
		  MovieDetails movieDetails = new MovieDetails("Updated story", "2023-09-20", "Updated Award",
                  "https://example.com/updated-award", "https://example.com/updated-movie",movie,"https://example.com/updated-award","Atlee");
        try {
            assertTrue(movieDetailsService.updateMovieDetails(movieDetails));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testUpdateMovieDetailsNullDetails() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieDetailsService.updateMovieDetails(null));
        assertEquals("An error occurred while attempting to update movie details", exception.getMessage());
    }



    @Test
    void testGetMovieDetailsByIdSuccess() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        
        try {
            MovieDetails retrievedDetails = movieDetailsService.getMovieDetailsById(3);
            assertNotNull(retrievedDetails);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testGetMovieDetailsByIdInvalid() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieDetailsService.getMovieDetailsById(0));
        assertEquals("Movie Details not found", exception.getMessage());
    }

    @Test
    void testDeleteMovieDetailsSuccess() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        int movieDetailsId = 12;

        try {
            boolean isDeleted = movieDetailsService.deleteMovieDetails(movieDetailsId);
            assertTrue(isDeleted);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testDeleteMovieDetailsNullDetails() {
        MovieDetailsService movieDetailsService = new MovieDetailsService();
        ServiceException exception = assertThrows(ServiceException.class, () -> movieDetailsService.deleteMovieDetails(0));
        assertEquals("An error occurred while attempting to delete movie details", exception.getMessage());
    }
}
