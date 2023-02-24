package com.signify.bean;

public class OnlinePayment extends Payment{

	private String bankname;
	private int onlineMode; // 0 means card and 1 means netbanking
	public int getOnlineMode() {
		return onlineMode;
	}
	public void setOnlineMode(int onlineMode) {
		this.onlineMode = onlineMode;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
}
