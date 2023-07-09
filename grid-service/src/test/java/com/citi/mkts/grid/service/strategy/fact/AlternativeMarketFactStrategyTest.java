package com.citi.mkts.grid.service.strategy.fact;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlternativeMarketFactStrategyTest {

    private AlternativeMarketFactStrategy sut;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void before() {
        sut = new AlternativeMarketFactStrategy();
    }

    @Test
    public void testSimpleMarketDimensionStrategy() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Not yet supported / implemented");
        sut.generateMarketFact(101);
    }
}
