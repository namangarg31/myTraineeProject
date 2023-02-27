package com.signify.dao;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.exception.AlreadyRegisteredException;
import com.signify.exception.CourseFilledException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoSemesterRegisteration;
import com.signify.exception.SixRegisteredCoursesException;

public interface StudentDAOInterface {


	 public int registerDAOStudent(String name,String password,String branch,int batch);
	 public List<Course> viewDAOCatalog()throws CourseNotFoundException;
	 public boolean isDAOVacant(int cid);
	 public void semDAORegister(int studid,int sem,String doj,int cid[]);
	 public boolean isSemDAORegister(int sem,int id);
	 public void addDAOCourse(int studid,int cid)throws CourseFilledException,SixRegisteredCoursesException,AlreadyRegisteredException,NoSemesterRegisteration;
	 public void dropDAOCourse(int studid,int cid);
	 public List<Course> myDAOCatalog(int studid)throws CourseNotFoundException;
	 public boolean isDAOPaid(int studid, int semester);
	 public List<Course> feeDAOCatalog(int studid,int sem,int total_fees[]) throws CourseNotFoundException;
	 public void payDAOFee(int studid, int sem, int mode, int amt);
	 public void payDAOFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
}
