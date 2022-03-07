package com.carvajal.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.ecommerce.dto.WishListDTO;
import com.carvajal.ecommerce.entity.UserWishList;
import com.carvajal.ecommerce.entity.UserWishListPK;
import com.carvajal.ecommerce.respository.WishListRepository;
import com.carvajal.ecommerce.service.WishListService;

/** 
 * Clase controlador encargado de las peticiones http relacionadas con la entidad wishlist
 * @Author Juan David Artunduaga
 */
@RestController
@RequestMapping(path ="/wishes")
public class WishListController {

	private WishListService wishListService;
	
	@Autowired
	public WishListController (WishListService wishListService) {
		this.wishListService= wishListService;
	}
	
	/** 
     * Metodo para obtener de la lista de deseos de un usuario
     * @param userId id de un usuario a quien pertenece la lista
     * @return lista de deseos de usuario
     */
	@GetMapping(path ="/usuario/{idUsuario}")
	public ResponseEntity<List<WishListDTO>> getList(@PathVariable("idUsuario") int userId){
		return new ResponseEntity<>(wishListService.getWishList(userId),HttpStatus.OK);
	}
	
	/** 
     * Metodo para añadir un producto a la lista de deseos de un usuario
     * @param userWishList objeto que contiene el id del usuario y el id del producto a agregar
     */
	@PostMapping
	public ResponseEntity<UserWishList> postWishListItem(@RequestBody UserWishListPK userWishList){
		return new ResponseEntity<>(wishListService.addItem(userWishList),HttpStatus.CREATED);
	}
	
	/** 
     * Metodo para eliminar un producto de la lista de deseos de un usuario 
     * @param recibe el id del usuario dueño de la lista y el id del producto a eliminar
     */
	@DeleteMapping(path="/{userId}/{productId}")
	public ResponseEntity<Object> deleteWithListItem(
			@PathVariable("userId") int userId,
			@PathVariable("productId") int productId){
		
		UserWishListPK userWishListPK = new UserWishListPK(userId,productId);
		UserWishList userWishList = new UserWishList(userWishListPK);
		return new ResponseEntity<Object>(wishListService.deleteWishListItem(userWishList),HttpStatus.OK);
	}
	
}
