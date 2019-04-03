package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.apache.commons.math3.util.Precision.round;

public class DistanceScoreCalculatorTest {

    private DistanceScoreCalculator underTest;

    @Before
    public void setUp() {
        underTest = new DistanceScoreCalculator();
    }

    @Test
    public void whenCalculate_givenStartAndEnd_thenReturnExpectedDistance() {
        // https://www.vcalc.com/wiki/vCalc/Haversine+-+Distance
        // 1 - (231.850382 / 6371.0)
        Point start = new Point(45.508889, -73.561667);
        Point end = new Point(46.816667, -71.216667);

        double expected = round(1 - (231.850382 / 50.0), 2);

        double actual = underTest.calculate(start, end);

        assertThat(actual).isEqualTo(expected);
    }

    private Point point(double latitude, double longitude) {
        return new Point(latitude, longitude);
    }


} 
