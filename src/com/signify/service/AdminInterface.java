package com.signify.service;

import java.sql.ResultSet;
import java.util.List;

import com.signify.bean.*;

public interface AdminInterface {

	/**
	 * Check if student has been approved
	 * @param id
	 * @return if the student has been approved or not
	 */
	public boolean approveStudent(int id);
	/**
	 * View Student left for Approval
	 * @return list of student left for approval
	 */
	public List<Student> viewUnapproveStudents();
	/**
	 * Add course to catalog
	 * @param coursename
	 * @param profid
	 * @return if the course has been added
	 */
	public boolean addCourse(String coursename,int profid);
	/**
	 * Remove Course from Catalog
	 * @param coursename
	 * @return if the course has been removed
	 */
	public boolean removeCourse(String coursename);
	/**
	 * View Available Courses
	 * @return list of courses
	 */
	public List<Course> viewCourses();
	/**
	 * Add New Admin
	 * @param name
	 * @param pass
	 * @return if the admin was added to the database
	 */
	public int addAdmin(String name,String pass);
	/**
	 * Add New Professor
	 * @param name
	 * @param pass
	 * @param depart
	 * @param des
	 * @return if the professor was added
	 */
	public int addProfessor(String name,String pass,String depart,String des);
	/**
	 * Returns the grade card of student
	 * @param studid
	 * @return gradecard of student
	 */
	public List<GradeCard> generateReport(int studid);
}
