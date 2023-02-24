package com.signify.service;

import com.signify.bean.*;

public interface AdminInterface {

	public void assignCourse();
	public void approveStudent(int id);
	public void viewInfo(int id,int val);
	public void editUser(int id,int val);
	public boolean viewUnapproveStudents();
	public void addCourse(String coursename,int profid);
	public void removeCourse(String coursename);
	public void viewCourses();
	public void addAdmin(String name,String pass);
	public void addProfessor(String name,String pass,String depart,String des);
	public void generateReport(int studid);
}
