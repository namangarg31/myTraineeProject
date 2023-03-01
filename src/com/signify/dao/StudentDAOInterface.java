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

	/**
	 * Register Student with courses and semester
	 * @param name
	 * @param password
	 * @param branch
	 * @param batch
	 * @return whether student is registered or not
	 */
	 public int registerDAOStudent(String name,String password,String branch,int batch);
	 /**
	  * View Available Courses
	  * @return list of courses available to choose from
	  * @throws CourseNotFoundException
	  */
	 public List<Course> viewDAOCatalog()throws CourseNotFoundException;
	 /**
	  * Check if course is vacant for registration
	  * @param cid courseid
	  * @return whether course is available to register in
	  */
	 public boolean isDAOVacant(int cid);
	 /**
	  * Register student in semester
	  * @param studid
	  * @param sem
	  * @param doj
	  * @param cid
	  */
	 public void semDAORegister(int studid,int sem,String doj,int cid[]);
	 /**
	  * Check if student is already registered in the sem
	  * @param sem
	  * @param id
	  * @return if the student is registered in the given semester
	  */
	 public boolean isSemDAORegister(int sem,int id);
	 /**
	  * Add Course for Student to Enroll in 
	  * @param studid
	  * @param cid
	  * @throws CourseFilledException
	  * @throws SixRegisteredCoursesException
	  * @throws AlreadyRegisteredException
	  * @throws NoSemesterRegisteration
	  */
	 public void addDAOCourse(int studid,int cid)throws CourseFilledException,SixRegisteredCoursesException,AlreadyRegisteredException,NoSemesterRegisteration;
	 /**
	  * Drop added Courses
	  * @param studid
	  * @param cid
	  */
	 public void dropDAOCourse(int studid,int cid);
	 /**
	  * Show the courses student has enrolled in
	  * @param studid
	  * @return list of courses student has enrolled in
	  * @throws CourseNotFoundException
	  */
	 public List<Course> myDAOCatalog(int studid)throws CourseNotFoundException;
	 /**
	  * Check if fee is paid
	  * @param studid
	  * @param semester
	  * @return if the fee is already paid for the semester
	  */
	 public boolean isDAOPaid(int studid, int semester);
	 /**
	  * Display catalog of courses left for payment
	  * @param studid
	  * @param sem
	  * @param total_fees
	  * @return courses that haven't been paid for
	  * @throws CourseNotFoundException
	  */
	 public List<Course> feeDAOCatalog(int studid,int sem,int total_fees[]) throws CourseNotFoundException;
	 /**
	  * Pay the fee
	  * @param studid
	  * @param sem
	  * @param mode
	  * @param amt
	  */
	 public void payDAOFee(int studid, int sem, int mode, int amt);
	 /**
	  * Pay Fee with Online option
	  * @param ID
	  * @param semm
	  * @param pay_choice
	  * @param amount
	  * @param cardType
	  * @param bankName
	  * @param cardNumber
	  * @param cardName
	  * @param cvv
	  * @param expiry
	  */
	 public void payDAOFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
}
