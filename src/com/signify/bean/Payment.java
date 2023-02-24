package com.signify.bean;

public class Payment {
	private int Student_ID;
	private int reference_ID;
	private float amount;
	private boolean status;
	private int mode;
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public int getReference_ID() {
		return reference_ID;
	}
	public void setReference_ID(int reference_ID) {
		this.reference_ID = reference_ID;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}