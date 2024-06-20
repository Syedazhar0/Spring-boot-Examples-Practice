package com.tcs.demo3microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tcs.demo3microservice.rating.entity.Rating;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    // Find ratings by customer ID
    List<Rating> findByCustid(String custid);

    // Find ratings by restaurant ID
    List<Rating> findByRestauid(String restauid);

    // Delete ratings by customer ID
    void deleteByCustid(String custid);

    // Delete ratings by restaurant ID
    void deleteByRestauid(String restauid);
}
