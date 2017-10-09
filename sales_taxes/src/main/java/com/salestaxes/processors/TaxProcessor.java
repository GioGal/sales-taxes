package com.salestaxes.processors;

import com.salestaxes.beans.Product;

public abstract class TaxProcessor {	
	abstract void calculateTaxes(Product product);
}
