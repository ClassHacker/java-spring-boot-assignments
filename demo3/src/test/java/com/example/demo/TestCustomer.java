package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCustomer {
	
	Customer account = new Customer ();
	List<Holding> holdings = new ArrayList<Holding>();

	@BeforeEach
	public void setUp() {
		account.setAccountId(101);
		account.setProfileId(10101);
		account.setTotalAccountBalance(BigDecimal.valueOf(987654321));
		account.setAccountName("Ajay");
		account.setHoldings(holdings);
	}
	
	@Test
	public void test_getterSetter() {
		assertEquals(101, account.getAccountId());
		assertEquals(10101, account.getProfileId());
		assertEquals("Ajay", account.getAccountName());
		assertEquals(BigDecimal.valueOf(987654321), account.getTotalAccountBalance());
		assertEquals(holdings, account.getHoldings());
	}
	
}
