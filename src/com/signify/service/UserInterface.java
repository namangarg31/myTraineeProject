/**
 * 
 */
package com.signify.service;

/**
 * @author asus
 *
 */
public interface UserInterface {

	public void userLogin(int userID,String password,String role);
	public void updatePassword(int id,String oldpass,String newpass);
}
