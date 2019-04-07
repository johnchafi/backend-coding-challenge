package com.coveo.challenge.calculator;

import org.springframework.stereotype.Component;

@Component
public class DistanceStrategyFactory {

    public static final String HAVERSINE = "HAV";

    public DistanceStrategy getStrategy(String strategyType) {
        if(HAVERSINE.equals(strategyType)) {
            return new HaversineDistanceStrategy();
        }
        throw new IllegalArgumentException("Invalid type of strategy " + strategyType);
    }
}
