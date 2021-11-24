
package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class Demo3ApplicationTests {

	@Autowired
	private CustomerService service;

	ObjectMapper om = new ObjectMapper();
	
	Customer account;
	List<Holding> holdings = new LinkedList<Holding>();
	File json;
	
	@BeforeEach
	public void setUp() {
		json = new File("data.json");
		account = new Customer(111L, 1111L, "AJay", BigDecimal.valueOf(213456786), holdings);
	}

	@Test 
	public void createCustomerTest() throws Exception {
		service.createCustomer(account, json);
		//om.writeValue(json, account);
		assertEquals(account.getAccountId(),
				om.readValue(new File("data.json"),
						new TypeReference<List<Customer>>(){}).get(0).getAccountId());
	}

	/*@Test
	public void getCustomersTest() {
		when(repo.findAll()).thenReturn(
				Stream.of(new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings)).toList());
		Assertions.assertThat(service.getAllCustomer().size()).isGreaterThan(0);
	}

	@Test()
	public void updateCustomerTest() {
		Customer account = new Customer(111L, 1111L, "Rohit", BigDecimal.valueOf(213456786), holdings);
		try {
			service.updateCustomer(account);
		} catch (ResourceNotFoundException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("Customer Not Found with id : 111");
		}
	}

	@Test
	public void deleteCustomerTest() {
		Customer c = new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings);
		long id = c.getAccountId();
		try {
			service.deleteCustomer(id);
		} catch (ResourceNotFoundException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("Customer Not Found with id : 111");
		}

	}*/
}
