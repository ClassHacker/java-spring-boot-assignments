package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Table(name = "customers")
public class Customer {
	
	public Customer(long accountId, long profileId, String accountName, BigDecimal totalAccountBalance, List<Holding> holdings) {
		super();
		this.accountId = accountId;
		this.profileId = profileId;
		this.accountName = accountName;
		this.totalAccountBalance = totalAccountBalance;
		this.holdings = holdings;
	}
	
	public Customer() {
		super();
	}
	@Id
	private long accountId;
	
	@Column(name = "Profile_Id")
	private long profileId;
	
	@Column(name = "Name")
	private String accountName;
	
	@Column(name = "Balance")
	private BigDecimal totalAccountBalance;

	//@OneToOne(cascade = CascadeType.ALL)
	//private Holding listOfHoldings;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "AccountId", referencedColumnName = "accountId",nullable = false)
	private List<Holding> holdings;
	
	
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
	
	public List<Holding> getHoldings() {
		return holdings;
	}
	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}
	public BigDecimal getTotalAccountBalance() {
		return totalAccountBalance;
	}
	public void setTotalAccountBalance(BigDecimal totalAccountBalance) {
		this.totalAccountBalance = totalAccountBalance;
	}
	/*
	public Holding getlistOfHoldings() {
		return listOfHoldings;
	}
	public void setlistOfHoldings(Holding listOfHoldings) {
		this.listOfHoldings = listOfHoldings;
	}
	*/
	
}
