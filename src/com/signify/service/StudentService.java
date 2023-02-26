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

import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;

/**
 * @author Naman
 *
 */
public class StudentService implements StudentInterface {

	StudentDAOInterface studentDao = new StudentDAOImplementation();
	public void registerForStudent(String name,String password,String branch,int batch)
	{
		studentDao.registerDAOStudent(name,password,branch, batch);
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
	public void viewCatalog()
	{
		studentDao.viewDAOCatalog();
	}
	public void addCourse(int studid,int cid)
	{
		studentDao.addDAOCourse(studid,cid);
	}
	public void dropCourse(int studid,int cid)
	{
		studentDao.dropDAOCourse(studid,cid);
	}
	public void myCatalog(int studid)
	{
		studentDao.myDAOCatalog(studid);
	}
	public boolean isPaid(int studid, int semester) {
		if(studentDao.isDAOPaid(studid, semester)) {
			return true;
		}
		return false;
	}	
	public void feeCatalog(int studid, int semester,int total_fees[]) {
		studentDao.feeDAOCatalog(studid, semester,total_fees);
	}
	
	public void payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry) {
		studentDao.payDAOFeeOnline(ID,semm,pay_choice,amount,cardType,bankName,cardNumber,cardName,cvv,expiry);
		
	}
	public void payFee(int id,int sem,int pay,int amount)
	{
		studentDao.payDAOFee(id, sem, pay, amount);
	}
}
