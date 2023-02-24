package com.signify.bean;

public class Professor extends User{
	private String department;
	public String getDepartment() {
		return department;
	}
	
	public Professor(){
		this.department = "CS";
		this.designation = "Professor";
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	private String designation;
}