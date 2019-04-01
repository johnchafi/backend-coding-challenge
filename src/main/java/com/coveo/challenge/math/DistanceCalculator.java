package com.coveo.challenge.math;

import static java.lang.Math.*;


public class DistanceCalculator {

    private static final double EARTH_RADIUS_IN_KM = 6371.0;

    // Haversine formula
    // http://www.movable-type.co.uk/scripts/latlong.html
    public double calculate(Point start, Point end) {
        double latDistance = distanceInRadians(start.getLatitude(), end.getLatitude());
        double longDistance = distanceInRadians(start.getLongitude(), end.getLongitude());

        double startLatInRadians = toRadians(start.getLatitude());
        double endLatInRadians = toRadians(end.getLatitude());

        double a = haversine(latDistance) + cos(startLatInRadians) * cos(endLatInRadians) * haversine(longDistance);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return round(EARTH_RADIUS_IN_KM * c);
    }

    private double distanceInRadians(double start, double end) {
        return toRadians(end - start);
    }

    private double haversine(double val) {
        return pow(sin(val / 2), 2);
    }
}
