package com.citi.mkts.domain.model;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;
import java.util.Map;

public class Grid extends Data {
    private final Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> gridDetail;

    public Grid(GridBuilder builder) {
        this.gridDetail = builder.gridDetail;
    }
    public Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> getGridDetail() {
        return gridDetail;
    }

    public static GridBuilder aGridBuilder() {
        return new GridBuilder();
    }

    public static final class GridBuilder {
        private Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> gridDetail;

        public GridBuilder gridDetail(Map<LocalDate, Map<Long, Pair<MarketFact, MarketDimension>>> gridDetail) {
            this.gridDetail = gridDetail;
            return this;
        }

        public Grid build() {
            return new Grid(this);
        }
    }
}