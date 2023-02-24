package com.signify.bean;

public class OfflinePayment extends Payment{
 
	 private int offlineMode; // 0 means cash and 1 means cheque

	public int getOfflineMode() {
		return offlineMode;
	}

	public void setOfflineMode(int offlineMode) {
		this.offlineMode = offlineMode;
	}
}
