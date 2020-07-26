package com.walmart.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.walmart.api.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByIdProductLike(String idProduct);
	List<Product> findByBrandLikeOrDescriptionLike(String brand, String description);
	
	default List<Product>  findByIdProduct(String search) {
    return findByIdProductLike(search);
  }
	
	default List<Product>  findByBrandOrDescription(String search) {
    return findByBrandLikeOrDescriptionLike(search, search);
  }
}
