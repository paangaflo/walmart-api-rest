package com.walmart.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.walmart.api.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByIdLikeOrBrandLikeOrDescriptionLike(String id, String brand, String description);
	
	default List<Product>  findByIdOrBrandOrDescription(String search) {
    return findByIdLikeOrBrandLikeOrDescriptionLike(search, search, search);
  }
}
