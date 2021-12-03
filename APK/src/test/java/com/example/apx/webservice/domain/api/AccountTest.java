package com.example.apx.webservice.domain.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
	
	Account account = new Account();
	Holding holding = new Holding();
	@SuppressWarnings("null")
	@BeforeEach
	public void setup() {
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
		
	}
	
	@Test
	public void TestSetterGetter() {
		assertEquals(55L, account.holding.get(0).getBalance());
		assertEquals(006, account.holding.get(0).getHid());
		assertEquals("holding name", account.holding.get(0).getHoldingName());
		assertEquals("bond", account.holding.get(0).getHoldingType());
		assertEquals(55, account.holding.get(0).getQuantity());
		assertEquals("acc name", account.getAccountName());
		assertEquals("profile", account.getProfileId());
		assertEquals(10000, account.getTotalBalance());
		
		
		
		
		
		
		 
		
	}

	

}
