package com.coveo.challenge.calculator.strategy.similarity;

import com.coveo.challenge.calculator.strategy.distance.DistanceStrategy;
import com.coveo.challenge.calculator.strategy.distance.HaversineDistanceStrategy;

public class SimilarityStrategyFactory {

    public static final String BY_PREFIX = "BY_PREFIX";

    public DistanceStrategy getStrategy(String strategyType) {
        if(BY_PREFIX.equals(strategyType)) {
            return new HaversineDistanceStrategy();
        }
        throw new IllegalArgumentException("Invalid type of strategy " + strategyType);
    }
}
