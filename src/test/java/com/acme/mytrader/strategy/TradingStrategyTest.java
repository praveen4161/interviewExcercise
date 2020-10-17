package com.acme.mytrader.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.acme.mytrader.execution.ExecutionService;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {
	
	@InjectMocks
	private TradingStrategy tradingStrategy;
	
	@Mock
	private ExecutionService exceutionService;
    
	@Test
    public void testWhenSecuirtyisNotExpected() 
	{
		tradingStrategy.priceUpdate("tcs", 60);
		verify(exceutionService, times(0)).buy("tcs", 60, 100);
    }
	
	@Test
    public void testWhenPriceisNotMatched() 
	{
		tradingStrategy.priceUpdate("IBM", 20);
		verify(exceutionService, times(0)).buy("IBM", 20, 100);
    }
	
	@Test
    public void testBuyExecution() 
	{
		tradingStrategy.priceUpdate("IBM", 60);
		verify(exceutionService, times(1)).buy("IBM", 60, 100);
    }
}
