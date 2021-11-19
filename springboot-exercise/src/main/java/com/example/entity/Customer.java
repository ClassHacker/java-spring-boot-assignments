package com.example.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	
	@Column(name = "Profile Id")
	private long profileId;
	
	@Column(name = "Name")
	private String accountName;
	
	@Column(name = "Balance")
	private BigDecimal totalAccountBalance;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getProfileId() {
		return profileId;
	}
	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public BigDecimal getTotalAccountBalance() {
		return totalAccountBalance;
	}
	public void setTotalAccountBalance(BigDecimal totalAccountBalance) {
		this.totalAccountBalance = totalAccountBalance;
	}
	/*
	@Column(name = "Holdings")
	private ArrayList<Holding> listOfHoldings=new ArrayList<Holding>();
	public ArrayList<Holding> getlistOfHoldings() {
		return listOfHoldings;
	}
	public void setlistOfHoldings(ArrayList<Holding> listOfHoldings) {
		this.listOfHoldings = listOfHoldings;
	}
	*/
}
