package com.example.demo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private CustomerServicInf customerService;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));	
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){	
		return ResponseEntity.ok().body(customerService.getAllCustomer());
	}
	
	@PostMapping("/customer") public ResponseEntity<Customer> createCustomer(@RequestBody Customer c) {
		  //this.holdings.createHoldings(c.getlistOfHoldings());
		  return ResponseEntity.ok().body(this.customerService.createCustomer(c)); 
	} 
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer c) {
		c.setAccountId(id);
		return ResponseEntity.ok().body(this.customerService.updateCustomer(c)); 
	}
	
	@DeleteMapping("/customers/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.customerService.deleteCustomer(id);
		//return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
		return HttpStatus.OK;
	}
	
	@GetMapping("/healthcheck")
	public HttpStatus healthcheck(){
		return HttpStatus.OK;
	}
}
