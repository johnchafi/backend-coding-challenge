package com.coveo.challenge.calculator.strategy.distance;

import com.coveo.challenge.model.Point;

import static org.apache.commons.math3.util.FastMath.*;

public class HaversineDistanceStrategy implements DistanceStrategy {

    private static final double EARTH_RADIUS_IN_KM = 6371.0;

    @Override
    public double distance(Point start, Point end) {
        return compute(start, end);
    }

    // Haversine formula
    // http://www.movable-type.co.uk/scripts/latlong.html
    private double compute(Point start, Point end) {
        double startLatToRad = toRadians(start.getLatitude());
        double startLongToRad = toRadians(start.getLongitude());
        double endLatToRad = toRadians(end.getLatitude());
        double endLongToRad = toRadians(end.getLongitude());

        double a = haversine(startLatToRad, endLatToRad)
                + cos(startLatToRad)
                * cos(endLatToRad)
                * haversine(startLongToRad, endLongToRad);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return EARTH_RADIUS_IN_KM * c;
    }

    private double haversine(double start, double end) {
        return pow(sin((end - start) / 2), 2);
    }
}
