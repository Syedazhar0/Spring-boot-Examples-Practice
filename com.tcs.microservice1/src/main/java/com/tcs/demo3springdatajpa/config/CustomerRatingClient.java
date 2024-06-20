package com.tcs.demo3springdatajpa.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

import com.tcs.demo3springdatajpa.user.service.entity.CustomerRating;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//use this @RibbonClient when u working with fiegn clilent else you can use
//@loadbalanced the dependencies are different and you need to modify the code
@RibbonClient(name = "COM.TCS.MICROSERVICE3-3")
@FeignClient(name = "COM.TCS.MICROSERVICE3-3")
//, url = "http://localhost:1008/api"
public interface CustomerRatingClient {

    @GetMapping("api/{custid}")
    CustomerRating[] getCustomerRatings(@PathVariable("custid") String custid);
}