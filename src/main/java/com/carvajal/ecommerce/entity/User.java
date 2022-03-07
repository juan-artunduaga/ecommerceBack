package com.carvajal.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="usuario")
public class User {
	
	
	@Id
	@Column(name ="id_usuario")
	private int idUser;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="correo")
	private String email;
	
	
	public User() {
		super();
	}
	
	public User(int idUser, String name, String email,List<UserWishList> userWishList) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.email = email;
	
	}

	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
	
	