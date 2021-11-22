package com.example.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repo;
	
	List<Holding> holdings;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void createCustomerTest() {
		
		Customer c = new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings);
		repo.save(c);
		Assertions.assertThat(c.getAccountId()).isEqualTo(111);
	}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	public void getCustomersTest() {
		List<Customer> customer = repo.findAll();
		Assertions.assertThat(customer.size()).isGreaterThan(0);
	}

	@Test
	@Order(3)
	@Rollback(value=false)
	public void updateCustomerTest() {
		Customer c = repo.getById(111L);
		c.setAccountName("Rohit");
		Customer updatedC = repo.save(c);
		Assertions.assertThat(updatedC.getAccountName()).isEqualTo("Rohit");
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void deleteCustomerTest() {
		repo.deleteById(111L);
		List<Customer> customers = repo.findAll();
		Assertions.assertThat(customers.size()).isEqualTo(0);
	}
	
}
