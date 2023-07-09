package com.citi.mkts.grid.service.strategy.dimension;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlternativeMarketDimensionStrategyTest {

    private AlternativeMarketDimensionStrategy sut;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void before() {
        sut = new AlternativeMarketDimensionStrategy();
    }

    @Test
    public void testSimpleMarketDimensionStrategy() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Not yet supported / implemented");
        sut.generateMarketDimension(101);
    }
}
