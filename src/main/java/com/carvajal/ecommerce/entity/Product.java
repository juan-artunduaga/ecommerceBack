package com.carvajal.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Product {
	
	
	@Id
	@Column(name="id_producto")
	private int idProduct;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="precio")
	private double price;
	
	@Column(name="cantidad")
	private int stock;
	
	
	
	public Product() {
		super();
	}

	
	
	public Product(int id, String name, double price, int stock) {
		super();
		this.idProduct = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}


	public int getId() {
		return idProduct;
	}

	public void setId(int id) {
		this.idProduct = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}