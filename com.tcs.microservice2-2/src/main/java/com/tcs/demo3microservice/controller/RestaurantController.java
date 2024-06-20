package com.tcs.demo3microservice.controller;

import java.util.List;

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

import com.ctc.wstx.shaded.msv_core.verifier.jarv.TheFactoryImpl;
import com.tcs.demo3microservice.entity.Restaurant;
import com.tcs.demo3microservice.service.RestaurantService;

@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
		Restaurant restaurant2 = restaurantService.restaurant(restaurant);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurant2);
		
	}
	
	// the below code is also get restaurant by id but though there is is a single restaurant by particular id
	// but you still want to apply list then this is the code format
//	@GetMapping("/{restauid}")
//	public ResponseEntity<List<Restaurant>> getById(@PathVariable String restauid){
//		List<Restaurant> restaurant = restaurantService.getByid(restauid);
//		return ResponseEntity.ok(restaurant) ;
//	}
	
	// the below code is for get resturant by id 
	@GetMapping("/{restauid}")
	public ResponseEntity<Restaurant> getById(@PathVariable String restauid){
		Restaurant restaurant = restaurantService.getByid(restauid);
		return ResponseEntity.ok(restaurant) ;
	}
	
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		List<Restaurant> restaurant = restaurantService.getAllRestaurants();
		return ResponseEntity.ok(restaurant);
	}
	
	 @PutMapping("/update/{restauid}")
	    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable String restauid, @RequestBody Restaurant restaurant) {
	        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restauid, restaurant);
	        return ResponseEntity.ok(updatedRestaurant);
	    }

	    @DeleteMapping("/delete/{restauid}")
	    public ResponseEntity<Void> deleteRestaurant(@PathVariable String restauid) {
	        restaurantService.deleteRestaurant(restauid);
	        return ResponseEntity.noContent().build();
	    }
	
}
