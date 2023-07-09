package com.citi.mkts.domain.model;

public class MarketDimension extends Data {

    private final String gender;

    private final String city;

    public MarketDimension(MarketDimensionBuilder builder) {
        this.gender = builder.gender;
        this.city = builder.city;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String marketDimension() {
        return String.join("|", gender, city);
    }

    public static MarketDimensionBuilder aMarketDimensionBuilder() {
        return new MarketDimensionBuilder();
    }

    public static class MarketDimensionBuilder {

        private String gender;

        private String city;

        public MarketDimensionBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public MarketDimensionBuilder city(String city) {
            this.city = city;
            return this;
        }

        public MarketDimension build() {
            return new MarketDimension(this);
        }
    }
}
