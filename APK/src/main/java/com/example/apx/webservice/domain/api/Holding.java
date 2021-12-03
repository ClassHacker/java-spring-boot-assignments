package com.example.apx.webservice.domain.api;

public class Holding {
	
	   private long holdingId;
	   private String holdingName;
	   private long balance;
	   private String holdingType ;
	   private long quantity;

   public long getHid() {
		return holdingId;
	}

	public void setHid(long hid) {
		this.holdingId = hid;
	}

	public String getHoldingName() {
		return holdingName;
	}

	public void setHoldingName(String holdingName) {
		this.holdingName = holdingName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getHoldingType() {
		return holdingType;
	}

	public void setHoldingType(String holdingType) {
		this.holdingType = holdingType;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


   
	
}


