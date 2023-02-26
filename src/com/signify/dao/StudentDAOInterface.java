package com.signify.dao;

import com.signify.bean.Student;

public interface StudentDAOInterface {


	 public void registerDAOStudent(String name,String password,String branch,int batch);
	 public void viewDAOCourses();
	 public void viewDAOInfo(int id);
	 public void viewDAOCatalog();
	 public boolean isDAOVacant(int cid);
	 public void semDAORegister(int studid,int sem,String doj,int cid[]);
	 public boolean isSemDAORegister(int sem,int id);
	 public void addDAOCourse(int studid,int cid);
	 public void dropDAOCourse(int studid,int cid);
	 public void myDAOCatalog(int studid);
	 public boolean isDAOPaid(int studid, int semester);
	 public void feeDAOCatalog(int studid,int sem,int total_fees[]);
	 public void payDAOFee(int studid, int sem, int mode, int amt);
	 public void payDAOFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
}
