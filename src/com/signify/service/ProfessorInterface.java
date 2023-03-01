/**
 * 
 */
package com.signify.service;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.CourseNotAssignedException;

/**
 * @author asus
 *
 */
public interface ProfessorInterface {

	/**
	 * View students enrolled in the course the professor teaches
	 * @param id
	 * @return list of student enrolled under professor
	 * @throws CourseNotAssignedException
	 */
	public List<Student> viewEnrolledStudents(int id)throws CourseNotAssignedException;
	/**
	 * Add grades for the student
	 * @param prof_id
	 * @param student_id
	 * @param grade
	 */
	public void addGrade(int prof_id,int student_id,String grade);
}
