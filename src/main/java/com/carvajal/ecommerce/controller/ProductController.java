package com.carvajal.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.carvajal.ecommerce.entity.Product;
import com.carvajal.ecommerce.service.ProductService;

/** 
 * Clase controlador encargado de las peticiones http relacionadas con la entidad product
 * @Author Juan David Artunduaga
 */
@RestController
@RequestMapping(path="products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController ( ProductService productService) {
		this.productService = productService;
	}
	
	/** 
     * Metodo para obtener todos los productos
     * @return lista de productos
     */
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	
	/** 
     * Metodo para obtener la información un producto en especifico
     * @param productId id del producto a consultar
     * @return producto 
     */
	@GetMapping(path="/{productId}")
	public ResponseEntity<Object> getProduct(@PathVariable("productId") int productId){
		Optional<Product> productO = productService.getProductById(productId);
		if(productO.isPresent()) {
			return new ResponseEntity<Object>(productO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}			
	}
	
	
}
