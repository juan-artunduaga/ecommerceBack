package com.carvajal.ecommerce.dto;

import java.io.Serializable;

import com.carvajal.ecommerce.entity.Product;

public class WishListDTO implements Serializable{
	
	private  Product product;

	public WishListDTO(Product product) {
		super();
		this.product = product;
	}

	public WishListDTO() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	} 
	
	
 
	
}


