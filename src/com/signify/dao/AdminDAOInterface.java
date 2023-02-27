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
	
	public int addDAOProfessor(String name,String pass,String depart,String des);
	public List<Student> viewDAOUnapprove();
	public void approveDAOStudent(int id)throws StudentNotFoundForApprovalException;
    public void addDAOCourse(String coursename,int profid)throws ProfessorNotFoundException;
    public void removeDAOCourse(String coursename)throws CourseNotFoundException;
    public List<Course> viewDAOCourses()throws CourseNotFoundException;
    public int addDAOAdmin(String name,String pass);
    public List<GradeCard> generateDAOReport(int studid);
}

