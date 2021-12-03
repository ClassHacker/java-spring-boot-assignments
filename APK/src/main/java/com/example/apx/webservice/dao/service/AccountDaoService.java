package com.example.apx.webservice.dao.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.transaction.SystemException;

import com.example.apx.webservice.domain.api.Account;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;


public interface AccountDaoService {
	
	
	Account saveAccount(Account account) throws StreamReadException, DatabindException, FileNotFoundException, IOException;
	
	List<Account> getAllAccounts() throws StreamReadException, DatabindException, FileNotFoundException, IOException;
	
	Account updateAccount(Account account, long id) throws StreamReadException, DatabindException, FileNotFoundException, IOException;
	
	void deleteAccount(long id) throws StreamReadException, DatabindException, FileNotFoundException, IOException;


}
