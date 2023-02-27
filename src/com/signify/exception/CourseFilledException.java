package com.signify.exception;

public class CourseFilledException extends Exception{

	 public CourseFilledException()
	 {
		 System.out.println("This course is already filled, Please select another course.");
	 }
}
