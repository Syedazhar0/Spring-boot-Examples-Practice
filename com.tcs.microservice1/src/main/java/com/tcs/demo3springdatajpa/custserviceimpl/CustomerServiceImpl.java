package com.tcs.demo3springdatajpa.custserviceimpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.demo3springdatajpa.config.CustomerRatingClient;
import com.tcs.demo3springdatajpa.config.RestaurantClient;
import com.tcs.demo3springdatajpa.customexception.CustomException;
import com.tcs.demo3springdatajpa.custservice.CustomerService;
import com.tcs.demo3springdatajpa.repository.CustomerRepository;
import com.tcs.demo3springdatajpa.user.service.entity.Customer;
import com.tcs.demo3springdatajpa.user.service.entity.CustomerRating;
import com.tcs.demo3springdatajpa.user.service.entity.Restaurant;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	
	 @Autowired
	    private CustomerRatingClient customerRatingClient;

	    @Autowired
	    private RestaurantClient restaurantClient;
	
	
	 private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Customer customer(Customer customer) {
	// TO GENERATE ID
		String idString=  UUID.randomUUID().toString();
		customer.setCustid(idString);
		return customerRepository.save(customer);
	}
	
	
	

//	@Override
//	public Customer getByIdOrThrow(String custid) {
//	ArrayList<CustomerRating> details = restTemplate.getForObject("http://localhost:1008/api/"+custid, ArrayList.class);
//		logger.info("Data fetched from Rating Service{}",details);
//	    Customer customer = customerRepository.findById(custid)
//	            .orElseThrow(() -> new CustomException("Customer not found with id " + custid));
//	    customer.setRatings(details);
//		return customer;
//	
//	}
	

	
	
	//or
//	@Override
//	public Optional<Customer> getById(String custid) {
//	    return Optional.ofNullable(customerRepository.findById(custid)
//	            .orElseThrow(() -> new CustomException("Customer not found with id " + custid)));
//	}
//	
	
	
	
	
	
	
	// using rest-template to fetch data from different services
//	@Override 
//	public Customer getByIdOrThrow(String custid) {
//        Customer customer = customerRepository.findById(custid)
//                .orElseThrow(() -> new CustomException("Customer not found with id " + custid));
//
//      
//       // if you use arraylist<CustomerRating> insted of customerRating [] you will face issue or exception linked hashmap cannot be cast to class Customer rating
//        // working with url and port number
////        CustomerRating[] listRating = restTemplate.getForObject("http://localhost:1008/api/" + custid, CustomerRating[].class);
//
//     // working with service  name now even if you change port num the service will still work
//        CustomerRating[] listRating = restTemplate.getForObject("http://COM.TCS.MICROSERVICE3-3/api/" + custid, CustomerRating[].class);
//        for (CustomerRating rating : listRating) {
//        	// working with url and port number
////            Restaurant restaurant = restTemplate.getForObject("http://localhost:1007/api/" + rating.getRestauid(), Restaurant.class);
//            
//         // working with service name now even if you change port num the service will still worki
//            Restaurant restaurant = restTemplate.getForObject("http://COM.TCS.MICROSERVICE2-2/api/" + rating.getRestauid(), Restaurant.class);
//            rating.setRestaurant(restaurant);
//        }
//
//        customer.setRatings(Arrays.asList(listRating));
//        logger.info("Data fetched from customer service: {}", listRating);
//
//        return customer;
//    }
	
	
	// fetching data using feign client which follows declarative approach and it is also easiest way to fetch 
	
	@Override
	public Customer getByIdOrThrow(String custid) {
        Customer customer = customerRepository.findById(custid)
                .orElseThrow(() -> new CustomException("Customer not found with id " + custid));

        CustomerRating[] listRating = customerRatingClient.getCustomerRatings(custid);

        for (CustomerRating rating : listRating) {
            Restaurant restaurant = restaurantClient.getRestaurant(rating.getRestauid());
            rating.setRestaurant(restaurant);
        }

        customer.setRatings(Arrays.asList(listRating));
        logger.info("Data fetched from customer service: {}", listRating);

        return customer;
    }
	
	
	
	
	
	
	
	
	
	

	
	@Override
	public List<Customer> getAllCustomers() {
	
//		return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "custname")) this is not working will get to know what is the issue later
		List<Customer> customers = customerRepository.findAll();
//		 customers.sort(Comparator.comparing(Customer::getCustid));
		 customers.sort(Comparator.comparing(Customer::getCustname));
	        return customers;
	        
	        // Customer::getCustname: This is a method reference to the getCustname method of the Customer class. 
	        //It represents a function that takes a Customer object and returns its custname attribute value.
	}

	  @Override
	    public Customer updateCustomer(String custid, Customer customer) {
	        Customer existingCustomer = customerRepository.findById(custid)
	                .orElseThrow(() -> new CustomException("Customer not found with id " + custid));
	        
	        existingCustomer.setCustname(customer.getCustname());
	        existingCustomer.setEmail(customer.getEmail());
	        existingCustomer.setAbout(customer.getAbout());
	       
	        
	        return customerRepository.save(existingCustomer);
	    }
	  
	  
	 @Override
	    public void deleteCustomer(String custid) {
	        Customer customer = customerRepository.findById(custid)
	                .orElseThrow(() -> new CustomException("Customer not found with id " + custid));
	        customerRepository.delete(customer);
	 }
	
	
	
}


