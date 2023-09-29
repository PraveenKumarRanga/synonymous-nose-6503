package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
