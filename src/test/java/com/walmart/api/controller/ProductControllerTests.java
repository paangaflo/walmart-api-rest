package com.walmart.api.controller;

import com.walmart.api.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;

import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTests {

   @Autowired
   private MockMvc mvc;

   @MockBean
   private ProductController productController;

   @Test
   public void getProducts() throws Exception {
  	 Product product = new Product();
  	 product.setIdProduct("1");
  	 product.setBrand("ooy eqrceli");
  	 product.setDescription("rlñlw brhrka");
  	 product.setImage("www.lider.cl/catalogo/images/whiteLineIcon.svg");
  	 product.setPrice(498724);
  	 product.setDiscount(false);
  	 
  	 List<Product> products = singletonList(product);
  	 
  	 given(productController.getProducts(null)).willReturn(new ResponseEntity<>(products, HttpStatus.OK));
  	 
  	 mvc.perform(get("/api/products").contentType(APPLICATION_JSON))
  	 .andExpect(status().isOk())
  	 .andExpect(jsonPath("$", hasSize(1)))
  	 .andExpect(jsonPath("$[0].idProduct", is(product.getIdProduct())));
   }

   @Test
   public void getProductsByBrand() throws Exception {
  	 Product product = new Product();
  	 product.setIdProduct("1");
  	 product.setBrand("ooy eqrceli");
  	 product.setDescription("rlñlw brhrka");
  	 product.setImage("www.lider.cl/catalogo/images/whiteLineIcon.svg");
  	 product.setPrice(498724);
  	 product.setDiscount(false);
  	 
  	 List<Product> products = singletonList(product);
  	 
  	 given(productController.getProducts(product.getBrand())).willReturn(new ResponseEntity<>(products, HttpStatus.OK));
  	 
  	 mvc.perform(get("/api/products?search=" + product.getBrand()).contentType(APPLICATION_JSON))
  	 .andExpect(jsonPath("$", hasSize(1)))
  	 .andExpect(jsonPath("$[0].brand", is(product.getBrand())));
   }
}