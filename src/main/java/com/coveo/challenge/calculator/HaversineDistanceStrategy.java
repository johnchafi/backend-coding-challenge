package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.math3.util.FastMath.*;
import static org.apache.commons.math3.util.FastMath.sqrt;

@Component
public class HaversineDistanceStrategy implements DistanceStrategy {

    private static final double EARTH_RADIUS_IN_KM = 6371.0;

    @Override
    public double calculate(Point start, Point end) {
        return 0;
    }

    // Haversine formula
    // http://www.movable-type.co.uk/scripts/latlong.html
    private double distance(Point start, Point end) {
        checkArgument(start == null, "start must not be null");
        checkArgument(end == null, "end must not be null");

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
