package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.math3.util.Precision.round;

@Component
public class DistanceScoreCalculator {

    private static final double DISTANCE_THRESHOLD = 500.0;

    @Autowired
    private DistanceStrategyFactory distanceStrategyFactory;

    public double calculate(Point start, Point end) {
        DistanceStrategy distanceStrategy = distanceStrategyFactory.getStrategy(DistanceStrategyFactory.HAVERSINE);
        double distance = distanceStrategy.calculate(start, end);
        return rescale(distance);
    }

    // https://en.wikipedia.org/wiki/Feature_scaling#Rescaling_(min-max_normalization)
    private double rescale(double distance) {
        if(distance <= DISTANCE_THRESHOLD) {
            return round(1 - (distance / DISTANCE_THRESHOLD), 2);
        }
        return 0.0;
    }
}
