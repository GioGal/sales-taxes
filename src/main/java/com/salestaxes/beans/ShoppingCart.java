package com.salestaxes.beans;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.salestaxes.factories.BasicNecessitiesProductsToolsFactory;
import com.salestaxes.factories.ConsumerGoodsToolsFactory;
import com.salestaxes.factories.FinancialToolsFactory;
import com.salestaxes.factories.ImportedConsumerGoodsToolsFactory;
import com.salestaxes.factories.ImportedProductsToolsFactory;
import com.salestaxes.processors.ShoppingCartProcessor;
import com.salestaxes.utils.SalesTaxesUtils;


public class ShoppingCart {
	
	private List<Product> items;
	private BigDecimal totalAmount = new BigDecimal(0);
	private BigDecimal taxesAmount = new BigDecimal(0);
	
	public ShoppingCart(){
		this.items = new ArrayList<Product>();
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public BigDecimal getTotalAmount() {
		return SalesTaxesUtils.round4Digits(totalAmount);
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTaxesAmount() {
		return SalesTaxesUtils.round3Digits(taxesAmount);
	}

	public void setTaxesAmount(BigDecimal taxesAmount) {
		this.taxesAmount = taxesAmount;
	}
	
	public void printReceiptDetails(ShoppingCart shoppingCart, int numberOfShoppingCart) {
		System.out.println("Output " + numberOfShoppingCart + ":");
		iterateOverItems();
		System.out.println("Sales Taxes: " + shoppingCart.getTaxesAmount());
		System.out.println("Total: " + shoppingCart.getTotalAmount());
		System.out.println();
	}

	private void iterateOverItems() {
		for (int i=0; i < getItems().size(); i++) {
			Product product = (Product) getItems().get(i);
			FinancialToolsFactory factory = null;
			ShoppingCartProcessor shoppingCartProcessor = null;
			factory = switchProductTypeFactory(product);
			shoppingCartProcessor = new ShoppingCartProcessor(factory);
			shoppingCartProcessor.calculateProductPriceIncludedTaxes(product);
			totalAmount = totalAmount.add(product.getPriceTaxesIncluded());
			taxesAmount = taxesAmount.add(product.getTaxesAmount());
			System.out.println(product.getQuantity() + " " + product.getDescription() + " " + ": " + product.getPriceTaxesIncluded());
		}
	}

	private FinancialToolsFactory switchProductTypeFactory(Product product) {
		FinancialToolsFactory factory;
		switch (product.getType()) {
		case CONSUMER_GOODS:
			factory = new ConsumerGoodsToolsFactory();
			break;
		case IMPORTED_PRODUCTS:
			factory = new ImportedProductsToolsFactory();
			break;
		case IMPORTED_CONSUMER_GOODS:
			factory = new ImportedConsumerGoodsToolsFactory();
			break;
		default:
			factory = new BasicNecessitiesProductsToolsFactory();
			break;
		}
		return factory;
	}
	
	
	

}
