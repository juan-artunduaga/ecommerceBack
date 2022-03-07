package com.carvajal.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carvajal.ecommerce.entity.User;
import com.carvajal.ecommerce.respository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public Optional<User> getUserByid(int userId) {
		
		return userRepository.findById(userId);
	}
	
	

}
