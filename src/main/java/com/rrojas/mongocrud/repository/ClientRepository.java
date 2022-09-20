package com.rrojas.mongocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rrojas.mongocrud.model.Client;

public interface ClientRepository extends MongoRepository<Client, Integer> {

}
