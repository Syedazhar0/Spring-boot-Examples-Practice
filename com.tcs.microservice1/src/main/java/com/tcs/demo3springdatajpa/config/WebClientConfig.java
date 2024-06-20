//package com.tcs.demo3springdatajpa.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import com.tcs.demo3springdatajpa.user.service.entity.CustomerRating;
//
//
//
//@Configuration
//public class WebClientConfig {
//
//    @Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }
//
//    @Bean
//    public CustomerRating customerRatingClient(WebClient.Builder webClientBuilder) {
//        return new CustomerRating(webClientBuilder.build());
//    }
//
//    @Bean
//    public RestaurantClient restaurantClient(WebClient.Builder webClientBuilder) {
//        return new RestaurantClient(webClientBuilder.build());
//    }
//}
