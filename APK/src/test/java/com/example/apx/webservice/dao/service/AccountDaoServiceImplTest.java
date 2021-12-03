package com.example.apx.webservice.dao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.apx.webservice.domain.api.Account;
import com.example.apx.webservice.domain.api.Holding;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountDaoServiceImplTest {

	AccountDaoServiceImpl accountDaoServiceImpl = new AccountDaoServiceImpl();

	Account account = new Account();
	Holding holding = new Holding();
	List<Account> accounts = new ArrayList();
	File file;

	@BeforeEach
	public void setup() {
		Account account = new Account();
		Holding holding = new Holding();
		holding.setBalance(55);
		holding.setHid(006);
		holding.setHoldingName("holding name");
		holding.setHoldingType("bond");
		holding.setQuantity(55);
		List<Holding> holdings = new ArrayList();
		holdings.add(holding);
		account.setAccountName("acc name");
		account.setHolding(holdings);
		account.setProfileId("profile");
		account.setTotalBalance(10000);
		account.setId(005);

		accounts.add(account);
		file = new File("Account.json");
	}

	@AfterEach
	public void teardown() {
		file.delete();
	}

	@Test
	public void testSaveAccount() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, accounts);
		assertEquals(account, accountDaoServiceImpl.saveAccount(account));

	}

	@Test
	public void testUpdateAccount() throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		Account newAcc = new Account();
		newAcc.setAccountName("acc name");
		newAcc.setProfileId("newprofile");
		newAcc.setTotalBalance(10000);
		newAcc.setId(005);
		long id = 005;
		accounts.add(account);
		ObjectMapper mapper = new ObjectMapper();
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, accounts);
		assertEquals(newAcc, accountDaoServiceImpl.updateAccount(newAcc, id));

	}

	@Test
	public void testDeleteAccount() throws StreamReadException, DatabindException, FileNotFoundException, IOException {
		Account newAcc = new Account();
		List<Account> accounts = new ArrayList();
		newAcc.setAccountName("acc name");
		newAcc.setProfileId("newprofile");
		newAcc.setTotalBalance(10000);
		newAcc.setId(007);
		accounts.add(newAcc);
		long id = 007;
		ObjectMapper mapper = new ObjectMapper();
		FileWriter writer = new FileWriter("AccountProfile.json");
		mapper.writeValue(writer, accounts);

		accountDaoServiceImpl.deleteAccount(id);
		Account[] Accountarray = mapper.readValue(new FileReader("AccountProfile.json"), Account[].class);
		assertEquals(null, Accountarray[0]);

	}

}
