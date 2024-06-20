package com.tcs.demo2.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo2.Entity.Products2;
import com.tcs.demo2.service.ProductService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/api")
public class ProductController {

//    private final ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    } or 
	@Autowired
    private  ProductService productService;
	
	 @PostMapping("/saveAll")
	    public ResponseEntity<List<Products2>> saveProducts(@Valid @RequestBody List<Products2> productList) {
	        List<Products2> savedProducts = productService.saveListOfProducts(productList);
	        return ResponseEntity.ok(savedProducts);
	    }
	
	 @GetMapping("/products")
	    public String getAllProducts(Model model) {
	        model.addAttribute("listOfProducts", productService.getAllProducts());
	        return "index";
}
	 @GetMapping("/new-product")
	    public String showAddProductForm(Model model) {
	        model.addAttribute("product", new Products2());
	        return "new-product"; // getting the add product form to add the product 
	        //new Products2(): This creates a new instance of the Products2 class. In many web applications,
//when you want to display a form for adding a new entity (in this case, a new product), 
//you need an object to bind the form fields to. By creating a new instance of Products2, 
	        //you ensure that the form fields have an object to bind to.
	    }

	 
	 
	 @PostMapping("/save-product")
	    public String addProductForm(@ModelAttribute("product") @Valid Products2 products2, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "new-product"; // if any validation error occurred Returning back to the form with validation errors
	        }
	        productService.saveProduct(products2);
	        return "redirect:/api/products"; // returning to the list of products including the new product 
	    }

	 @GetMapping("/editForm/{id}")
	 public String getById(@PathVariable("id") long id, Model model) {
	     Optional<Products2> products2 = productService.getById(id);
	     model.addAttribute("product", products2.orElse(null)); 
	     return "edit-product";
	 }

	 @GetMapping("/products/delete/{id}")
	 public String deleteProduct(@PathVariable("id") long id) {
	     productService.deleteProductById(id);
	     return "redirect:/api/products"; 
	 }
	 

}


  


















