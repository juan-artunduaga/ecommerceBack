package com.carvajal.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carvajal.ecommerce.entity.Product;
import com.carvajal.ecommerce.respository.ProductRepository;



@Service
public class ProductService {
	
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}


	public Optional<Product> getProductById(int productId) {
		return productRepository.findById(productId);
	}
	
	
	
	
}

