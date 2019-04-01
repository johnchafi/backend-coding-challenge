package com.coveo.challenge.math;

import com.coveo.challenge.io.Point;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DistanceCalculatorTest {

    private DistanceCalculator underTest;

    @Before
    public void setUp() {
        underTest = new DistanceCalculator();
    }

    @Test
    public void whenCalcule_givenStartAndEnd_thenReturnExpectedDistance() {
        Point start = point(50.345, -113.3867);
        Point end = point(51.25789, -115.75607);

        double expected = 195.0;
        double actual = underTest.calculate(start, end);

        assertThat(actual).isEqualTo(expected);
    }

    private Point point(double latitude, double longitude) {
        return Point.builder()
                .latitude(latitude)
                .longitude(longitude).build();
    }


} 
