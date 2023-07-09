package com.citi.mkts.grid.service.strategy.fact;

import com.citi.mkts.domain.model.MarketFact;
import org.springframework.stereotype.Component;

@Component
public interface MarketFactStrategy {

    public MarketFact generateMarketFact(int index);
}
