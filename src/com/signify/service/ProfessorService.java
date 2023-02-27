/**
 * 
 */
package com.signify.service;

import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Student;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.exception.CourseNotAssignedException;
import com.signify.exception.FeePendingException;
import com.signify.exception.NotTeachingExcetion;

/**
 * @author Naman
 *
 */
public class ProfessorService implements ProfessorInterface{

    ProfessorDAOInterface professor = new ProfessorDAOImplementation();
	public List<Student> viewEnrolledStudents(int id) 
	{
	   List<Student>students = new ArrayList<Student>();
	   try
	   {
		   students = professor.viewDAOEnrolledStudents(id);
	   }
	   catch(CourseNotAssignedException ce)
	   {
		   
	   }
	   return students;
	}
	public void addGrade(int prof_id,int student_id,String grade)
	{
		try {
			professor.addDAOgrades(prof_id,student_id,grade);
		} catch (CourseNotAssignedException | FeePendingException | NotTeachingExcetion e) {
			
		}
	}
}