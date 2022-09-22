package com.rrojas.mongocrud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrojas.mongocrud.model.Product;
import com.rrojas.mongocrud.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	
	@PostMapping("/createProduct")
	public Product saveProduct(@RequestBody Product product) {
		productRepo.save(product);
		return product;
	}
	
	
	@PostMapping("/product")
	ResponseEntity<String> product(@RequestBody Product product){
		productRepo.save(product);
		return new ResponseEntity<String>("Create Sussccesfuly", HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
}
