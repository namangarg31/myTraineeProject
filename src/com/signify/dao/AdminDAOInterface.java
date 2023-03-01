package com.signify.dao;

import java.sql.ResultSet;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.GradeCard;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.StudentNotFoundForApprovalException;

public interface AdminDAOInterface {
	
	/**
	 * Add a professor
	 * @param name
	 * @param pass
	 * @param department
	 * @param designation
	 * @return professor id
	 */
	public int addDAOProfessor(String name,String pass,String depart,String des);
	/**
	 * List the student left for approval
	 * @return list of students that have not been approved
	 */
	public List<Student> viewDAOUnapprove();
	/**
	 * Approve student for registration
	 * @param Student id
	 * @throws StudentNotFoundForApprovalException
	 */
	public void approveDAOStudent(int id)throws StudentNotFoundForApprovalException;
	/**
	 * Add a course to the catalog
	 * @param coursename
	 * @param profid
	 * @throws ProfessorNotFoundException
	 */
    public void addDAOCourse(String coursename,int profid)throws ProfessorNotFoundException;
    /**
     * Remove a course from the catalog
     * @param coursename
     * @throws CourseNotFoundException
     */
    public void removeDAOCourse(String coursename)throws CourseNotFoundException;
    /**
     * View Course Catalog
     * @return list of courses 
     * @throws CourseNotFoundException
     */
    public List<Course> viewDAOCourses()throws CourseNotFoundException;
    /**
     * Add another admin
     * @param name
     * @param password
     * @return adding another admin
     */
    public int addDAOAdmin(String name,String pass);
    /**
     * Generate Report Card of the Student
     * @param studid
     * @return grade card of the student
     */
    public List<GradeCard> generateDAOReport(int studid);
}

