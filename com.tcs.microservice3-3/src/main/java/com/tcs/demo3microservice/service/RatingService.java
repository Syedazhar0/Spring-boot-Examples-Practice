package com.tcs.demo3microservice.service;

import java.util.List;
import com.tcs.demo3microservice.rating.entity.Rating;

public interface RatingService {

    // Save ratings
    Rating rating(Rating rating);

    // Get ratings by customer ID
    List<Rating> getByCustid(String custid);

    // Get ratings by restaurant ID
    List<Rating> getByRestaurantId(String restauid);

    // Get all ratings
    List<Rating> ratings();

    // Update ratings by customer ID
    List<Rating> updateRatingsByCustid(String custid, Rating rating);

    // Delete ratings by customer ID
    void deleteRatingsByCustid(String custid);

    // Update ratings by restaurant ID
    List<Rating> updateRatingsByRestauid(String restauid, Rating rating);

    // Delete ratings by restaurant ID
    void deleteRatingsByRestauid(String restauid);
}
