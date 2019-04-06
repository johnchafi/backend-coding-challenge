package com.coveo.challenge.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistanceStrategyFactory {

   public static final String HAVERSINE = "HAV";

    @Autowired
    private HaversineDistanceStrategy haversineDistanceComputationStrategy;

    public DistanceStrategy getStrategy(String strategyType) {
        if(HAVERSINE.equals(strategyType)) {
            return haversineDistanceComputationStrategy;
        }
        throw new IllegalArgumentException("Invalid type of strategy " + strategyType);
    }
}
