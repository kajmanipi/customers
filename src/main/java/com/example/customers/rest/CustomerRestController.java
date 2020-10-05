package com.example.customers.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.customers.entity.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "This is my Customer Controller")
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private List<Customer> customerList;
	

	
	@PostConstruct
	public void loadData() {
	
		customerList = new ArrayList<>();
		
		customerList.add(new Customer("Poornima", "Patel"));
		customerList.add(new Customer("Mario", "Rossi"));
		customerList.add(new Customer("Mary", "Smith"));
	}



	@ApiOperation(value = "This will get a list of customers.", notes = "These are some notes about the API.")
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
			
		return customerList;
	}
	


	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		return customerList.get(customerId);
		
	}


}









