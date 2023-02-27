package com.signify.dao;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.CourseNotAssignedException;
import com.signify.exception.FeePendingException;
import com.signify.exception.NotTeachingExcetion;

public interface ProfessorDAOInterface {

	public List<Student> viewDAOEnrolledStudents(int id)throws CourseNotAssignedException;
	public void addDAOgrades(int prof_id,int student_id,String grade)throws CourseNotAssignedException,FeePendingException,NotTeachingExcetion;
}
