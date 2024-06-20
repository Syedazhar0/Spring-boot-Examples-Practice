package com.tcs.demo3microservice.serviceimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.demo3microservice.entity.Restaurant;
import com.tcs.demo3microservice.exceptions.RestaurantNotFoundException;
import com.tcs.demo3microservice.hotelrepository.RestaurantRepository;
import com.tcs.demo3microservice.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant restaurant(Restaurant restaurant) {
	      String idString = UUID.randomUUID().toString();// generate id automatically
	      restaurant.setRestauid(idString);
		return restaurantRepository.save(restaurant);
	}

	// the below code is also get restaurant by id but though there is is a single restaurant by particular id
			// but you still want to apply list then this is the code format
//	@Override
//	public List<Restaurant> getByid(String restauid) {
//        Restaurant restaurant = restaurantRepository.findById(restauid)
//                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with ID: " + restauid));
//        return Collections.singletonList(restaurant);
//    }

	// the below code is for get resturant by id 
	@Override
	public Restaurant getByid(String restauid) {
	
		return restaurantRepository.findById(restauid).orElseThrow(()->new RestaurantNotFoundException("restaurant not found with given id "+restauid));
	}
//	
	
	@Override
	public List<Restaurant> getAllRestaurants() {
	List<Restaurant> restaurants= restaurantRepository.findAll();
	restaurants.sort(Comparator.comparing(Restaurant::getName));
		return restaurants;
	}
	
	 @Override
	    public Restaurant updateRestaurant(String restauid, Restaurant restaurant) {
	        Restaurant existingRestaurant = restaurantRepository.findById(restauid)
	            .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with given id " + restauid));
	        existingRestaurant.setName(restaurant.getName());
	        existingRestaurant.setLocation(restaurant.getLocation());
	        existingRestaurant.setAbout(restaurant.getAbout());
	        return restaurantRepository.save(existingRestaurant);
	    }

	    @Override
	    public void deleteRestaurant(String restauid) {
	        Restaurant existingRestaurant = restaurantRepository.findById(restauid)
	            .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with given id " + restauid));
	        restaurantRepository.delete(existingRestaurant);
	    }

}
