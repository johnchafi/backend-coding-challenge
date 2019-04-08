package com.coveo.challenge.calculator;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NameScoreCalculatorTest {

    private NameScoreCalculator underTest = new NameScoreCalculator();

    @Test
    public void whenCalculate_givenSameWord_thenShouldReturnExpected() {
        String query = "london";
        String name = "London";
        double expected = 1.0;
        double actual = underTest.calculate(query, name);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenCalculate_givenPartialWord_thenShouldReturnExpected() {
        String query = "mont";
        String name = "Montréal";
        double expected = 0.5;
        double actual = underTest.calculate(query, name);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenCalculate_givenNotSameWord_thenShouldReturnExpected() {
        String query = "mont";
        String name = "Quebec";
        double expected = 0.0;
        double actual = underTest.calculate(query, name);
        assertThat(actual).isEqualTo(expected);
    }


}

