package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.UserDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.util.PasswordUtil;
import com.fssa.cinephile.validation.UserValidator;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Service class for managing User-related operations.
 * 
 * @author UtchikannaNeelakandan
 */
public class UserService {

	UserDAO userDAO = new UserDAO();
	UserValidator userValidator = new UserValidator();
	/**
	 * Registers a new user.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return True if the user registration was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process.
	 */
	public boolean registerUser(User user) throws ServiceException {
		

		try {
			if (user == null) {
				throw new ServiceException("Registration credentials must not be null");
			}
			
			userValidator.validateUser(user);
			// Check if the user already exists and is Active
			boolean existingUser = userDAO.doesUserExist(user.getEmail());
			if (existingUser) {
				throw new ServiceException("User already exists.");
			}
			String newPassword = PasswordUtil.hashPassword(user.getPassword());
			user.setPassword(newPassword);
			userDAO.createUser(user);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
    /**
     * Retrieves a user by their email.
     *
     * @param searchEmail The email of the user to retrieve
     * @return The User object if found, otherwise null
     * @throws ServiceException If an error occurs during the service operation
     */
    public User getUserByEmail(String searchEmail) throws ServiceException {
        try {
            return userDAO.getUser(searchEmail); 
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    
    /**
     * Update a user's information.
     *
     * @param user The user object containing updated information.
     * @return True if the update was successful, false otherwise.
     * @throws ServiceException If the user is not found, if there's a problem with the service,
     *                          or if the updated user information is invalid.
     */
    public boolean updateUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
       
        try {
            if (user == null) {
                throw new ServiceException("An error occurred while attempting to update user");
            }
            
            UserValidator userValidator2 = new UserValidator();
			// Validate the updated user information
            userValidator2.validateUpdateUser(user);
            userDAO.updateUser(user);
            return true;

        } catch (DAOException | ValidationException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    
	/**
	 * Attempts to log in a user.
	 *
	 * @param user The User object representing the user's login credentials.
	 * @return True if the login was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the login process.
	 */
	public boolean logInUser(User user) throws ServiceException {
		try {
			userValidator.validateLogIn(user);
			User fromDb = userDAO.checkUserLogin(user.getEmail());
			if (!PasswordUtil.checkPassword(user.getPassword(),fromDb.getPassword())) {
				throw new DAOException("Bad credentials");	
			}
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * Delete a user by their unique identifier.
	 *
	 * @param userId The unique identifier of the user to be deleted.
	 * @return True if the user is deleted successfully, false otherwise.
	 * @throws ServiceException If the user is not found or if there's a problem with the service.
	 */
	public boolean deleteUser(int userId) throws ServiceException {
	    try {
	        UserDAO userDAO = new UserDAO();
	        
	        // Call the DAO method to delete the user by their unique identifier
	        boolean userDeleted = userDAO.deleteUser(userId);
	        
	        if (!userDeleted) {
	            throw new ServiceException("An error occurred while attempting to delete the user");
	        }
	        
	        return true;
	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage());
	    }
	}

}
