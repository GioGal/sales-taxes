package com.salestaxes.factories;

import com.salestaxes.processors.ConsumerGoodsTaxProcessor;
import com.salestaxes.processors.TaxProcessor;

public class ConsumerGoodsToolsFactory extends FinancialToolsFactory {

	@Override
	public TaxProcessor createTaxProcessor() {
		return new ConsumerGoodsTaxProcessor();
	}

}
