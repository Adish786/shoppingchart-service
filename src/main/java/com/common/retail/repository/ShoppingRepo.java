package com.common.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.retail.model.Shopping;


@Repository
public interface ShoppingRepo  extends JpaRepository<Shopping, Integer>{
	
	Shopping findByShoppingname(String shoppingname);

}
