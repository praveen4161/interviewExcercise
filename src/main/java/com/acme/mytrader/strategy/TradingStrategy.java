package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy implements PriceListener {
	private ExecutionService executionService;
	private Double expectedPrice = Double.valueOf("60");
	private String expectedSecurity = "IBM";

	@Override
	public void priceUpdate(String security, double price) {
		
		if (expectedSecurity.equalsIgnoreCase(security) && expectedPrice.compareTo(price) <= 0) 
		{
			executionService.buy(security, price, 100);
		}
	}
}
