package com.carvajal.ecommerce.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvajal.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
