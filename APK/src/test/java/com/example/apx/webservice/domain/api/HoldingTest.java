package com.example.apx.webservice.domain.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoldingTest {

	Holding holding = new Holding();
	@SuppressWarnings("null")
	@BeforeEach
	public void setup() {
		holding.setBalance(55);
		holding.setHid(006);
		holding.setHoldingName("holding name");
		holding.setHoldingType("bond");
		holding.setQuantity(55);
		
	}
	
	@Test
	public void TestSetterGetter() {
		assertEquals(55L, holding.getBalance());
		assertEquals(006, holding.getHid());
		assertEquals("holding name", holding.getHoldingName());
		assertEquals("bond", holding.getHoldingType());
		assertEquals(55,holding.getQuantity());	
		
		 
		
	}

	
}
