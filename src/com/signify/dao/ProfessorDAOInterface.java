package com.signify.dao;

public interface ProfessorDAOInterface {

	public void viewDAOEnrolledStudents(int id);
	public void addDAOgrades(int prof_id,int student_id,String grade);
	public void displayDAOStudents(int prof_id);
}
