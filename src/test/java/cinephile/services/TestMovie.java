package cinephile.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import cinephile.model.Movie;
import cinephile.services.exceptions.ServiceException;

public class TestMovie {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int id = (int)currentTimestamp;
		Movie movie = new Movie("Leo", id,3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		MovieService movieService = new MovieService();

		try {
			movieService.Movie(movie);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	public void testAddMovieSuccess() {
		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int id = (int)currentTimestamp;
		Movie movie = new Movie("Leo", id, 3, "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertTrue(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	public void testInvalidMovieTitle() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int id = (int)currentTimestamp;
		Movie movie = new Movie("Leo",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}

	@Test
	public void testInvalidMovieId() {

		MovieService movieService = new MovieService();
		LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int id = (int)currentTimestamp;
		Movie movie = new Movie("Leo",id, 3 , "https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		try {
			assertFalse(movieService.Movie(movie));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
	 @Test
	    void testUpdateBook() {
	        try {
	            Book existingBook = bookService.getBookByName(book.getTitle());
	            assertNotNull(existingBook, "Book should exist");

	            existingBook.setDescription("Updated description");
	            Book updatedBook = bookService.updateBook(existingBook);

	            assertNotNull(updatedBook, "Updated book should not be null");
	            assertEquals(existingBook.getDescription(), updatedBook.getDescription(), "Description should be updated");
	        } catch (ServiceException | DAOException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }

	    @Test
	    void testDeleteBook() {
	        try {
	            Book existingBook = bookService.getBookByName(book.getTitle());
	            assertNotNull(existingBook, "Book should exist");

	            boolean isDeleted = bookService.deleteBook(book.getTitle());
	            assertTrue(isDeleted, "Book should be deleted successfully");

	        } catch (ServiceException | DAOException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }
    
	

}
