package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;

public interface DistanceStrategy {

    double calculate(Point start, Point end);

}
