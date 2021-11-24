package com.example.demo;

import java.io.File;
import java.util.List;

import org.springframework.http.HttpStatus;

public interface CustomerServicInf {

	HttpStatus deleteCustomer(long id, File file);
	List<Customer> getAllCustomer(File file);
	Customer createCustomer(Customer c, File file) throws Exception;
	Customer updateCustomer(long id, Customer c, File file); 

}
