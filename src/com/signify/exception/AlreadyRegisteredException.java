package com.signify.exception;

public class AlreadyRegisteredException extends Exception{

	public AlreadyRegisteredException(int cid) {
		System.out.println("Already Registered in Course - "+cid);
	}
}
