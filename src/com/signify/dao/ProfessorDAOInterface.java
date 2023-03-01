package com.signify.dao;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.CourseNotAssignedException;
import com.signify.exception.FeePendingException;
import com.signify.exception.NotTeachingExcetion;

public interface ProfessorDAOInterface {

	/**
	 * View students enrolled in the course the professor teaches 
	 * @param id
	 * @return list of student enrolled under professor 
	 * @throws CourseNotAssignedException
	 */
	public List<Student> viewDAOEnrolledStudents(int id)throws CourseNotAssignedException;
	/**
	 * Add grades for the student
	 * @param prof_id
	 * @param student_id
	 * @param grade
	 * @throws CourseNotAssignedException
	 * @throws FeePendingException
	 * @throws NotTeachingExcetion
	 */
	public void addDAOgrades(int prof_id,int student_id,String grade)throws CourseNotAssignedException,FeePendingException,NotTeachingExcetion;
}
