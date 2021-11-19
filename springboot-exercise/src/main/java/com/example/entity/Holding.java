package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holdings")
public class Holding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long holdingId;
	
	@Column(name = "Account Id")
	private long accountId;
	
	@Column(name = "Name")
	private String holdingName;
	
	@Column(name = "Balance")
	private BigDecimal balance;
	
	@Column(name = "Type")
	private String holdingType;
	
	@Column(name = "Quantity")
	private double quantity;

	public long getHoldingId() {
		return holdingId;
	}

	public void setHoldingId(long holdingId) {
		this.holdingId = holdingId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getHoldingName() {
		return holdingName;
	}

	public void setHoldingName(String holdingName) {
		this.holdingName = holdingName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getHoldingType() {
		return holdingType;
	}

	public void setHoldingType(String holdingType) {
		this.holdingType = holdingType;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	

}
