package com.example.apx.webservice.domain.api;

import java.util.ArrayList;
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


public class Account {
	private long AccountId;
	private String accountName;
	private String profileId;
	private int totalBalance;
	List<Holding> holding = new ArrayList<>();

	public long getId() {
		return AccountId;
	}

	public void setId(long AccountId) {
		this.AccountId = AccountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public int getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}

	public List<Holding> getHolding() {
		return holding;
	}

	public void setHolding(List<Holding> holding) {
		this.holding = holding;
	}
}
