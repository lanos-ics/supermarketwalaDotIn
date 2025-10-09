package com.example.supermarketwala.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supermarketwala.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	// bhavishya ke liye khaali jagah : 
	
}
