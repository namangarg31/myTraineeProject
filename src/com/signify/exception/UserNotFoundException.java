package com.signify.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException()
	{
		System.out.println("User Not Found");
	}

}