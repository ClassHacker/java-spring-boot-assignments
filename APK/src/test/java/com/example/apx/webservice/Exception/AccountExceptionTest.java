package com.example.apx.webservice.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountExceptionTest {
	
	
	AccountException accountException = new AccountException(55);
	
	@BeforeEach
	public void setup() {
		accountException.setAccountId(55);
		
	}
	
@Test
public void testgetterandsetter() {
	assertEquals(55, accountException.getAccountId());
	assertEquals("No Account found with55",accountException.getMessage());
}
	
}
