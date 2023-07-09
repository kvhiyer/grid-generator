package com.citi.mkts.domain.model;

public class MarketFact extends Data {

    private final int age;

    private final int height;

    private final int weight;

    public MarketFact(MarketFactBuilder builder) {
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String marketFact() {
        return String.join("|", Integer.toString(age), Integer.toString(height), Integer.toString(weight));
    }

    public static MarketFactBuilder aMarketFactBuilder() {
        return new MarketFactBuilder();
    }

    public static final class MarketFactBuilder {

        private int age;

        private int height;

        private int weight;

        public MarketFactBuilder age(int age) {
            this.age = age;
            return this;
        }

        public MarketFactBuilder height(int height) {
            this.height = height;
            return this;
        }

        public MarketFactBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public MarketFact build() {
            return new MarketFact(this);
        }
    }

}
