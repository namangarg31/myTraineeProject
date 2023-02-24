package com.signify.bean;

import java.util.List;

/**
 * @author SIDARTH SAIKUMAR
 *
 */
public class Student extends User {
	private int studentId;
	private String branch;
	private int batch;
	private List<String>modules;
	public List<String> getModules() {
		return modules;
	}

	public void setModules(String module) {
		this.modules.add(module);
	}

	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
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
	
}