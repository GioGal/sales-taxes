package com.salestaxes.factories;

import com.salestaxes.processors.ImportedProductsTaxProcessor;
import com.salestaxes.processors.TaxProcessor;

public class ImportedProductsToolsFactory extends
		FinancialToolsFactory {

	@Override
	public TaxProcessor createTaxProcessor() {
		return new ImportedProductsTaxProcessor();
	}

}
