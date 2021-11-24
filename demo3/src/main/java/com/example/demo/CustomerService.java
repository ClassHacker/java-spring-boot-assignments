package com.example.demo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class CustomerService implements CustomerServicInf {
	
	@Override
	public Customer createCustomer(Customer c, File file) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Customer> customers;
		try {
			customers = objectMapper.readValue(new File("data.json"), new TypeReference<List<Customer>>(){});
		}
		catch(Exception e) { 
			customers = new LinkedList<>();
		}
		
		for(int i=0; i<customers.size(); i++)
			if(customers.get(i).getAccountId()== c.getAccountId())
		    {
			System.out.println("Account already present with id : "+c.getAccountId());
			return null;
		    }
		customers.add(c);
		objectMapper.writeValue(new File("data.json"), customers);
		System.out.println("Created an account having id :"+c.getAccountId());
		return c; 
	}

	@Override
	public Customer updateCustomer(long id, Customer c, File file) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Customer> customers = null;
		Customer updateThis = null;
		try {
			customers = objectMapper.readValue(new File("data.json"), new TypeReference<List<Customer>>(){});
			for (int i=0; i<customers.size(); i++)
			{
				updateThis = customers.get(i);
				if(updateThis.getAccountId()==id)
				{
					updateThis.setAccountName(c.getAccountName());
					updateThis.setProfileId(c.getProfileId());
					updateThis.setTotalAccountBalance(c.getTotalAccountBalance());
					updateThis.setHoldings(c.getHoldings());
					System.out.println("Updated account details having id : "+ id);
					break;
				}
				updateThis = null;
			}
			objectMapper.writeValue(new File("data.json"), customers);
			if (updateThis == null)
			{
				System.out.println("No account found with id : "+id);
				throw new ResourceNotFoundException("Customer Not Found having id : "+c.getAccountId());
			}
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Customer Not Found having id : "+c.getAccountId());
		}
		return updateThis;
	}
	
	@Override
	public List<Customer> getAllCustomer(File file) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Customer> customers = new LinkedList<>();
		try {
		customers = objectMapper.readValue(new File("data.json"), new TypeReference<List<Customer>>(){});
		System.out.println("Fetched data of follwing accounts having ids :");
		for (int i=0; i<customers.size(); i++)
			System.out.println(customers.get(i).getAccountId());
		}
		catch(Exception e) {
			System.out.println("No Accounts created yet");
		}
		return customers;
	}

	@Override
	public HttpStatus deleteCustomer(long id, File file) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Customer> customers = null;
		Customer deletedAcc = null;
		List<Customer> remaining = new LinkedList<>();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		try {
			customers = objectMapper.readValue(file, new TypeReference<List<Customer>>(){});
			for (int i=0; i<customers.size(); i++)
			{
				Customer c = customers.get(i);
				if(c.getAccountId()!=id)
					remaining.add(c);
				else
					deletedAcc = c;
			}
			objectMapper.writeValue(file, remaining);
			if (deletedAcc != null) {
				status = HttpStatus.OK;
				System.out.println("Account deleted having id : "+id);
			}
			else
				System.out.println("Account Not Found having id : "+id);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Account Not Found having id : "+id);		
		}
		return status;
	}
}
