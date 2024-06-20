package com.tcs.demo3springdatajpa.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.demo3springdatajpa.user.service.entity.Restaurant;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

//use this @RibbonClient when u working with fiegn clilent else you can use
//@loadbalanced the dependencies are different and you need to modify the code
@RibbonClient(name = "COM.TCS.MICROSERVICE2-2")
@FeignClient(name = "COM.TCS.MICROSERVICE2-2")
//, url = "http://localhost:1007/api"
public interface RestaurantClient {

    @GetMapping("api/{restauid}")
    Restaurant getRestaurant(@PathVariable("restauid") String restauid);
}
