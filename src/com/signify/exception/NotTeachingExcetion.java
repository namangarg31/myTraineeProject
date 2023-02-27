/**
 * 
 */
package com.signify.exception;

/**
 * @author asus
 *
 */
public class NotTeachingExcetion extends Exception{

	public NotTeachingExcetion()
	{
		System.out.println("You are not teaching this student , grade can't be assigned.....");
	}
}
