package com.signify.dao;

import java.sql.SQLException;

import com.signify.exception.UserNotFoundException;

public interface UserDAOInterface {

	public boolean validate(int userID,String password,String role) throws UserNotFoundException;
	public void updateDAOPassword(int id,String oldpass,String newpass) throws UserNotFoundException;
}
