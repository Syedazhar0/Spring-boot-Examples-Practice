package com.tcs.demo2.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tcs.demo2.Entity.Products2;
import com.tcs.demo2.customexception.ProductException;
import com.tcs.demo2.repository.Product;

import jakarta.validation.Valid;

@Service
@Validated
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    
//    private final Product productRepository;
//
//    @Autowired
//    public ProductServiceImpl(Product productRepository) {
//        this.productRepository = productRepository;
//    } or just use like below

    @Autowired
    private Product productRepository;

    @Override
    public List<Products2> saveListOfProducts(@Valid List<Products2> productList) {
        logger.info("Saving list of products...");
        if(productList.isEmpty()) {
            throw new ProductException("Product list cannot be empty.");
        }
        List<Products2> savedProducts = productRepository.saveAll(productList);
        logger.info("List of products saved successfully.");
        return savedProducts;
    }

    @Override
    public List<Products2> getAllProducts() {
        logger.info("Retrieving all products...");
        List<Products2> allProducts = productRepository.findAll();
        logger.info("All products retrieved successfully.");
        return allProducts;
    }

    @Override
    public Products2 saveProduct(@Valid Products2 products2) {
        logger.info("Saving product...");
        return productRepository.save(products2);
    }

//	@Override
//	public Optional<Products2> getById(long id) {
//	Optional<Products2>optional=productRepository.findById(id);
//	Products2  products2 =null;
//	if(optional.isPresent()) {
//		products2=optional.get();
//	}else {
//		throw new ProductException("Product Not Found For Id :: "+id);
//	}
//		return Optional.of(products2);
//	}//or
    
    @Override
    public Optional<Products2> getById(long id) {
        Optional<Products2> optional = productRepository.findById(id);
        
        if (optional.isPresent()) {
            return optional;
        } else {
            throw new ProductException("Product Not Found For Id :: " + id);
        }
    }
    
    
    @Override
    public void deleteProductById(long id) {
        logger.info("Deleting product with id: " + id);
        Optional<Products2> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            this.productRepository.deleteById(id);
            logger.info("Product deleted successfully.");
        } else {
            throw new ProductException("Product Not Found For Id :: " + id);
        }
    }

}
