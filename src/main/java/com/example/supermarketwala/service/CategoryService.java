package com.example.supermarketwala.service;

import java.util.List;

import com.example.supermarketwala.dto.CategoryDTO;
import com.example.supermarketwala.dto.CategoryResponse;
import com.example.supermarketwala.model.Category;

public interface CategoryService {
	// it will provide GUIDE to the CONTROLLER : info.
	// and will provide ASSISTANCE/ BLUEPRINT to implementation class. 

	// get category 
	
	public CategoryResponse getCategories(int pageNumber, int size);
	
	public Category getCategory(Long categoryId);
	 
	// add category 
	
	public CategoryDTO addCategory(CategoryDTO categoryDTO);
	
	// delete category 
	
	public CategoryDTO deleteCategory(Long categoryId);
	
	// update category 
	public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
}
