package com.tcs.demo3springdatajpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.demo3springdatajpa.user.service.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	// feel free to write jpql or custom queries or sql native queries
	
//	List<Customer> findAll(Sort sort);
}
