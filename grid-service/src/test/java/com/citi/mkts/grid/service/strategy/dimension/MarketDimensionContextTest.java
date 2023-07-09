package com.citi.mkts.grid.service.strategy.dimension;

import com.citi.mkts.domain.model.MarketDimension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarketDimensionContextTest {

    @Mock
    private MarketDimensionStrategy marketDimensionStrategy;

    @Before
    public void before() {
        when(marketDimensionStrategy.generateMarketDimension(anyInt())).thenReturn(MarketDimension.aMarketDimensionBuilder().city("LONDON").gender("MALE").build());
    }

    @Test
    public void testMarketDimensionContext() {
        MarketDimensionContext sut = new MarketDimensionContext(marketDimensionStrategy);
        MarketDimension marketDimension = sut.executeMarketDimensionStrategy(533);
        assertThat(marketDimension.getCity(), is("LONDON"));
        assertThat(marketDimension.getGender(), is("MALE"));
    }
}