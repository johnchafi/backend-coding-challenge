package com.coveo.challenge.calculator;

import com.coveo.challenge.model.Point;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DistanceScoreCalculatorTest {

    private DistanceScoreCalculator underTest = new DistanceScoreCalculator();

    @Test
    public void whenCalculate_givenStartAndEnd_thenReturnExpectedDistance() {
        double latA = 43.70011;//45.508889;
        double longA = -79.416;//-73.561667;
        double latB = 42.98339;//46.816667;
        double longB = -81.23304;//-71.216667;
        double score = 0.07;
        Point start = new Point(latA, longA);
        Point end = new Point(latB, longB);

        double actual = underTest.calculate(start, end);

        assertThat(actual).isEqualTo(score);
    }

} 
