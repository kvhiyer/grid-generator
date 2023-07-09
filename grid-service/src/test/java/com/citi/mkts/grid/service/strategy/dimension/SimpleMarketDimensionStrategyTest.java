package com.citi.mkts.grid.service.strategy.dimension;

import com.citi.mkts.domain.model.MarketDimension;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SimpleMarketDimensionStrategyTest {

    private SimpleMarketDimensionStrategy sut;

    @Before
    public void before() {
        sut = new SimpleMarketDimensionStrategy();
    }

    @Test
    @Parameters(method = "parametersToTestSimpleMarketDimensionStrategy")
    public void testSimpleMarketDimensionStrategy(int index, MarketDimension expectedMarketDimension) {
        assertEquals(expectedMarketDimension, sut.generateMarketDimension(index));
    }

    private Object[] parametersToTestSimpleMarketDimensionStrategy() {
        return new Object[] {
                new Object[] {0, MarketDimension.aMarketDimensionBuilder().city("LONDON").gender("MALE").build()},
                new Object[] {1, MarketDimension.aMarketDimensionBuilder().city("NEW YORK").gender("FEMALE").build()},
                new Object[] {2, MarketDimension.aMarketDimensionBuilder().city("CHICAGO").gender("MALE").build()},
                new Object[] {3, MarketDimension.aMarketDimensionBuilder().city("WARSAW").gender("FEMALE").build()},
                new Object[] {4, MarketDimension.aMarketDimensionBuilder().city("NAIROBI").gender("MALE").build()},
                new Object[] {5, MarketDimension.aMarketDimensionBuilder().city("TOKYO").gender("FEMALE").build()},
                new Object[] {6, MarketDimension.aMarketDimensionBuilder().city("KOCHI").gender("MALE").build()},
                new Object[] {7, MarketDimension.aMarketDimensionBuilder().city("AUCKLAND").gender("FEMALE").build()},
                new Object[] {8, MarketDimension.aMarketDimensionBuilder().city("LOS ANGELES").gender("MALE").build()},
                new Object[] {9, MarketDimension.aMarketDimensionBuilder().city("BUDAPEST").gender("FEMALE").build()},
                // Test the same pattern for next 10. Note, will change if the static list of cities are updated.
                new Object[] {10, MarketDimension.aMarketDimensionBuilder().city("LONDON").gender("MALE").build()},
                new Object[] {11, MarketDimension.aMarketDimensionBuilder().city("NEW YORK").gender("FEMALE").build()},
                new Object[] {12, MarketDimension.aMarketDimensionBuilder().city("CHICAGO").gender("MALE").build()},
                new Object[] {13, MarketDimension.aMarketDimensionBuilder().city("WARSAW").gender("FEMALE").build()},
                new Object[] {14, MarketDimension.aMarketDimensionBuilder().city("NAIROBI").gender("MALE").build()},
                new Object[] {15, MarketDimension.aMarketDimensionBuilder().city("TOKYO").gender("FEMALE").build()},
                new Object[] {16, MarketDimension.aMarketDimensionBuilder().city("KOCHI").gender("MALE").build()},
                new Object[] {17, MarketDimension.aMarketDimensionBuilder().city("AUCKLAND").gender("FEMALE").build()},
                new Object[] {18, MarketDimension.aMarketDimensionBuilder().city("LOS ANGELES").gender("MALE").build()},
                new Object[] {19, MarketDimension.aMarketDimensionBuilder().city("BUDAPEST").gender("FEMALE").build()},
        };
    }
}