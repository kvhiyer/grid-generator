package com.citi.mkts.grid.service.strategy.dimension;

import com.citi.mkts.domain.model.MarketDimension;

public class SimpleMarketDimensionStrategy implements MarketDimensionStrategy {

    private static final String[] CITY_ARRAY = new String[] {"LONDON", "NEW YORK", "CHICAGO", "WARSAW", "NAIROBI", "TOKYO", "KOCHI", "AUCKLAND", "LOS ANGELES", "BUDAPEST"};
    /**
     * @param index
     * @return
     */
    @Override
    public MarketDimension generateMarketDimension(int index) {
        return MarketDimension
                .aMarketDimensionBuilder()
                .city(populateCity(index))
                .gender(populateGender(index))
                .build();
    }

    private String populateGender(int index) {
        return index % 2 == 0 ? "MALE" : "FEMALE";
    }

    private String populateCity(int index) {
        return CITY_ARRAY[index % CITY_ARRAY.length];
    }
}
