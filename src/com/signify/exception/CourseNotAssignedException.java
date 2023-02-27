/**
 * 
 */
package com.signify.exception;

/**
 * @author asus
 *
 */
public class CourseNotAssignedException extends Exception{

	 public CourseNotAssignedException() {
		 System.out.println("No courses assigned to you yet!");
	}
}
