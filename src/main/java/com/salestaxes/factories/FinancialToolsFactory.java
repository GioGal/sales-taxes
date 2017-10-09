package com.salestaxes.factories;

import com.salestaxes.processors.TaxProcessor;

public abstract class FinancialToolsFactory {
	public abstract TaxProcessor createTaxProcessor();
}
