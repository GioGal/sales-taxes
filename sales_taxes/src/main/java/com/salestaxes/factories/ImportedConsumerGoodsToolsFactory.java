package com.salestaxes.factories;

import com.salestaxes.processors.ImportedConsumerGoodsTaxProcessor;
import com.salestaxes.processors.TaxProcessor;

public class ImportedConsumerGoodsToolsFactory extends FinancialToolsFactory {

	@Override
	public TaxProcessor createTaxProcessor() {
		return new ImportedConsumerGoodsTaxProcessor();
	}

}
