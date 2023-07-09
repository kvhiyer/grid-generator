package com.citi.mkts.grid.service.strategy.grid;

import com.citi.mkts.domain.model.Grid;
import com.citi.mkts.domain.model.MarketDimension;
import com.citi.mkts.domain.model.MarketFact;
import com.citi.mkts.grid.service.strategy.dimension.MarketDimensionContext;
import com.citi.mkts.grid.service.strategy.fact.MarketFactContext;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleGridStrategyTest {

    private SimpleGridStrategy sut;

    @Mock
    private MarketFactContext marketFactContext;

    @Mock
    private MarketDimensionContext marketDimemsionContext;

    @Before
    public void before() {
        when(marketFactContext.executeMarketFactStrategy(anyInt())).thenReturn(aMarketFact());
        when(marketDimemsionContext.executeMarketDimensionStrategy(anyInt())).thenReturn(aMarketDimension());
        sut = new SimpleGridStrategy(marketFactContext, marketDimemsionContext);
    }

    @Test
    public void testGridFactStrategy() {
        Grid grid = sut.generateGridDetails(533);
        assertNotNull(grid);
        assertThat(aMarketFact(), is(getMarketFactMarketDimensionPair(grid).getLeft()));
        assertThat(aMarketDimension(), is(getMarketFactMarketDimensionPair(grid).getRight()));
    }

    private Pair<MarketFact, MarketDimension> getMarketFactMarketDimensionPair(Grid grid) {
        return grid.getGridDetail().get(LocalDate.parse("2023-07-08")).get(532l); // Last Item
    }

    private static MarketDimension aMarketDimension() {
        return MarketDimension.aMarketDimensionBuilder().city("LONDON").gender("FEMALE").build();
    }

    private static MarketFact aMarketFact() {
        return MarketFact.aMarketFactBuilder().age(1).height(1).weight(1).build();
    }
}