/**
 * 
 */
package com.signify.service;

/**
 * @author asus
 *
 */
public interface UserInterface {

	/**
	 * Log in the user
	 * @param userID
	 * @param password
	 * @param role
	 */
	public void userLogin(int userID,String password,String role);
	/**
	 * Update password
	 * @param id
	 * @param oldpass
	 * @param newpass
	 */
	public void updatePassword(int id,String oldpass,String newpass);
}
