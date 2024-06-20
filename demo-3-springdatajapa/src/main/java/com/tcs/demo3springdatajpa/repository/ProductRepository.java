package com.tcs.demo3springdatajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.demo3springdatajpa.entity.Product3;
@Repository
public interface ProductRepository extends JpaRepository<Product3, Long>{

	// jpql custom queries
	 // Find product by name
    List<Product3> findByPname(String pname);

    // Find product by name and price
    List<Product3> findByPnameAndPrice(String pname, Integer price);

    // Find product by name and id
    Optional<Product3> findByPnameAndId(String pname, Long id);

    // Custom query to find products with price greater than a specified value
    @Query("SELECT p FROM Product3 p WHERE p.price > :price")
    List<Product3> findByPriceGreaterThan(Integer price);

    // Custom query to find products by brand
    @Query("SELECT p FROM Product3 p WHERE p.pbrand = :brand")
    List<Product3> findByBrand(String brand);
    
    
    // Native SQL query to find products by price range
    @Query(value = "SELECT * FROM product3 WHERE price BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
    List<Product3> findByPriceRange(Integer minPrice, Integer maxPrice);


}
