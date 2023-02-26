package com.signify.service;

import java.util.HashMap;
import java.util.Map;

public interface StudentInterface {

	
	
	public void viewGradeCard();
	public void viewCatalog();
	public boolean isVacant(int c1id);
	public boolean isSemRegister(int sem,int id);
	public void semReg(int studid,int sem,String doj,int cid[]);
	public void addCourse(int studid,int cid);
	public void dropCourse(int studid,int cid);
	public void myCatalog(int studid);
	public boolean isPaid(int studid, int semester);
	public void feeCatalog(int studid, int semester,int total_fees[]);
	public void payFee(int studid, int sem, int mode, int amt);
	public void payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
	public void registerForStudent(String name,String password,String branch,int batch);
}
