
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestException {

	@Autowired
	private CustomerService service;

	List<Holding> holdings = new LinkedList<Holding>();

	@Test
	public void testExceptionMessage() throws Exception {

		File json = new File("data.json");
		Customer account = new Customer(111L, 1111L, "Rohit", BigDecimal.valueOf(213456786), holdings);
		service.createCustomer(account, json);
		try {
			service.updateCustomer(101, account, json);
		} catch (ResourceNotFoundException e) {
			assertThat(e.getMessage()).isEqualTo("Customer Not Found having id : 101");
		}
		json.delete();
	}
}
