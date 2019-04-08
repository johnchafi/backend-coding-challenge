package com.coveo.challenge.calculator;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DistanceStrategyFactoryTest {

    private DistanceStrategyFactory underTest = new DistanceStrategyFactory();

    @Test(expected = IllegalArgumentException.class)
    public void whenGetStrategy_givenInvalidStatregyType_thenShouldThrowException() {
        underTest.getStrategy("invalid");
    }

    @Test
    public void whenGetStrategy_givenValidStatregyType_thenShouldReturnExpectedStrategy() {
        DistanceStrategy actual = underTest.getStrategy(DistanceStrategyFactory.HAVERSINE);
        assertThat(actual).isNotNull();
        assertThat(actual).isInstanceOf(HaversineDistanceStrategy.class);
    }

}