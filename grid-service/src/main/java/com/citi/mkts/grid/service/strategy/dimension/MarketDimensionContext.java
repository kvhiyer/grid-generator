package com.citi.mkts.grid.service.strategy.dimension;

import com.citi.mkts.domain.model.MarketDimension;

public class MarketDimensionContext {

    private final MarketDimensionStrategy marketDimensionStrategy;

    public MarketDimensionContext(MarketDimensionStrategy marketDimensionStrategy) {
        this.marketDimensionStrategy = marketDimensionStrategy;
    }

    public MarketDimension executeMarketDimensionStrategy(int index) {
        return marketDimensionStrategy.generateMarketDimension(index);
    }
}