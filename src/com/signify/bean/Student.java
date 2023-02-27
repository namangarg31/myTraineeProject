package com.signify.bean;

import java.util.List;

/**
 * @author SIDARTH SAIKUMAR
 *
 */
public class Student extends User {
	private String branch;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public int getIsapproved() {
		return isapproved;
	}
	public void setIsapproved(int isapproved) {
		this.isapproved = isapproved;
	}
	private int batch;
	private int isapproved;
	
	
}