package com.citi.mkts.grid.service.strategy.grid;

import com.citi.mkts.domain.model.Grid;
import com.citi.mkts.domain.model.MarketDimension;
import com.citi.mkts.domain.model.MarketFact;
import com.citi.mkts.grid.service.strategy.dimension.MarketDimensionContext;
import com.citi.mkts.grid.service.strategy.fact.MarketFactContext;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A Simple Strategy that always generates random Grid for the date 08th July 2023. This can be extended in future to make date(s) a dynamic parameter.
 */
public class SimpleGridStrategy implements GridStrategy {

    private final MarketFactContext marketFactContext;

    private final MarketDimensionContext marketDimensionContext;

    public SimpleGridStrategy(MarketFactContext marketFactContext, MarketDimensionContext marketDimensionContext) {
        this.marketFactContext = marketFactContext;
        this.marketDimensionContext = marketDimensionContext;
    }
    @Override
    public Grid generateGridDetails(final int numberOfGridItems) {

        Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> gridDetail = new HashMap<>();
        Map<Long, Pair<MarketFact, MarketDimension>> factsAndDimensionMap = IntStream.range(0, numberOfGridItems).boxed().collect(Collectors.toMap(Long::valueOf, index -> Pair.of(generateMarketFact(index), generateMarketDimension(index)), (old, current) -> current));
        gridDetail.put(LocalDate.parse("2023-07-08"), factsAndDimensionMap);
        return Grid.aGridBuilder()
                        .gridDetail(gridDetail)
                        .build();
    }

    private MarketDimension generateMarketDimension(int index) {
        return marketDimensionContext.executeMarketDimensionStrategy(index);
    }

    private MarketFact generateMarketFact(int index) {
        return marketFactContext.executeMarketFactStrategy(index);
    }
}
