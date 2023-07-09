package com.citi.mkts.grid.service.strategy.dimension;

import com.citi.mkts.domain.model.MarketDimension;

public interface MarketDimensionStrategy {

    public MarketDimension generateMarketDimension(int index);
}
