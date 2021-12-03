package com.example.apx.webservice.Exception;

public class AccountException extends RuntimeException{

	long accountId;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public AccountException(long accountId) {
		super("No Account found with"+ accountId);
		this.accountId = accountId;
	}
	
	public String getException(long accountId) {
		return "No Account found with"+ accountId;
	}
	
}
