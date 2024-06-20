package com.tcs.demo3microservice.hotelrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.demo3microservice.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

}
