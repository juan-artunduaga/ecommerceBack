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

import com.carvajal.ecommerce.entity.User;
import com.carvajal.ecommerce.service.UserService;

/** 
 * Clase controlador encargado de las peticiones http relacionadas con la entidad usuario
 * @Author Juan David Artunduaga
 */

@RestController
@RequestMapping(path="user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	/** 
     * Metodo consultar los usuarios 
     * @return Lista de los usuarios registrados
     */
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUsersByid(@PathVariable("id") int userId){
		return new ResponseEntity<>(userService.getUserByid(userId),HttpStatus.OK);
	}
	
}
