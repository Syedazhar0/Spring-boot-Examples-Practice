package com.tcs.demo3microservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.demo3microservice.rating.entity.Rating;
import com.tcs.demo3microservice.service.RatingService;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.rating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping("/{custid}")
    public ResponseEntity<List<Rating>> getByCustid(@PathVariable String custid) {
        List<Rating> ratings = ratingService.getByCustid(custid);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/getby/{restauid}")
    public ResponseEntity<List<Rating>> getByRestaurantId(@PathVariable String restauid) {
        List<Rating> ratings = ratingService.getByRestaurantId(restauid);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.ratings();
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/update/{custid}")
    public ResponseEntity<List<Rating>> updateRatingsByCustid(@PathVariable String custid, @RequestBody Rating rating) {
        List<Rating> updatedRatings = ratingService.updateRatingsByCustid(custid, rating);
        return ResponseEntity.ok(updatedRatings);
    }

    @DeleteMapping("/delete/{custid}")
    public ResponseEntity<Void> deleteRatingsByCustid(@PathVariable String custid) {
        ratingService.deleteRatingsByCustid(custid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update1/{restauid}")
    public ResponseEntity<List<Rating>> updateRatingsByRestauid(@PathVariable String restauid, @RequestBody Rating rating) {
        List<Rating> updatedRatings = ratingService.updateRatingsByRestauid(restauid, rating);
        return ResponseEntity.ok(updatedRatings);
    }

    @DeleteMapping("/delete1/{restauid}")
    public ResponseEntity<Void> deleteRatingsByRestauid(@PathVariable String restauid) {
        ratingService.deleteRatingsByRestauid(restauid);
        return ResponseEntity.noContent().build();
    }
}
