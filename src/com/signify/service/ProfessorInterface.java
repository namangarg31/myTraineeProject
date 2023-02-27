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

	public List<Student> viewEnrolledStudents(int id)throws CourseNotAssignedException;
	public void addGrade(int prof_id,int student_id,String grade);
}
