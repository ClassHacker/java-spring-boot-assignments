package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class Demo3ApplicationTests {

	@Autowired
	private CustomerService service;

	ObjectMapper om = new ObjectMapper();
	
	Customer account;
	List<Holding> holdings = new LinkedList<Holding>();
	//@MockBean
	File json;
	
	@BeforeAll
	public void setUp() {
		json = new File("data.json");
		account = new Customer(111L, 1111L, "AJay", BigDecimal.valueOf(213456786), holdings);
	}
	@AfterAll
	public void cleanUp() {
		json.delete();
	}

	@Test 
	@Order(1)
	public void createCustomerTest() throws Exception {
		service.createCustomer(account, json);
		assertEquals(account.getAccountId(),
				om.readValue(json,
						new TypeReference<List<Customer>>(){}).get(0).getAccountId());
	}

	@Test
	@Order(2)
	public void getCustomersTest() throws Exception {
		service.getAllCustomer(json);
		assertThat(om.readValue(json,
						new TypeReference<List<Customer>>(){}).size()).isGreaterThan(0);
	}

	@Test()
	@Order(3)
	public void updateCustomerTest() throws Exception {
		Customer account = new Customer(111L, 1000L, "Rohit", BigDecimal.valueOf(987654321), holdings);
		service.updateCustomer(111L, account, json);
		assertEquals(account.getAccountName(),
				om.readValue(new File("data.json"),
						new TypeReference<List<Customer>>(){}).get(0).getAccountName());
	}
		
	@Test
	@Order(4)
	public void deleteCustomerTest() throws Exception {
		long id = account.getAccountId();
		service.deleteCustomer(id, json);
		assertEquals(0,
				om.readValue(new File("data.json"),
						new TypeReference<List<Customer>>(){}).size());

	}
}
