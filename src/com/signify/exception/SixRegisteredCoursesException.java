package com.signify.exception;

public class SixRegisteredCoursesException extends Exception{
	
	public SixRegisteredCoursesException()
	{
		System.out.println("Already Registered in 6 courses, not allowed to add more.");
	}

}
