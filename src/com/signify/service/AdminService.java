/**
 * 
 */
package com.signify.service;

import java.util.*;

import com.signify.bean.*;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;

/**
 * @author asus
 *
 */
public class AdminService implements AdminInterface{
	
	AdminDAOInterface ad = new AdminDAOImplementation();
	public boolean viewUnapproveStudents()
	{
		return ad.viewDAOUnapprove();
	}
	public void approveStudent(int id) {
	
		ad.approveDAOStudent(id); 
	}
	public void addAdmin(String name,String pass) 
	{
		ad.addDAOAdmin(name,pass);
	}
	public void viewInfo(int id,int val)
	{
		ad.editDAOInfo(id,val);
	}
	public void addCourse(String coursename,int profid)
	{
		ad.addDAOCourse(coursename,profid);
	}
	public void removeCourse(String coursename)
	{
		ad.removeDAOCourse(coursename);
	}
	public void viewCourses()
	{
		ad.viewDAOCourses();
	}
	public void addProfessor(String name,String pass,String depart,String des)
	{
		ad.addDAOProfessor(name,pass,depart,des);
	}
	public void generateReport(int studid)
	{
		ad.generateDAOReport(studid);
	}
}