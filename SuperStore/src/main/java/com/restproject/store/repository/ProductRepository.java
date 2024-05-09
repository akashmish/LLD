package com.restproject.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restproject.store.entity.Product;

public interface ProductRepository extends MongoRepository<Product,Integer>{
     
}
