package com.masai.OnlineShoppingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.OnlineShoppingApplication.model.Cart;




public interface CartRepository extends JpaRepository<Cart, Integer> {

}
