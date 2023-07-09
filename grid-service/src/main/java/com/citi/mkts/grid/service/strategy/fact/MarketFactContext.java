package com.citi.mkts.grid.service.strategy.fact;

import com.citi.mkts.domain.model.MarketFact;

public class MarketFactContext {

    private final MarketFactStrategy marketFactStrategy;

    public MarketFactContext(MarketFactStrategy marketFactStrategy) {
        this.marketFactStrategy = marketFactStrategy;
    }

    public MarketFact executeMarketFactStrategy(int index) {
        return marketFactStrategy.generateMarketFact(index);
    }

}
