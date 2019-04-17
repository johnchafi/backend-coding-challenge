package com.coveo.challenge.calculator.strategy.distance;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DistanceStrategyFactoryTest {

    private final DistanceStrategyFactory underTest = new DistanceStrategyFactory();

    @Test(expected = IllegalArgumentException.class)
    public void whenGetStrategy_givenInvalidStrategy_thenShouldThrowException() {
        underTest.getStrategy("invalid");
    }

    @Test
    public void whenGetStrategy_givenValidStrategy_thenShouldThrowException() {
        DistanceStrategy actual = underTest.getStrategy(DistanceStrategyFactory.HAVERSINE);
        assertThat(actual).isNotNull();
        assertThat(actual).isInstanceOf(HaversineDistanceStrategy.class);
    }

}