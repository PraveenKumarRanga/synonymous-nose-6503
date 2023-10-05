package com.masai.OnlineShoppingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.OnlineShoppingApplication.model.Category;



public interface CategoryRepositary extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);
}