package com.tcs.demo3microservice.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.demo3microservice.rating.entity.Rating;
import com.tcs.demo3microservice.repository.RatingRepository;
import com.tcs.demo3microservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating rating(Rating rating) {
    	 rating.setRatingId(UUID.randomUUID().toString());
    	    return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getByCustid(String custid) {
        return ratingRepository.findByCustid(custid);
    }

    @Override
    public List<Rating> getByRestaurantId(String restauid) {
        return ratingRepository.findByRestauid(restauid);
    }

    @Override
    public List<Rating> ratings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> updateRatingsByCustid(String custid, Rating newRating) {
        List<Rating> ratings = ratingRepository.findByCustid(custid);
        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for customer id: " + custid);
        }
        List<Rating> updatedRatings = ratings.stream().map(rating -> {
            rating.setRating(newRating.getRating());
            rating.setComments(newRating.getComments());
            return ratingRepository.save(rating);
        }).collect(Collectors.toList());
        return updatedRatings;
    }

    @Override
    public void deleteRatingsByCustid(String custid) {
        List<Rating> ratings = ratingRepository.findByCustid(custid);
        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for customer id: " + custid);
        }
        ratingRepository.deleteAll(ratings);
    }

    @Override
    public List<Rating> updateRatingsByRestauid(String restauid, Rating newRating) {
        List<Rating> ratings = ratingRepository.findByRestauid(restauid);
        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for restaurant id: " + restauid);
        }
        List<Rating> updatedRatings = ratings.stream().map(rating -> {
            rating.setRating(newRating.getRating());
            rating.setComments(newRating.getComments());
            return ratingRepository.save(rating);
        }).collect(Collectors.toList());
        return updatedRatings;
    }

    @Override
    public void deleteRatingsByRestauid(String restauid) {
        List<Rating> ratings = ratingRepository.findByRestauid(restauid);
        if (ratings.isEmpty()) {
            throw new RuntimeException("No ratings found for restaurant id: " + restauid);
        }
        ratingRepository.deleteAll(ratings);
    }
}
