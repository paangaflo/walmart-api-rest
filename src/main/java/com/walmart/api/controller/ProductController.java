package com.walmart.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.model.Product;
import com.walmart.api.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@Api(tags = "product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	public ProductController() { }
	
	@GetMapping("/products")
	@ApiOperation(value = "Get Products", notes = "Service to get any products")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Records found"),
			@ApiResponse(code = 204, message = "Records not found"),
			@ApiResponse(code = 500, message = "Error searching records")})
	public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String search) {
		try {
			List<Product> products = new ArrayList<Product>();
			
			if (search == null) {
				productRepository.findAll().forEach(products::add);;
			}else {
				if(isNumeric(search)) {
					productRepository.findByIdProduct(search).forEach(products::add);
				}else {
					productRepository.findByBrandOrDescription(search).forEach(products::add);
				}
			}
			
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			if (search != null && isPalindrome(search)) {
				return new ResponseEntity<>(applyDiscount(products), HttpStatus.OK);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
	
	private boolean isPalindrome(String search) {
		search = search.toLowerCase();
		String invert = new StringBuilder(search).reverse().toString();
		
		return invert.equals(search);
	}
	
	private List<Product> applyDiscount(List<Product> products) {
		products.forEach(product -> {
			product.setPrice((int) Math.round(product.getPrice() * 0.5));
			product.setDiscount(true);
		});
		
		return products;
	}
}
