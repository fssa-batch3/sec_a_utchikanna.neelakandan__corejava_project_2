package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Comments;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;

class TestCommentService {
	
	private CommentService commentService = new CommentService();
	private Movie movie = new Movie();
	private User user = new User();
	
	@Test
    void testAddCommentSuccess() {
	   movie.setMovieId(4);
	   user.setUserId(1);
		Comments comments = new Comments("Good",movie,user);
        try {
            assertTrue(commentService.addComment(comments));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testAddCommentNullDetails() {
        ServiceException exception = assertThrows(ServiceException.class, () -> commentService.addComment(null));
        assertEquals("comments object cannot be null", exception.getMessage());
    }

    @Test
    void testGetRatingByMovieAndUserSuccess() {
        int movieId = 4;
        int userId = 1;
        try {
            String rating = commentService.getCommentByMovieAndUser(movieId, userId);
            assertNotNull(rating);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testGetAllCommentByMovieSuccess() {
 	   int movieId = 5;
        try {
            List<Comments> commentList = commentService.getAllCommentByMovie(movieId);
            assertNotNull(commentList);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testUpdateCommentSuccess() {
 	   movie.setMovieId(5);
 	  user.setUserId(1);
 		Comments comments = new Comments("Good",movie,user);
        try {
            assertTrue(commentService.updateComment(comments));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testUpdateCommentNullDetails() {
        ServiceException exception = assertThrows(ServiceException.class, () -> commentService.updateComment(null));
        assertEquals("An error occurred while attempting to update comment", exception.getMessage());
    }

    @Test
    void testDeleteCommentSuccess() {
        int commentId = 16;
        try {
            assertTrue(commentService.deleteComment(commentId));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testDeleteCommentInvalidComment() {
        int commentId = 999; // An invalid comment ID that does not exist in the mock DAO
        ServiceException exception = assertThrows(ServiceException.class, () -> commentService.deleteComment(commentId));
        assertEquals("An error occurred while attempting to delete comment", exception.getMessage());
    }

}
