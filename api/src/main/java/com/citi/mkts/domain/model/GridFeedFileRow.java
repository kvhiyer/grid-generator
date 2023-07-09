package com.citi.mkts.domain.model;

import java.time.LocalDate;

public class GridFeedFileRow extends Data {

    private final LocalDate gridDate;

    private final Long id;

    private final MarketFact marketFact;

    private final MarketDimension marketDimension;

    public GridFeedFileRow(GridFeedFileRowBuilder builder) {
        this.gridDate = builder.gridDate;
        this.id = builder.id;
        this.marketFact = builder.marketFact;
        this.marketDimension = builder.marketDimension;
    }

    public LocalDate getGridDate() {
        return gridDate;
    }

    public Long getId() {
        return id;
    }

    public MarketFact getMarketFact() {
        return marketFact;
    }

    public MarketDimension getMarketDimension() {
        return marketDimension;
    }

    public static GridFeedFileRowBuilder aGridFeedFileRowBuilder() {
        return new GridFeedFileRowBuilder();
    }

    public static final class GridFeedFileRowBuilder {

        private LocalDate gridDate;

        private Long id;

        private MarketFact marketFact;

        private MarketDimension marketDimension;

        public GridFeedFileRowBuilder gridDate(LocalDate gridDate) {
            this.gridDate = gridDate;
            return this;
        }

        public GridFeedFileRowBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GridFeedFileRowBuilder marketFact(MarketFact marketFact) {
            this.marketFact = marketFact;
            return this;
        }

        public GridFeedFileRowBuilder marketDimension(MarketDimension marketDimension) {
            this.marketDimension = marketDimension;
            return this;
        }

        public GridFeedFileRow build() {
            return new GridFeedFileRow(this);
        }
    }

}
