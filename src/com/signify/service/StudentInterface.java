package com.signify.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.signify.bean.Course;

public interface StudentInterface {

	/**
	 * Register Student with courses and semester
	 * @param name
	 * @param password
	 * @param branch
	 * @param batch
	 * @return whether student is registered or not
	 */
	public int registerForStudent(String name,String password,String branch,int batch);
	/**
	 * View Available Courses
	 * @return list of courses available to choose from
	 */
	public List<Course> viewCatalog();
	/**
	 * Check if course is vacant for registration
	 * @param c1id
	 * @return whether course is available to register in
	 */
	public boolean isVacant(int c1id);
	/**
	 * Check if student is already registered in the sem
	 * @param sem
	 * @param id
	 * @return
	 */
	public boolean isSemRegister(int sem,int id);
	/**
	 * Register student in semester
	 * @param studid
	 * @param sem
	 * @param doj
	 * @param cid
	 */
	public void semReg(int studid,int sem,String doj,int cid[]);
	/**
	 * Add Course for Student to Enroll in
	 * @param studid
	 * @param cid
	 */
	public void addCourse(int studid,int cid);
	/**
	 * Drop added Courses
	 * @param studid
	 * @param cid
	 */
	public void dropCourse(int studid,int cid);
	/**
	 * Show the courses student has enrolled in
	 * @param studid
	 * @return list of courses student has enrolled in
	 */
	public List<Course> myCatalog(int studid);
	/**
	 * Check if fee is paid
	 * @param studid
	 * @param semester
	 * @return if the fee is already paid for the semester
	 */
	public boolean isPaid(int studid, int semester);
	/**
	 * 
	 * @param studid
	 * @param semester
	 * @param total_fees
	 * @return
	 */
	public List<Course> feeCatalog(int studid, int semester,int total_fees[]);
	/**
	 * Display catalog of courses left for payment
	 * @param studid
	 * @param sem
	 * @param mode
	 * @param amt
	 */
	public void payFee(int studid, int sem, int mode, int amt);
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
	public void payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);

}
