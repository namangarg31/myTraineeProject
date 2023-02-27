package com.signify.exception;

public class CourseNotFoundException extends Exception{
	public CourseNotFoundException() 
	{
		System.out.println("No such course exist...");
	}

}