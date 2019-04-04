package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.springframework.stereotype.Component;

import static org.apache.commons.math3.util.FastMath.*;


@Component
public class DistanceScoreCalculator {

    private static final double EARTH_RADIUS_IN_KM = 6371.0;
    // Validation
    // latitude must be [-90, 90]
    // longitude must be [-180, 80]

    public double calculate(Point start, Point end) {
        return rescale(distance(start, end));
    }

    // Haversine formula
    // http://www.movable-type.co.uk/scripts/latlong.html
    private double distance(Point start, Point end) {
        double startLatToRad = toRadians(start.getLatitude());
        double startLongToRad = toRadians(start.getLongitude());
        double endLatToRad = toRadians(end.getLatitude());
        double endLongToRad = toRadians(end.getLongitude());

        double a = haversin(startLatToRad, endLatToRad)
                + cos(startLatToRad)
                * cos(endLatToRad)
                * haversin(startLongToRad, endLongToRad);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return EARTH_RADIUS_IN_KM * c;
    }

    private double haversin(double start, double end) {
        return pow(sin((end - start) / 2), 2);
    }

    // https://en.wikipedia.org/wiki/Feature_scaling#Rescaling_(min-max_normalization)
    private double rescale(double distance) {
        return 1 - (distance / EARTH_RADIUS_IN_KM);
    }
}
