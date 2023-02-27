package com.signify.service;

import java.sql.ResultSet;
import java.util.List;

import com.signify.bean.*;

public interface AdminInterface {

	public boolean approveStudent(int id);
	public List<Student> viewUnapproveStudents();
	public boolean addCourse(String coursename,int profid);
	public boolean removeCourse(String coursename);
	public List<Course> viewCourses();
	public int addAdmin(String name,String pass);
	public int addProfessor(String name,String pass,String depart,String des);
	public List<GradeCard> generateReport(int studid);
}
