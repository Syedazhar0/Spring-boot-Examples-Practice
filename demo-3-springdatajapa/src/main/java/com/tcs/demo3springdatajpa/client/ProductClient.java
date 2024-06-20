package com.tcs.demo3springdatajpa.client;

import com.tcs.demo3springdatajpa.entity.Product3;
import com.tcs.demo3springdatajpa.mapper.ProductMapper;
import com.tcs.demo3springdatajpa.model.ProductModel;
import com.tcs.demo3springdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductClient implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create and save a single product
        ProductModel productModel1 = new ProductModel("Apple", 100, "appi", "https://tse2.mm.bing.net/th?id=OIP.Iedlm9CO0U4Ke8ZqZmZPbQHaHf&pid=Api&P=0&h=180");
        Product3 product1 = ProductMapper.toEntity(productModel1);
        productRepository.save(product1);
        System.out.println("Product saved: " + product1);

        // Save multiple products
        List<Product3> products = List.of(
                ProductMapper.toEntity(new ProductModel("Banana", 200, "bana", "https://tse3.mm.bing.net/th?id=OIP.emjzYKViT1SKMALrVmqujQHaE8&pid=Api&P=0&h=180")),
                ProductMapper.toEntity(new ProductModel("Mango", 300, "mongo", "https://tse2.mm.bing.net/th?id=OIP.mITFTpDFTM5iZ_YDhrHY3AHaD4&pid=Api&P=0&h=180"))
        );
        productRepository.saveAll(products);
        System.out.println("Products saved: " + products);

        // Find product by ID
        Optional<Product3> foundProduct = productRepository.findById(1L);
        foundProduct.ifPresent(p -> System.out.println("Product found: " + p));

        // Find all products
        List<Product3> allProducts = productRepository.findAll();
        System.out.println("All products: " + allProducts);

        // Update product by ID
        if (foundProduct.isPresent()) {
            Product3 productToUpdate = foundProduct.get();
            productToUpdate.setPname("UpdatedProduct1");
            productRepository.save(productToUpdate);
            System.out.println("Product updated: " + productToUpdate);
        }

        // Delete product by ID
        productRepository.deleteById(1L);
        System.out.println("Product deleted with ID: 1");

        // Delete all products
        productRepository.deleteAll();
        System.out.println("All products deleted");

        // Count products
        long count = productRepository.count();
        System.out.println("Total products count: " + count);

        // Check if product exists by ID
        boolean exists = productRepository.existsById(1L);
        System.out.println("Product exists with ID 1: " + exists);
        
        
        
        // if you want to perform operations using custom methods then create jpql queries or sql native or custom queries into repository
        
        // Find product by name   create jpql queries in repository
        List<Product3> productsByName = productRepository.findByPname("Product1");
        System.out.println("Products with name 'Product1': " + productsByName);

        // Find product by name and price
        List<Product3> productsByNameAndPrice = productRepository.findByPnameAndPrice("Product2", 200);
        System.out.println("Products with name 'Product2' and price 200: " + productsByNameAndPrice);

        // Find product by name and id
        Optional<Product3> productByNameAndId = productRepository.findByPnameAndId("Product3", 1L);
        productByNameAndId.ifPresent(product -> System.out.println("Product with name 'Product3' and ID 1: " + product));

        // Find products with price greater than a specified value (using custom query)
        List<Product3> productsWithPriceGreaterThan200 = productRepository.findByPriceGreaterThan(200);
        System.out.println("Products with price greater than 200: " + productsWithPriceGreaterThan200);

        // Find products by brand (using custom query)
        List<Product3> productsByBrand = productRepository.findByBrand("Brand1");
        System.out.println("Products with brand 'Brand1': " + productsByBrand);
        
        
        
        
        // Find products by price range (using native query) create native sql queries in repository
        List<Product3> productsByPriceRange = productRepository.findByPriceRange(100, 300);
        System.out.println("Products with price between 100 and 300: " + productsByPriceRange);
        
        
        
        
    }
}
