package com.citi.mkts.grid.service.strategy.grid;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlternativeGridStrategyTest {

    private AlternativeGridStrategy sut;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void before() {
        sut = new AlternativeGridStrategy();
    }

    @Test
    public void testSimpleMarketDimensionStrategy() {
        exceptionRule.expect(UnsupportedOperationException.class);
        exceptionRule.expectMessage("Not yet supported / implemented");
        sut.generateGridDetails(101);
    }
}
