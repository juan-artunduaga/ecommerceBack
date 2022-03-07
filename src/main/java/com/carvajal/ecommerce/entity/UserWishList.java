package com.carvajal.ecommerce.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lista_deseos_opt")
public class UserWishList {
	
	
	@EmbeddedId
	private UserWishListPK id;
	
	
	@ManyToOne
	@JoinColumn(name="id_producto",insertable = false, updatable=false)
	private  Product product; 
	

	public UserWishList(UserWishListPK id, Product product) {
		super();
		this.id = id;
		this.product = product;
	
	} 
	
	
	public UserWishList() {
		super();
		
	}

	public UserWishList(UserWishListPK id) {
		super();
		this.id = id;
	
	} 
	


	public UserWishListPK getId() {
		return id;
	}


	public void setId(UserWishListPK id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}



	
	
	
	
	
	
}
