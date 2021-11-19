package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerServicInf {
	
	Customer createCustomer(Customer c);
	Customer updateCustomer(Customer c);
	List<Customer> getAllCustomer();
	Customer getCustomerById(long customerId);
	void deleteCustomer(long id); 
	

}
