package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService implements CustomerServicInf {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer createCustomer(Customer c) {
		return customerRepo.save(c);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		Optional<Customer> customerDb = customerRepo.findById(c.getAccountId());
		if (customerDb.isPresent()) {
			Customer cUpdate = customerDb.get();
			cUpdate.setAccountId(c.getAccountId());
			cUpdate.setAccountName(c.getAccountName());
			cUpdate.setProfileId(c.getProfileId());
			cUpdate.setHoldings(c.getHoldings());
			customerRepo.save(cUpdate);
			return cUpdate;
		}
		throw new ResourceNotFoundException("Customer Not Found with id : "+c.getAccountId());
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Optional<Customer> customerDb = customerRepo.findById(customerId);
		if (customerDb.isPresent()) {
			return customerDb.get();
		}
		throw new ResourceNotFoundException("Customer Not Found with id : "+customerId);
	}

	@Override
	public void deleteCustomer(long id) {
		Optional<Customer> customerDb = customerRepo.findById(id);
		if (customerDb.isPresent()) {
			customerRepo.delete(customerDb.get());
		}
		else
			throw new ResourceNotFoundException("Customer Not Found with id : "+id);		
	}
}
