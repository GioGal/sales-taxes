package com.salestaxes;

import java.math.BigDecimal;

import org.junit.Test;

import com.salestaxes.beans.Product;
import com.salestaxes.beans.ShoppingCart;
import com.salestaxes.utils.ProductType;

import junit.framework.TestCase;

public class SalesTaxesTest extends TestCase {
	
	/*
	 * 1 book at 12.49
	 * 1 music CD at 14.99
	 * 1 chocolate bar at 0.85
	 * 
	 */
	@Test
	public void testShoppingCart1() throws Exception {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "book", new BigDecimal("12.49"), ProductType.BASIC_NECESSITIES));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "music CD", new BigDecimal("14.99"), ProductType.CONSUMER_GOODS));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "chocolate bar", new BigDecimal("0.85"), ProductType.BASIC_NECESSITIES));
		shoppingCart.printReceiptDetails(shoppingCart, 1);
		BigDecimal priceItem0 = shoppingCart.getItems().get(0).getPriceTaxesIncluded();
		BigDecimal priceItem1 = shoppingCart.getItems().get(1).getPriceTaxesIncluded();
		BigDecimal priceItem2 = shoppingCart.getItems().get(2).getPriceTaxesIncluded();
		assertEquals(new BigDecimal("12.49"), priceItem0);
		assertEquals(new BigDecimal("16.49"), priceItem1);
		assertEquals(new BigDecimal("0.85"), priceItem2);
		assertEquals(new BigDecimal("1.50"), shoppingCart.getTaxesAmount());
		assertEquals(new BigDecimal("29.83"), shoppingCart.getTotalAmount());
	}
	
	/*
	 * 1 imported box of chocolates at 10.00
	 * 1 imported bottle of perfume at 47.50
	 */
	@Test
	public void testShoppingCart2() throws Exception {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "imported box of chocolates", new BigDecimal("10.00"), ProductType.IMPORTED_PRODUCTS));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "imported bottle of perfume", new BigDecimal("47.50"), ProductType.IMPORTED_CONSUMER_GOODS));
		shoppingCart.printReceiptDetails(shoppingCart, 2);
		BigDecimal priceItem0 = shoppingCart.getItems().get(0).getPriceTaxesIncluded();
		BigDecimal priceItem1 = shoppingCart.getItems().get(1).getPriceTaxesIncluded();

		assertEquals(new BigDecimal("10.50"), priceItem0);
		assertEquals(new BigDecimal("54.65"), priceItem1);
		assertEquals(new BigDecimal("7.65"), shoppingCart.getTaxesAmount());
		assertEquals(new BigDecimal("65.15"), shoppingCart.getTotalAmount());
	}
	
	/*
	 * 1 imported bottle of perfume at 27.99
	 * 1 bottle of perfume at 18.99
	 * 1 packet of headache pills at 9.75
	 * 1 box of imported chocolates at 11.25
	 */
	@Test
	public void testShoppingCart3() throws Exception {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "imported bottle of perfume", new BigDecimal("27.99"), ProductType.IMPORTED_CONSUMER_GOODS));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "bottle of perfume", new BigDecimal("18.99"), ProductType.CONSUMER_GOODS));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "packet of headache pills", new BigDecimal("9.75"), ProductType.BASIC_NECESSITIES));
		shoppingCart.getItems().add(new Product(new BigDecimal(1), "box of imported chocolates", new BigDecimal("11.25"), ProductType.IMPORTED_PRODUCTS));
		shoppingCart.printReceiptDetails(shoppingCart, 3);
		BigDecimal priceItem0 = shoppingCart.getItems().get(0).getPriceTaxesIncluded();
		BigDecimal priceItem1 = shoppingCart.getItems().get(1).getPriceTaxesIncluded();
		BigDecimal priceItem2 = shoppingCart.getItems().get(2).getPriceTaxesIncluded();
		BigDecimal priceItem3 = shoppingCart.getItems().get(3).getPriceTaxesIncluded();

		assertEquals(new BigDecimal("32.19"), priceItem0);
		assertEquals(new BigDecimal("20.89"), priceItem1);
		assertEquals(new BigDecimal("9.75"), priceItem2);
		assertEquals(new BigDecimal("11.85"), priceItem3);
		assertEquals(new BigDecimal("6.70"), shoppingCart.getTaxesAmount());
		assertEquals(new BigDecimal("74.68"), shoppingCart.getTotalAmount());
	}
	
}

