package com.salestaxes.utils;

import java.math.BigDecimal;

public enum ProductType {
    BASIC_NECESSITIES(new BigDecimal(0)),
    IMPORTED_PRODUCTS(new BigDecimal(5)),
    CONSUMER_GOODS(new BigDecimal(10)),
    IMPORTED_CONSUMER_GOODS(new BigDecimal(15));
    
    private final BigDecimal taxesPercentage;
    
    public BigDecimal getTaxesPercentage() {
		return taxesPercentage;
	}

	ProductType(BigDecimal taxesPercentage) {
        this.taxesPercentage = taxesPercentage;
    }
    
}