package com.coveo.challenge.calculator;

import com.coveo.challenge.calculator.strategy.distance.DistanceStrategy;
import com.coveo.challenge.calculator.strategy.distance.DistanceStrategyFactory;
import com.coveo.challenge.model.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DistanceScoreCalculatorTest {

    private static final Double DISTANCE_LESS_THAN_THRESHOLD = 123.54309;
    private static final Double DISTANCE_GREATER_THAN_THRESHOLD = 228.9456;
    private static final Point START = new Point(34.5, 76.0);
    private static final Point END = new Point(67.098, 54.6);

    @InjectMocks
    private DistanceScoreCalculator underTest;

    @Mock
    private DistanceStrategyFactory distanceStrategyFactory;

    @Test
    public void whenCalculate_givenDistanceLessThanThreshold_thenReturnExpectedDistance() {
        DistanceStrategy distanceStrategy = mock(DistanceStrategy.class);
        when(distanceStrategy.distance(START, END)).thenReturn(DISTANCE_LESS_THAN_THRESHOLD);
        when(distanceStrategyFactory.getStrategy(DistanceStrategyFactory.HAVERSINE)).thenReturn(distanceStrategy);

        double expected = 0.38;

        double actual = underTest.calculate(START, END);

        assertThat(actual).isEqualTo(expected);
        verify(distanceStrategyFactory).getStrategy(DistanceStrategyFactory.HAVERSINE);
    }

    @Test
    public void whenCalculate_givenDistanceGreaterThanThreshold_thenReturnExpectedDistance() {
        DistanceStrategy distanceStrategy = mock(DistanceStrategy.class);
        when(distanceStrategy.distance(START, END)).thenReturn(DISTANCE_GREATER_THAN_THRESHOLD);
        when(distanceStrategyFactory.getStrategy(DistanceStrategyFactory.HAVERSINE)).thenReturn(distanceStrategy);

        double expected = 0.0;

        double actual = underTest.calculate(START, END);

        assertThat(actual).isEqualTo(expected);
        verify(distanceStrategyFactory).getStrategy(DistanceStrategyFactory.HAVERSINE);
    }

} 
