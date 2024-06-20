package com.tcs.demo3springdatajpa.custservice;

import java.util.List;
import java.util.Optional;

import com.tcs.demo3springdatajpa.user.service.entity.Customer;

public interface CustomerService {
// this is a interface so body is not required
	
	// perform operations here
	
	// create delete etc
	
	Customer customer(Customer customer);
	
	// get customer by id
	
//	Optional<Customer>  getById(String custid);
//or
	Customer getByIdOrThrow(String custid);
	
	
	// retrieve all customers
	
		List<Customer> getAllCustomers();
		
		 // update customer details
	    Customer updateCustomer(String custid, Customer customer);

	    // delete customer by ID
	    void deleteCustomer(String custid);
}
