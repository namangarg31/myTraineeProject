package com.signify.dao;

import java.sql.SQLException;

import com.signify.exception.UserNotFoundException;

public interface UserDAOInterface {

	/**
	 * Validate Credentials of the User
	 * @param userID
	 * @param password
	 * @param role
	 * @return if the user and password are correct or not
	 * @throws UserNotFoundException
	 */
	public boolean validate(int userID,String password,String role) throws UserNotFoundException;
	/**
	 * Update Password
	 * @param id
	 * @param oldpass
	 * @param newpass
	 * @throws UserNotFoundException
	 */
	public void updateDAOPassword(int id,String oldpass,String newpass) throws UserNotFoundException;
}
