package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.springframework.stereotype.Component;

import static org.apache.commons.math3.util.Precision.round;

@Component
public class DistanceScoreCalculator {

    private static final double DISTANCE_THRESHOLD = 500.0;

    // Validation
    // latitude must be [-90, 90]
    // longitude must be [-180, 80]

    public double calculate(Point start, Point end, DistanceComputationStrategy distanceStrategy) {
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
