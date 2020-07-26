package com.walmart.api.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "products")
public class Product {
	
	@MongoId(FieldType.STRING)
	@Field("_id")
  private String _id;
	
	@Field("id")
  private String idProduct;
	@Field("brand")
  private String brand;
  @Field("description")
  private String description;
  @Field("image")
  private String image;
  @Field("price")
  private int price;
  private boolean discount;

  public Product() { 
  	this.discount = false;
  }

  public String getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(String id) {
    this.idProduct = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
  
  public boolean getDiscount() {
    return discount;
  }

  public void setDiscount(boolean discount) {
    this.discount = discount;
  }
}
