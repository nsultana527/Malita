package com.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
                  property = "@id", scope = Product.class)
public class Product {

	@NotBlank(message = "Product Name is mandatory")
	@Size(max = 100, message = "Product name is too Long")
	private String product_name;
	
	@NotBlank(message = "Product Package is mandatory")
	@Size(max = 50, message = "Package details is too Long")
	private String product_package;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_package() {
		return product_package;
	}

	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}
	
	
}
