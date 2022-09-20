package com.rrojas.mongocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rrojas.mongocrud.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
