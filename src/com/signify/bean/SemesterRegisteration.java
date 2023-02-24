/**
 * 
 */
package com.signify.bean;

/**
 * @author Naman
 *
 */
public class SemesterRegisteration {

	private int studentID;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDateOfRegisteration() {
		return dateOfRegisteration;
	}
	public void setDateOfRegisteration(String dateOfRegisteration) {
		this.dateOfRegisteration = dateOfRegisteration;
	}
	private int semester;
	private String dateOfRegisteration;
	
}