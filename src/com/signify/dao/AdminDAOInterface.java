package com.signify.dao;

import com.signify.bean.Professor;

public interface AdminDAOInterface {
	
	public void addDAOProfessor(String name,String pass,String depart,String des);
	public void viewDAOStudent();
	public boolean viewDAOUnapprove();
	public void approveDAOStudent(int id);
	public void viewDAOInfo(int id);
	public void editDAOInfo(int id,int parameter);
    public void addDAOCourse(String coursename,int profid);
    public void removeDAOCourse(String coursename);
    public void viewDAOCourses();
    public void addDAOAdmin(String name,String pass);
    public void generateDAOReport(int studid);
}

