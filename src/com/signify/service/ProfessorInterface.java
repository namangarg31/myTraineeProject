/**
 * 
 */
package com.signify.service;

/**
 * @author asus
 *
 */
public interface ProfessorInterface {

	public void viewEnrolledStudents(int id);
	public void addGrade(int prof_id,int student_id,String grade);
	public void displayStudents(int prof_id);
}
