package com.tcs.demo3microservice.service;

import java.util.List;
import com.tcs.demo3microservice.entity.Restaurant;

public interface RestaurantService {

	//save 
	Restaurant restaurant(Restaurant restaurant);
	
	
	//get by id
	
	// the below code is also get restaurant by id but though there is is a single restaurant by particular id
		// but you still want to apply list then this is the code format
//	List<Restaurant> getByid(String restauid);
	
	
	// the below code is for get resturant by id 
	Restaurant getByid(String restauid);
	
	// list of restaurants
	
	List<Restaurant> getAllRestaurants();
	
	
	 // Update restaurant
    Restaurant updateRestaurant(String restauid, Restaurant restaurant);

    // Delete restaurant
    void deleteRestaurant(String restauid);
}
