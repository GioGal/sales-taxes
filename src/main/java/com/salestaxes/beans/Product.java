package com.salestaxes.beans;

import java.math.BigDecimal;

import com.salestaxes.utils.ProductType;

public class Product {
	private BigDecimal quantity;
	private String description;
	private ProductType type;
	private BigDecimal price;	
	private BigDecimal priceTaxesIncluded;
	private BigDecimal taxesAmount;

	public Product(BigDecimal quantity, String description, BigDecimal price, ProductType type) {
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.type = type;
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}
	
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPriceTaxesIncluded() {
		return priceTaxesIncluded;
	}

	public void setPriceTaxesIncluded(BigDecimal priceTaxesIncluded) {
		this.priceTaxesIncluded = priceTaxesIncluded;
	}

	public BigDecimal getTaxesAmount() {
		return taxesAmount;
	}

	public void setTaxesAmount(BigDecimal taxesAmount) {
		this.taxesAmount = taxesAmount;
	}
	

}
