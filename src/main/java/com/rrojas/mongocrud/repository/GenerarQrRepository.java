package com.rrojas.mongocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rrojas.mongocrud.model.GenerarQr;

public interface GenerarQrRepository extends MongoRepository<GenerarQr, Integer> {

}
