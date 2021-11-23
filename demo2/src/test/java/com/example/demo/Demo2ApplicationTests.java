package com.example.demo;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class Demo2ApplicationTests {
	

	@Autowired
	private CustomerService service;
	
	@MockBean
	CustomerRepository repo;
	List<Holding> holdings;

	@Test
	public void createCustomerTest() { 
		Customer account = new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings);
		when(repo.save(account)).thenReturn(account); 
	    Assertions.assertThat(service.createCustomer(account)).isEqualTo(account); 
	}
	
	@Test
	public void getCustomersTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings)).toList());
		Assertions.assertThat(service.getAllCustomer().size()).isGreaterThan(0);
	}
	
	@Test()
	public void updateCustomerTest() {
		Customer account = new Customer(111L, 1111L, "Rohit", BigDecimal.valueOf(213456786), holdings);
		try {
		service.updateCustomer(account);
		}
		catch (ResourceNotFoundException e){
			Assertions.assertThat(e.getMessage()).isEqualTo("Customer Not Found with id : 111");
		}
	}
	
	@Test
	public void deleteCustomerTest() {
		Customer c = new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings);
		long id = c.getAccountId();
		try {
			service.deleteCustomer(id);
	    }
		catch (ResourceNotFoundException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("Customer Not Found with id : 111");
		}

	}
}