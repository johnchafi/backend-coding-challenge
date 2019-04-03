package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import static org.apache.commons.math3.util.FastMath.*;


@Component
public class DistanceScoreCalculator {

    private static final double EARTH_RADIUS_IN_KM = 6371.0;
    private static final double CLOSE_DISTANCE = 50.0;
    private static final int PRECISION_SCALE = 2;
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

        return Precision.round(EARTH_RADIUS_IN_KM * c, PRECISION_SCALE);
    }

    private double haversin(double start, double end) {
        double distance = toRadians(end) - toRadians(start);
        return pow(sin(distance / 2), 2);
    }

    // https://en.wikipedia.org/wiki/Feature_scaling#Rescaling_(min-max_normalization)
    private double rescale(double distance) {
        return Precision.round(1 - (distance / CLOSE_DISTANCE), PRECISION_SCALE);
    }
}
