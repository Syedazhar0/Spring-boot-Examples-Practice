//package com.tcs.demo3springdatajpa.config;
//
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class myConfiguration {
//
//	//@LoadBalanced  LoadBalanced in Spring Cloud evenly spreads requests across multiple instances of a service to ensure better performance and reliability in a system.
//  //In a food delivery app, @LoadBalanced in 
//	//Spring Cloud evenly distributes requests for restaurant data across servers, preventing overload and ensuring reliable, fast service. 
//	
//	@LoadBalanced
//	@Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//}
