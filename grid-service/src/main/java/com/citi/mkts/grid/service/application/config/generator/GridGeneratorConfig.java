package com.citi.mkts.grid.service.application.config.generator;

import com.citi.mkts.grid.service.application.generator.GridGenerator;
import com.citi.mkts.grid.service.application.dao.file.GridFileWriter;
import com.citi.mkts.grid.service.application.dao.GridWriter;
import com.citi.mkts.grid.service.strategy.dimension.AlternativeMarketDimensionStrategy;
import com.citi.mkts.grid.service.strategy.dimension.MarketDimensionContext;
import com.citi.mkts.grid.service.strategy.dimension.MarketDimensionStrategy;
import com.citi.mkts.grid.service.strategy.dimension.SimpleMarketDimensionStrategy;
import com.citi.mkts.grid.service.strategy.fact.AlternativeMarketFactStrategy;
import com.citi.mkts.grid.service.strategy.fact.MarketFactContext;
import com.citi.mkts.grid.service.strategy.fact.MarketFactStrategy;
import com.citi.mkts.grid.service.strategy.fact.SimpleMarketFactStrategy;
import com.citi.mkts.grid.service.strategy.grid.AlternativeGridStrategy;
import com.citi.mkts.grid.service.strategy.grid.GridContext;
import com.citi.mkts.grid.service.strategy.grid.GridStrategy;
import com.citi.mkts.grid.service.strategy.grid.SimpleGridStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class GridGeneratorConfig {

    @Value("${strategy.name}")
    private String strategyName;
    @Value("${file.path}")
    private String filePath;

    @Bean
    public MarketDimensionStrategy marketDimensionStrategy() {
        if (isAlternativeStrategy()) {
            return new AlternativeMarketDimensionStrategy();
        }
        return new SimpleMarketDimensionStrategy();
    }

    @Bean
    public MarketDimensionContext marketDimensionContext(MarketDimensionStrategy marketDimensionStrategy) {
        return new MarketDimensionContext(marketDimensionStrategy);
    }

    @Bean
    public MarketFactStrategy marketFactStrategy() {
        if (isAlternativeStrategy()) {
            return new AlternativeMarketFactStrategy();
        }
        return new SimpleMarketFactStrategy();
    }

    @Bean
    public MarketFactContext marketFactContext(MarketFactStrategy marketFactStrategy) {
        return new MarketFactContext(marketFactStrategy);
    }

    @Bean
    public GridStrategy gridStrategy(MarketFactContext marketFactContext, MarketDimensionContext marketDimensionContext) {
        if (isAlternativeStrategy()) {
            return new AlternativeGridStrategy();
        }
        return new SimpleGridStrategy(marketFactContext, marketDimensionContext);
    }

    @Bean
    public GridContext gridContext(GridStrategy gridStrategy) {
        return new GridContext(gridStrategy);
    }

    @Bean
    public GridWriter gridWriter() {
        return new GridFileWriter(Paths.get(filePath));
    }
    @Bean
    public GridGenerator gridGenerator(GridContext gridContext, GridWriter gridWriter) {
        return new GridGenerator(gridContext, gridWriter);
    }

    private boolean isAlternativeStrategy() {
        return StringUtils.equals(strategyName, "Alternative");
    }
}
