package com.example.supermarketwala.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Product  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Size(min = 4, max = 25)
	private String productName;
	
	@NotBlank
	private String productDescription;
	
	private Double actualPrice;
	
	private Double tradeDiscount;
	
	private Double cashDiscount;
	
	private Double ratings;
	
	private List<String> features;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions colorOptions;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getTradeDiscount() {
		return tradeDiscount;
	}

	public void setTradeDiscount(Double tradeDiscount) {
		this.tradeDiscount = tradeDiscount;
	}

	public Double getCashDiscount() {
		return cashDiscount;
	}

	public void setCashDiscount(Double cashDiscount) {
		this.cashDiscount = cashDiscount;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public ColorOptions getColorOptions() {
		return colorOptions;
	}

	public void setColorOptions(ColorOptions colorOptions) {
		this.colorOptions = colorOptions;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	// logical methods having business logic reguardin
	// fields :
	
	
}
