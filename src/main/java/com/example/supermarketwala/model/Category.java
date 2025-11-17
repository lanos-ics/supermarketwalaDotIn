package com.example.supermarketwala.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId; 
	
	
	@Size(min = 2, max = 50)
	private String categoryName;
	
	@Email
	private String email;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	
	
	public Category() {
		super();
	}



	public Category(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}



	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	} 
	
	
	
	

}
