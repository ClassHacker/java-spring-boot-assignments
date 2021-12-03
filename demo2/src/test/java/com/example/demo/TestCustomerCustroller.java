package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class TestCustomerCustroller {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean  
	private CustomerService service;
	
	private List<Holding> holdings;
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Test
	public void testPost() throws Exception {
		Customer account = new Customer(111L, 1111L, "Ajay", BigDecimal.valueOf(213456786), holdings);
		String json = om.writeValueAsString(account);
		Mockito.when(service.createCustomer(account)).thenReturn(account);
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.accountId", Matchers.equalTo(account.getAccountId())));
	}
	

}
