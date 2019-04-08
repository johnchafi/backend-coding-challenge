package com.coveo.challenge.calculator;


import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.apache.commons.math3.util.Precision.round;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CityScoreCalculatorTest {

    private static final String SEARCH_WORD = "word";
    private static final Double ANY_LATITUDE = 45.284;
    private static final Double ANY_LONGITUDE = -77.0879;
    private static final String CITY_NAME = "city";
    private static final Double CITY_LATITUDE = 45.6897;
    private static final Double CITY_LONGITUDE = -75.603;

    @InjectMocks
    private CityScoreCalculator underTest;

    @Mock
    private NameScoreCalculator nameScoreCalculator;

    @Mock
    private DistanceScoreCalculator distanceScoreCalculator;

    @Test
    public void whenCalculate_givenNoCorrespondence_thenShouldReturnZero() {
        City city = city();
        when(nameScoreCalculator.calculate(SEARCH_WORD, CITY_NAME)).thenReturn(0.0);

        double actual = underTest.calculate(SEARCH_WORD, ANY_LATITUDE, ANY_LONGITUDE, city);

        assertThat(actual).isEqualTo(0.0);
        verify(distanceScoreCalculator, never()).calculate(any(Point.class), any(Point.class));
    }

    @Test
    public void whenCalculate_givenNoSearchCoords_thenShouldReturnNameScore() {
        City city = city();
        when(nameScoreCalculator.calculate(SEARCH_WORD, CITY_NAME)).thenReturn(0.5);

        double actual = underTest.calculate(SEARCH_WORD, null, null, city);

        assertThat(actual).isEqualTo(0.5);
        verify(nameScoreCalculator).calculate(SEARCH_WORD, CITY_NAME);
        verify(distanceScoreCalculator, never()).calculate(any(Point.class), any(Point.class));
    }

    @Test
    public void whenCalculate_givenAllSearchArgs_thenShouldReturnExpectedScore() {
        City city = city();
        when(nameScoreCalculator.calculate(SEARCH_WORD, CITY_NAME)).thenReturn(0.5);
        when(distanceScoreCalculator.calculate(any(Point.class), any(Point.class))).thenReturn(0.75);

        double expected = round((0.5 + 0.75) / 2, 2);

        double actual = underTest.calculate(SEARCH_WORD, ANY_LATITUDE, ANY_LONGITUDE, city);

        assertThat(actual).isEqualTo(expected);
        verify(nameScoreCalculator).calculate(SEARCH_WORD, CITY_NAME);
        verify(distanceScoreCalculator).calculate(any(Point.class), any(Point.class));
    }

    private City city() {
        return City.builder()
                .name(CITY_NAME)
                .coordinates(new Point(CITY_LATITUDE, CITY_LONGITUDE))
                .build();
    }

}