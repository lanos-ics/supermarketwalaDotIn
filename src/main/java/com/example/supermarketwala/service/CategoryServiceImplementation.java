package com.example.supermarketwala.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.supermarketwala.dto.CategoryDTO;
import com.example.supermarketwala.dto.CategoryResponse;
import com.example.supermarketwala.exception.NotFoundException;
import com.example.supermarketwala.model.Category;
import com.example.supermarketwala.repo.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryResponse getCategories(int pageNumber, int size) {
		// TODO Auto-generated method stub
		
		Pageable pageRequest = PageRequest.of(pageNumber, size);
		Page<Category> categories = categoryRepository.findAll(pageRequest);
//		categories.get
		List<CategoryDTO> convertedCategories = categories.stream()
				.map(cat -> modelMapper.map(cat, CategoryDTO.class))
				.toList();
		
		CategoryResponse categoryResponse = new CategoryResponse();
		
		categoryResponse.setContent(convertedCategories);
		categoryResponse.setTotalElement(categories.getTotalElements());
		categoryResponse.setTotalPages(categories.getTotalPages());
		categoryResponse.setNumber(categories.getNumber());
		categoryResponse.setSize(categories.getSize());
		categoryResponse.setTotalNumberOfElements(categories.getNumberOfElements());
		categoryResponse.setIslastPage(categories.isLast());
		return categoryResponse;
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		
		// sabse pahle dto ko category mai convert karna hai. 
		Category category = modelMapper.map(categoryDTO, Category.class);
		
		
		// fir category ko use karke database mai add krne ka logic likhna hai. 
		
		categoryRepository.save(category);
		
		// bapas se category ko DTO mai conver krke rakhna hai 
		
		CategoryDTO categoryResponseDTO  = modelMapper.map(category, CategoryDTO.class);
		
		// category DTO ko return karna hai.
		
		return categoryResponseDTO;
		
		
		
		
		
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> category =  categoryRepository.findById(categoryId);
		return category.orElseThrow(() -> new NotFoundException("Category not found."));
	}

//	@Override
//	public Category updateCategory(Long categoryId, Category category) {
//		// TODO Auto-generated method stub
//		
//		Optional<Category> existingCategory =  categoryRepository.findById(categoryId);
//		
//		if(existingCategory.isPresent())
//		{
//			Cate gory c = existingCategory.get();
//			c.setCategoryName(category.getCategoryName());
//			categoryRepository.save(c);
//			return c;
//		}else
//		{
//			throw new NotFoundException("category not found");
//		}
//		
//		
//	}
//
//	@Override
//	public Category deleteCategory(Long categoryId) {
//		Optional<Category> existingCategory =  categoryRepository.findById(categoryId);
//		
//		if(existingCategory.isPresent())
//		{
//			Category c = existingCategory.get();
//			
//			categoryRepository.delete(c);
//			return c;
//		}
//		else
//		{
//			throw new NotFoundException("category not found");
//		}
//		
//	}

	@Override
	public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
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
