package com.salestaxes.processors;

import java.math.BigDecimal;

import com.salestaxes.beans.Product;
import com.salestaxes.utils.SalesTaxesUtils;


public class BasicNecessitiesTaxProcessor extends TaxProcessor {

	void calculateTaxes(Product product) {
		BigDecimal priceTaxesIncluded = product.getPrice();
		BigDecimal taxes = SalesTaxesUtils.calculatePercentage(priceTaxesIncluded, product.getQuantity(), product.getType().getTaxesPercentage());
		priceTaxesIncluded = priceTaxesIncluded.add(taxes);
		product.setPriceTaxesIncluded(SalesTaxesUtils.round4Digits(priceTaxesIncluded));
		product.setTaxesAmount(SalesTaxesUtils.round3Digits(taxes));
	}

}
