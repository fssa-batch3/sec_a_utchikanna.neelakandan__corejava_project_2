package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.validation.exceptions.ValidationException;

public class TestValidateMovieDetails {

	@Test
	void testValidMovieStory() {
		try {
			MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
			assertTrue(movieDetailsValidation.validateStory(
					"A man is driven by a personal vendetta to rectify the wrongs in society, while keeping a promise made years ago. He comes up against a monstrous outlaw with no fear, who has caused extreme suffering to many."));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidMovieStory() {
		MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
		ValidationException result = assertThrows(ValidationException.class,
				() -> movieDetailsValidation.validateStory(" "));
		assertEquals("The movie story cannot be empty", result.getMessage());
	}

	 @Test
	    void testValidReleaseDate() {
	        try {
	            MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
	            assertTrue(movieDetailsValidation.validateReleaseDate("2022-09-20"));
	        } catch (ValidationException e) {
	            System.out.println(e.getMessage());
	            fail();
	        }
	    }

	    @Test
	    void testInvalidReleaseDate() {
	        MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
	        ValidationException result = assertThrows(ValidationException.class,
	                () -> movieDetailsValidation.validateReleaseDate(" "));
	        assertEquals("The release date cannot be empty", result.getMessage());
	    }
	    
	    @Test
		void testValidMovieAward() {
			try {
				MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
				assertTrue(movieDetailsValidation.validateAwardName("Best Visual Effect"));
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				fail();
			}
		}

		@Test
		void testInvalidMovieAward() {
			MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
			ValidationException result = assertThrows(ValidationException.class,
					() -> movieDetailsValidation.validateAwardName(" "));
			assertEquals("The award name cannot be empty", result.getMessage());
		}
		
		@Test
		void testValidMovieAwardLink() {
			try {
				MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
				assertTrue(movieDetailsValidation.validateAwardWiki("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				fail();
			}
		}

		@Test
		void testInvalidMovieAwardLink() {
			MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
			ValidationException result = assertThrows(ValidationException.class,
					() -> movieDetailsValidation.validateAwardWiki(" "));
			assertEquals("The award wiki URL cannot be empty", result.getMessage());
		}
		
		@Test
		void testValidMovieLink() {
			try {
				MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
				assertTrue(movieDetailsValidation.validateMovieLink("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large"));
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				fail();
			}
		}

		@Test
		void testInvalidMovieLink() {
			MovieDetailsValidation movieDetailsValidation = new MovieDetailsValidation();
			ValidationException result = assertThrows(ValidationException.class,
					() -> movieDetailsValidation.validateMovieLink(" "));
			assertEquals("The movie link URL cannot be empty", result.getMessage());
		}
}
