package com.example.supermarketwala.service;

import java.util.List;

import com.example.supermarketwala.model.Category;

public interface CategoryService {
	// it will provide GUIDE to the CONTROLLER : info.
	// and will provide ASSISTANCE/ BLUEPRINT to implementation class. 

	// get category 
	
	public List<Category> getCategories();
	
	public Category getCategory(Long categoryId);
	 
	// add category 
	
	public String addCategory(Category category);
	
	// delete category 
	
	public String deleteCategory(Long categoryId);
	
	// update category 
	public String updateCategory(Long categoryId, Category category);
}
