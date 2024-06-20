package com.tcs.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.demo2.Entity.Products2;

@Repository
public interface Product extends JpaRepository<Products2, Long> {

}
