package com.carvajal.ecommerce.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carvajal.ecommerce.entity.UserWishList;
import com.carvajal.ecommerce.entity.UserWishListPK;


public interface WishListRepository extends JpaRepository<UserWishList, UserWishListPK>{
	
	
	@Query(value="SELECT * FROM lista_deseos_opt l WHERE l.id_usuario = :id_usuario",nativeQuery =true)
	 List<UserWishList> getWishListByUserId(@Param("id_usuario") int userId);
	
	
	@Query(value="SELECT * FROM lista_deseos_opt l WHERE l.id_usuario = :id_usuario AND l.id_producto = :id_producto",nativeQuery =true)
	 Optional<UserWishList> getWishListItem(
			 @Param("id_usuario") int userId,
			 @Param("id_producto") int productId);
	
	
	
	@Query(value="INSERT into lista_deseos_opt values (:id_usuario,:id_producto) ",nativeQuery =true)
	 UserWishList saveWishListItem(
			@Param("id_usuario")int userId, 
			@Param("id_producto")int productId);
	
	
}
