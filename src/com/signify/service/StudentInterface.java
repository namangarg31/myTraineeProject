package com.signify.service;

import java.util.HashMap;
import java.util.Map;

public interface StudentInterface {

	
	public void payFee(String mode);
	public void registerForStudent(String name,String password,String branch,int batch);
	public void viewGradeCard();
	public void viewCatalog();
	public void semReg(int studid,int sem,String doj,int c1id,int c2id,int c3id,int c4id,int al1id,int al2id);
	public void addCourse(int studid,int cid);
	public void dropCourse(int studid,int cid);
	public void myCatalog(int studid);
	public boolean isPaid(int studid, int semester);
	public void feeCatalog(int studid, int semester,int total_fees[]);
	public void payFee(int studid, int sem, int mode, int amt);
	public void payFeeOnline(int ID,int semm,int pay_choice,int amount,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry);
}
