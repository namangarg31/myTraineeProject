/**
 * 
 */
package com.signify.exception;

/**
 * @author asus
 *
 */
public class FeePendingException extends Exception{

	public FeePendingException()
	{
		System.out.println("Fee for the student is pending you can't assign grade.....");
	}
}
