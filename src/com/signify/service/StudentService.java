/**
 * 
 */
package com.signify.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.exception.AlreadyRegisteredException;
import com.signify.exception.CourseFilledException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoSemesterRegisteration;
import com.signify.exception.SixRegisteredCoursesException;

/**
 * @author Naman
 *
 */
public class StudentService implements StudentInterface {

	StudentDAOInterface studentDao = new StudentDAOImplementation();
	public int registerForStudent(String name,String password,String branch,int batch)
	{
		return studentDao.registerDAOStudent(name,password,branch, batch);
	}
	public void viewGradeCard()
	{
		System.out.println("Currently no grade cards are available");
	}
	public boolean isVacant(int c1id)
	{
		return studentDao.isDAOVacant(c1id);
	}
	public boolean isSemRegister(int sem,int id)
	{
		return studentDao.isSemDAORegister(sem,id);
	}
	public void semReg(int studid,int sem,String doj,int cid[])
	{
		studentDao.semDAORegister(studid,sem,doj,cid);
	}
	public List<Course> viewCatalog()
	{
		List<Course>courses = new ArrayList<Course>();
		try
		{
			courses = studentDao.viewDAOCatalog();
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public void addCourse(int studid,int cid)
	{
		try
		{
			studentDao.addDAOCourse(studid,cid);
		}
		catch(CourseFilledException ce)
		{
			
		}
		catch(SixRegisteredCoursesException se)
		{
			
		}
		catch(AlreadyRegisteredException ae)
		{
			
		}
		catch(NoSemesterRegisteration ne)
		{
			
		}
	}
	public void dropCourse(int studid,int cid)
	{
		studentDao.dropDAOCourse(studid,cid);
	}
	public List<Course> myCatalog(int studid)
	{
		List<Course>courses = new ArrayList<Course>();  
		try
		{
			courses = studentDao.myDAOCatalog(studid);
		}
		catch(CourseNotFoundException ce)
		{
			
		}
		return courses;
	}
	public boolean isPaid(int studid, int semester) {
		if(studentDao.isDAOPaid(studid, semester)) {
			return true;
		}
		return false;
	}	
	public List<Course> feeCatalog(int studid, int semester,int total_fees[]) {
		List<Course>courses = new ArrayList<Course>();
		try {
			
			courses = studentDao.feeDAOCatalog(studid, semester,total_fees);
		} 
		catch (CourseNotFoundException e) {
			
		}
		return courses;
	}
	
	public void payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry) {
		studentDao.payDAOFeeOnline(ID,semm,pay_choice,amount,cardType,bankName,cardNumber,cardName,cvv,expiry);
		
	}
	public void payFee(int id,int sem,int pay,int amount)
	{
		studentDao.payDAOFee(id, sem, pay, amount);
	}
}
