package com.carvajal.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserWishListPK implements Serializable{
	
	@Column(name="id_usuario")
	private int idUser;
	
	@Column(name="id_producto")
	private int idProduct;

	
	public UserWishListPK() {
		super();
	}
	
	
	public UserWishListPK(int idUser, int idProduct) {
		super();
		this.idUser = idUser;
		this.idProduct = idProduct;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
	
	
}
