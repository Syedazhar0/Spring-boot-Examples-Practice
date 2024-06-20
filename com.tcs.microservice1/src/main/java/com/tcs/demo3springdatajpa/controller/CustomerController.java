package com.tcs.demo3springdatajpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.demo3springdatajpa.custservice.CustomerService;
import com.tcs.demo3springdatajpa.custserviceimpl.CustomerServiceImpl;
import com.tcs.demo3springdatajpa.user.service.entity.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	
 private  Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	//save customer details
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		Customer  customer2 = customerService.customer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer2);
	}
	
	//get customer
	@CircuitBreaker(name = "ratingService", fallbackMethod = "ratingFallback")
	@GetMapping("/{custid}")
	public ResponseEntity<Customer>getById(@PathVariable String custid){
		Customer  customer2 =customerService.getByIdOrThrow(custid);
		return ResponseEntity.ok(customer2);
	}
	
	// Circuit breakers help maintain system stability by 
	//stopping requests to a failing service, preventing further issues
	
	 // Fallback method to be executed if the circuit is open
    public ResponseEntity<Customer> fallback(String custid, Exception e) {
     // optional
    	logger.info("Sorry for inconvenience we are unable to proceed further process as the service is down",e.getMessage());
    	 // Handle fallback logic (e.g., return a default response)
      Customer customer= Customer.builder()
    		  .custname("hahaha")
    		  .email("hahaha@gmail.com")
    		  .about("bye bye bye this unknown user getting cuz the service is down").build();
    	
    	return ResponseEntity.ok(customer);
    }

	
	
	
	
	
	
	//get customer with ratings in console
	
	// the below code is to check weather the ratings are fetching properly by custid
	// here i used logger to check the result in spring console and to fetch the rating
	//from rating service i used rest template statically as i provided id directly
	//just to check this you can use in service  and controller better to use in service so
	// commenting this code and writing the code into serviceimpl with little modifications
	
//	 @GetMapping("/{custid}")
//	    public ResponseEntity<Customer> getById(@PathVariable String custid) {
//	        Customer customer = customerService.getByIdOrThrow(custid);
//
//	        // Assuming ArrayList<CustomerRating> is the expected response from the API
//	        ArrayList<CustomerRating> details = restTemplate.getForObject(
//	            "http://localhost:1008/api/a50c587a-81e5-4f17-8d7a-3b5d3beb64c9",
//	            ArrayList.class
//	        );
//
//	        // Log details to console
//	        logger.info("Details retrieved from the API: {}", details);
//
//	        return ResponseEntity.ok(customer);
//	    }
	
	
	
	// get all customers details
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customer = customerService.getAllCustomers();
		return ResponseEntity.ok(customer);
	}
	
	
	
	
	
	
	  // Update customer details
    @PutMapping("/update/{custid}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String custid, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(custid, customer);
        return ResponseEntity.ok(updatedCustomer);
    }
    
    
    
    

    // Delete customer by ID
    @DeleteMapping("/delete/{custid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String custid) {
        customerService.deleteCustomer(custid);
        return ResponseEntity.noContent().build();
    }
	
}
