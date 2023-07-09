package com.citi.mkts.grid.service.strategy.fact;

import com.citi.mkts.domain.model.MarketFact;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SimpleMarketFactStrategyTest {

    private SimpleMarketFactStrategy sut;

    @Before
    public void before() {
        sut = new SimpleMarketFactStrategy();
    }

    @Test
    @Parameters(method = "parametersToTestSimpleMarketFactStrategy")
    public void testSimpleMarketFactStrategy(int index, MarketFact expectedMarketFact) {
        assertEquals(expectedMarketFact, sut.generateMarketFact(index));
    }

    private Object[] parametersToTestSimpleMarketFactStrategy() {
        return new Object[] {
                new Object[] {0, MarketFact.aMarketFactBuilder().age(0).height(10).weight(20).build()},
                new Object[] {9, MarketFact.aMarketFactBuilder().age(9).height(19).weight(29).build()},
                new Object[] {99, MarketFact.aMarketFactBuilder().age(99).height(109).weight(119).build()},
        };
    }
}