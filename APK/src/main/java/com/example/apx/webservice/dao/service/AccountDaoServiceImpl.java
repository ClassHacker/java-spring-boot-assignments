package com.example.apx.webservice.dao.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apx.webservice.domain.api.Account;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountDaoServiceImpl implements AccountDaoService{
	


	

	@Override
	public Account saveAccount(Account account) throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		List<Account> Accounts = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Account[] Accountarray =	mapper.readValue(new FileReader("AccountProfile.json"), Account[].class);
		for(int i = 0; i<Accountarray.length; i++) {
			if(Accountarray[i].getProfileId()==account.getProfileId()){
				return null;
			}
		}
		Collections.addAll(Accounts, Accountarray);
		Accounts.add(account);
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, Accounts);
		return account;
	}

	@Override
	public List<Account> getAllAccounts() throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		List<Account> Accounts = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Account[] Accountarray =	mapper.readValue(new FileReader("AccountProfile.json"), Account[].class);
		Collections.addAll(Accounts, Accountarray);
		
		return Accounts;
	}
	

	@Override
	public Account updateAccount(Account account, long id) throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		List<Account> Accounts = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Account[] Accountarray =	mapper.readValue(new FileReader("AccountProfile.json"), Account[].class);
		for(int i = 0; i<Accountarray.length; i++) {
			if(Accountarray[i].getId()==id){
				Accountarray[i]=account;
			}
		}
		Collections.addAll(Accounts, Accountarray);
		Accounts.add(account);
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, Accounts);
		return account;
		}



	@Override
	public void deleteAccount(long id) throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Account[] Accountarray =	mapper.readValue(new FileReader("AccountProfile.json"), Account[].class);
		for(int i = 0; i<Accountarray.length; i++) {
			if(Accountarray[i].getId()==id){
				Accountarray[i]=null;
			}
		}
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, Accountarray);
		
		}
		
	}


