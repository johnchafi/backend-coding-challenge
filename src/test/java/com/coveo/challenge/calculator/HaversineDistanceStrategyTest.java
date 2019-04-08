package com.coveo.challenge.calculator;

import com.coveo.challenge.calculator.strategy.distance.DistanceStrategy;
import com.coveo.challenge.calculator.strategy.distance.HaversineDistanceStrategy;
import com.coveo.challenge.model.Point;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class HaversineDistanceStrategyTest {

    private DistanceStrategy underTest = new HaversineDistanceStrategy();

    @Test
    public void whenCalculate_givenTwoPoints_thenShouldReturnExpectedDistance() {
        Point start = new Point(-41.369874, 73.436958);
        Point end = new Point(-45.753, 72.14789);
        double expected = 498.30647940862036;
        double actual = underTest.distance(start, end);
        assertThat(actual).isEqualTo(expected);
    }

}