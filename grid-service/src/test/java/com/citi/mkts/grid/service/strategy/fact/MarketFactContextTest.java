package com.citi.mkts.grid.service.strategy.fact;

import com.citi.mkts.domain.model.MarketFact;
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
public class MarketFactContextTest {

    @Mock
    private MarketFactStrategy marketFactStrategy;

    @Before
    public void before() {
        when(marketFactStrategy.generateMarketFact(anyInt())).thenReturn(MarketFact.aMarketFactBuilder().age(1).height(10).weight(20).build());
    }

    @Test
    public void testMarketDimensionContext() {
        MarketFactContext sut = new MarketFactContext(marketFactStrategy);
        MarketFact marketFact = sut.executeMarketFactStrategy(533);
        assertThat(marketFact.getAge(), is(1));
        assertThat(marketFact.getHeight(), is(10));
        assertThat(marketFact.getWeight(), is(20));
    }
}