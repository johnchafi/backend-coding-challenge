package com.coveo.challenge.calculator.strategy.distance;

import com.coveo.challenge.model.Point;

public interface DistanceStrategy {

    double distance(Point start, Point end);

}
