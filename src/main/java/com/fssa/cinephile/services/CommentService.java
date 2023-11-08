package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.dao.CommentsDAO;
import com.fssa.cinephile.dao.exception.DAOException;
import com.fssa.cinephile.model.Comments;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.CommentsValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;


public class CommentService {
	private CommentsDAO commentDAO = new CommentsDAO();
	public boolean addComment(Comments comments) throws ServiceException {
		
		try {
			if (comments == null) {
				throw new ServiceException("comments object cannot be null");
			}
			CommentsValidation commentsValidation = new CommentsValidation();
			commentsValidation.validateComment(comments);
			if (!commentDAO.addComment(comments)) {
				return false;
			} 
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	 public String getCommentByMovieAndUser(int movieId, int userId) throws ServiceException {
	        try {
	            return commentDAO.getCommentByMovieAndUser(movieId, userId);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 
	 public List<Comments> getAllCommentByMovie(int movieId) throws ServiceException {
	        try {
	            return commentDAO.getMoviesComments(movieId);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 
	 public boolean updateComment(Comments comments) throws ServiceException {
			
			try {
				if (comments == null) {
					throw new ServiceException("An error occurred while attempting to update comment");
				}
				CommentsValidation commentValidation = new CommentsValidation();
				commentValidation.validateComment(comments);
				commentDAO.updateComment(comments);
				return true;

			} catch (DAOException | ValidationException e) {
				throw new ServiceException(e.getMessage());
			}

		}
	 
	 public boolean deleteComment(int commentId) throws ServiceException {
			try {
				
				boolean comment = commentDAO.deleteComment(commentId); 
				
				if (!comment) {
					throw new ServiceException("An error occurred while attempting to delete comment");
				}
				return true;
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	 

}
