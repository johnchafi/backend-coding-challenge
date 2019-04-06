package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;

public interface DistanceComputationStrategy {

    double calculate(Point start, Point end);
}
