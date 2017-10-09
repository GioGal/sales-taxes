package com.salestaxes.utils;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.math.RoundingMode.UP;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SalesTaxesUtils {
	
	public static BigDecimal round4Digits(BigDecimal value) {
		return round(value, 4);
	}
	
	public static BigDecimal round3Digits(BigDecimal value) {
		return round(value, 3);
	}

	private static BigDecimal round(BigDecimal value, int numberOfDigits) {
		MathContext mc = new MathContext(numberOfDigits, RoundingMode.HALF_UP);
		BigDecimal roundedValue = value.round(mc);
        return roundedValue;
	}
	
	public static BigDecimal calculatePercentage(BigDecimal value, BigDecimal quantity, BigDecimal percentage) {
		BigDecimal tax = value.multiply(quantity)
                .multiply(percentage)
                .divide(new BigDecimal(100), 2, ROUND_HALF_UP);

		BigDecimal rounding = new BigDecimal("0.05");
		return round(tax, rounding, UP);
		
	}
	
	static BigDecimal round(BigDecimal value, BigDecimal rounding, RoundingMode mode) {
        return value.divide(rounding, 0, mode).multiply(rounding);
    }

}
