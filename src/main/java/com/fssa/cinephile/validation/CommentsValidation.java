package com.fssa.cinephile.validation;

import com.fssa.cinephile.model.Comments;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class CommentsValidation {

	public boolean validateComment(Comments comments) throws ValidationException {
		
		String userComment = comments.getComment();
		 if (userComment == null || userComment.trim().isEmpty()) {
	            throw new ValidationException("The User Comment cannot be empty");
	        }else {
	        return true;
	        }
	}
		
}
