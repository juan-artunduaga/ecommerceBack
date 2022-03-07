package com.carvajal.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carvajal.ecommerce.dto.WishListDTO;
import com.carvajal.ecommerce.entity.Product;
import com.carvajal.ecommerce.entity.UserWishList;
import com.carvajal.ecommerce.entity.UserWishListPK;
import com.carvajal.ecommerce.respository.WishListRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class WishListService {
	
	private WishListRepository wishListRepository;
	
	@Autowired
	public WishListService(WishListRepository wishListRepository) {
		this.wishListRepository = wishListRepository;
	}
	
	public List<WishListDTO> getWishList(int userId) {
		return wishListRepository.getWishListByUserId(userId)
				.stream()
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}
	
	
	public Optional<UserWishList> getWishListItem(int userId, int productId){
		return wishListRepository.getWishListItem(userId, productId);
	}
	

	public UserWishList addItem(UserWishListPK id) {
	    //consulto si el item existe ya en la lista
		Optional<UserWishList> item = getWishListItem(id.getIdUser(),id.getIdProduct());
		if(item.isPresent()) {
			throw new RuntimeException("El item ya está en la lista");
		}
		else {
			UserWishList userItem = new UserWishList();
			userItem.setId(id);
			return wishListRepository.save(userItem);
		}
		
	}
	
	
	
	public boolean deleteWishListItem(UserWishList userWishListItem){
		int userId = userWishListItem.getId().getIdUser();
		int productId = userWishListItem.getId().getIdProduct();
		return getWishListItem(userId ,productId )
				.map(listItem ->{
					wishListRepository.delete(userWishListItem);
					return true;
				}).orElse(false);
			
	}
	
	
	
	
	private WishListDTO entityToDto(UserWishList userWishList) {
		WishListDTO wishListDTO= new WishListDTO();
		wishListDTO.setProduct(userWishList.getProduct());
		return wishListDTO;
	}
	
	
	
	
}
