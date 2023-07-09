package com.citi.mkts.grid.service.strategy.fact;

import com.citi.mkts.domain.model.MarketFact;

public class SimpleMarketFactStrategy implements MarketFactStrategy {


    @Override
    public MarketFact generateMarketFact(int index) {
        return MarketFact
                .aMarketFactBuilder()
                .age(populateAge(index))
                .height(populateHeight(index))
                .weight(populateWeight(index))
                .build();
    }

    private int populateAge(int index) {
        return index;
    }

    private int populateHeight(int index) {
        return index + 10;
    }

    private int populateWeight(int index) {
        return index + 20;
    }
}