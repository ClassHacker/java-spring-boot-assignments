package com.example.demo;

import java.util.List;

public interface CustomerServicInf {
	
	Customer createCustomer(Customer c);
	Customer updateCustomer(Customer c);
	List<Customer> getAllCustomer();
	Customer getCustomerById(long customerId);
	void deleteCustomer(long id); 
	

}
