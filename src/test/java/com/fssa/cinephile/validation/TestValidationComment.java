package com.fssa.cinephile.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Comments;
import com.fssa.cinephile.validation.exceptions.ValidationException;

class TestValidationComment {

	private Comments comments = new Comments();
	private CommentsValidation commentsValidation = new CommentsValidation();
	@Test
	void testValidComment() {
		try {
			
			comments.setComment("Good Movie");
			assertTrue(commentsValidation.validateComment(comments));
		} catch (ValidationException e) {
			fail();
		}
	}

	@Test
	void testInvalidComment() {
		comments.setComment("");
		ValidationException result = assertThrows(ValidationException.class,
				() -> commentsValidation.validateComment(comments));
		assertEquals("The User Comment cannot be empty", result.getMessage());
	}
}
