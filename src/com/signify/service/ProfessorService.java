/**
 * 
 */
package com.signify.service;

import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;

/**
 * @author Naman
 *
 */
public class ProfessorService implements ProfessorInterface{

    ProfessorDAOInterface professor = new ProfessorDAOImplementation();
	public void viewEnrolledStudents(int id) 
	{
		professor.viewDAOEnrolledStudents(id);
	}
	public void addGrade(int prof_id,int student_id,String grade)
	{
		professor.addDAOgrades(prof_id,student_id,grade);
	}
	public void displayStudents(int prof_id)
	{
		professor.displayDAOStudents(prof_id);
	}
}