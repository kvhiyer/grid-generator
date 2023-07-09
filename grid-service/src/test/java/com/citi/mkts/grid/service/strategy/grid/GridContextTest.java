package com.citi.mkts.grid.service.strategy.grid;

import com.citi.mkts.domain.model.Grid;
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
public class GridContextTest {

    @Mock
    private GridStrategy gridStrategy;

    @Before
    public void before() {
        when(gridStrategy.generateGridDetails(anyInt())).thenReturn(Grid.aGridBuilder().build());
    }

    @Test
    public void testMarketDimensionContext() {
        GridContext sut = new GridContext(gridStrategy);
        Grid grid = sut.executeGridStrategy(533);
        assertThat(Grid.aGridBuilder().build(), is(grid));
    }
}