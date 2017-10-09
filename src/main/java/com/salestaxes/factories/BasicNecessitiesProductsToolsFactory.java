package com.salestaxes.factories;

import com.salestaxes.processors.BasicNecessitiesTaxProcessor;
import com.salestaxes.processors.TaxProcessor;

public class BasicNecessitiesProductsToolsFactory extends FinancialToolsFactory {

	@Override
	public TaxProcessor createTaxProcessor() {
		return new BasicNecessitiesTaxProcessor();
	}

}
