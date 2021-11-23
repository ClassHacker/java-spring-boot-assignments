package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class TestException {
	
	@Autowired
	private CustomerService service = new CustomerService();
	
	@MockBean
	CustomerRepository repo;
	List<Holding> holdings = new LinkedList<Holding>();
	
	@Test
	public void testExceptionMessage() {
	  Customer account = new Customer(111L, 1111L, "Rohit", BigDecimal.valueOf(213456786), holdings);
	  service.createCustomer(account);
	  try {
	   service.updateCustomer(account);
	  } catch (ResourceNotFoundException e ) {
	    assertThat(e.getMessage(), is("Customer Not Found with id : 111"));
	  }
	}
}
