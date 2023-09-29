package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
