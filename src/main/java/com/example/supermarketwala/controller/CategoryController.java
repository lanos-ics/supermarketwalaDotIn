package com.example.supermarketwala.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarketwala.model.Category;
import com.example.supermarketwala.service.CategoryService;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

	//DEPENDENCY INJECTION
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	 ResponseEntity<List<Category>> getCategories()
	{
		List<Category> categories =  categoryService.getCategories();
		return ResponseEntity.ok().body(categories);
	}
	
	// i want you to Return single category based on the categoryId to the user. 
	
	@GetMapping("/category/{categoryId}")
	ResponseEntity<Category> getCategory(@PathVariable Long categoryId)
	{
		Category cat = categoryService.getCategory(categoryId);
		return ResponseEntity.ok().body(cat);
	}
	
	
	@PostMapping("/categories")
	ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category categoryAdded = categoryService.addCategory(category);
		return ResponseEntity.accepted().body(categoryAdded);
		
	}
	
	@DeleteMapping("/categories/d/{catId}")
	ResponseEntity<Category> removeCategory(@PathVariable("catId") Long categoryId)
	{
		
		Category deletedCategory = categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok().body(deletedCategory);
	}
	
	@PutMapping("/categories/u/{categoryId}")
	ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody Category category)
	{
		Category updatedCategory = categoryService.updateCategory(categoryId, category);
		return ResponseEntity.ok().body(updatedCategory);
	}
	
	
	
	
}
