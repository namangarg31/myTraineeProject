/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import com.signify.bean.*;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.StudentNotFoundForApprovalException;

/**
 * @author asus
 *
 */
public class AdminService implements AdminInterface{
	
	AdminDAOInterface ad = new AdminDAOImplementation();
	public List<Student> viewUnapproveStudents()
	{
		return ad.viewDAOUnapprove();
	}
	public boolean approveStudent(int id) {
	
		try
		{
			ad.approveDAOStudent(id); 
			return true;
		}
		catch(StudentNotFoundForApprovalException se)
		{
			return false;
		}
	}
	public int addAdmin(String name,String pass) 
	{
		return ad.addDAOAdmin(name,pass);
	}
	public boolean addCourse(String coursename,int profid)
	{
		try
		{
			ad.addDAOCourse(coursename,profid);
			return true;
		}
		catch(ProfessorNotFoundException pe)
		{
			return false;
		}
	}
	public boolean removeCourse(String coursename)
	{
		try
		{
			ad.removeDAOCourse(coursename);
			return true;
		}
		catch(CourseNotFoundException ce)
		{
			return false;
		}
	}
	public List<Course> viewCourses()
	{
		List<Course>courses = null; 
		try
		{
			courses = ad.viewDAOCourses();
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public int addProfessor(String name,String pass,String depart,String des)
	{
		return ad.addDAOProfessor(name,pass,depart,des);
	}
	public List<GradeCard> generateReport(int studid)
	{
		return ad.generateDAOReport(studid);
	}
}