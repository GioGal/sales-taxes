package com.salestaxes.processors;

import com.salestaxes.beans.Product;
import com.salestaxes.factories.FinancialToolsFactory;

public class ShoppingCartProcessor {
	private TaxProcessor taxProcessor;

	public ShoppingCartProcessor(FinancialToolsFactory factory) {
		taxProcessor = factory.createTaxProcessor();
	}
	
	public void calculateProductPriceIncludedTaxes (Product product)	{

		taxProcessor.calculateTaxes(product);

	}
}
