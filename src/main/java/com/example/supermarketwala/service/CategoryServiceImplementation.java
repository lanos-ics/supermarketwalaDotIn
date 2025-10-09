package com.example.supermarketwala.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermarketwala.exception.NotFoundException;
import com.example.supermarketwala.model.Category;
import com.example.supermarketwala.repo.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		
		categoryRepository.save(category);
		return category;
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> category =  categoryRepository.findById(categoryId);
		return category.orElseThrow(() -> new NotFoundException("Category not found."));
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {
		// TODO Auto-generated method stub
		
		Optional<Category> existingCategory =  categoryRepository.findById(categoryId);
		
		if(existingCategory.isPresent())
		{
			Category c = existingCategory.get();
			c.setCategoryName(category.getCategoryName());
			categoryRepository.save(c);
			return c;
		}else
		{
			throw new NotFoundException("category not found");
		}
		
		
	}

	@Override
	public Category deleteCategory(Long categoryId) {
		Optional<Category> existingCategory =  categoryRepository.findById(categoryId);
		
		if(existingCategory.isPresent())
		{
			Category c = existingCategory.get();
			
			categoryRepository.delete(c);
			return c;
		}
		else
		{
			throw new NotFoundException("category not found");
		}
		
	}

//	@Override
//	public String updateCategory(Long categoryId, Category category) {
////		Long id = Long.valueOf(categoryId);
//		Category existingCategory = findByIdOrThrow(categoryId);
//		
//		int index = categories.indexOf(existingCategory);
//		categories.set(index, category);
//		return "Category updated sucessfully!";
//	}
//
//	@Override
//	public Category getCategory(Long categoryId) {
//		// TODO Auto-generated method stub
//		//categoryId ke hisab se categories list mai se sahi cat get ho jaye.
//		return null;
//		
//	}
//	
//	// helper Method : 
//	
//	 private Category findByIdOrThrow(Long id)
//	 {
//		 Optional<Category> opt = categories.stream()
//				 .filter(c -> c.getCategoryId() != null && c.getCategoryId().equals(id))
//				 .findFirst();
//		 
//		 return opt.orElseThrow(() -> 
//		 new NotFoundException(" Category with id" + id + " not Found!"));
//		 
//	 }
 
	 
	 
	 
	 
	 
	
}
