package com.example.demo;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

	@Autowired
	private CustomerServicInf customerService;

	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer() throws Exception{
		File json = new File("data.json");
		return ResponseEntity.ok().body(customerService.getAllCustomer(json));
	}
	
	@PostMapping("/customer") public ResponseEntity<Customer> createCustomer(@RequestBody Customer c) throws Exception {
		File json = new File("data.json");
		return ResponseEntity.ok().body(customerService.createCustomer(c, json)); 
	} 
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer c) {
		File json = new File("data.json");
		return ResponseEntity.ok().body(customerService.updateCustomer(id, c, json)); 
	}
	
	@DeleteMapping("/customers/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		File json = new File("data.json");
		return this.customerService.deleteCustomer(id,json);
	}
	
	@GetMapping("/healthcheck")
	public HttpStatus healthcheck() throws Exception{
		return HttpStatus.OK;
	}
}
