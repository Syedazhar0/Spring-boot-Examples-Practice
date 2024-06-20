package com.tcs.demo2.service;

import java.util.List;
import java.util.Optional;

import com.tcs.demo2.Entity.Products2;

import jakarta.validation.Valid;

public interface ProductService {

	 List<Products2> saveListOfProducts(@Valid List<Products2> productList);


	 List<Products2> getAllProducts() ;
	 
	 Products2 saveProduct(@Valid Products2 products2);
	 
	 Optional<Products2> getById(long id);
    
	 void deleteProductById(long id);
}
