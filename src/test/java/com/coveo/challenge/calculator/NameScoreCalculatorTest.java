package com.coveo.challenge.calculator;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NameScoreCalculatorTest {

    private NameScoreCalculator underTest = new NameScoreCalculator();

    @Test
    public void whenCalculate_givenSameWord_thenShouldReturnExpected() {
        executeTest("london", "London", 1.0);
    }

    @Test
    public void whenCalculate_givenPartialWord_thenShouldReturnExpected() {
        executeTest("mont", "Montréal", 0.5);
    }

    @Test
    public void whenCalculate_givenNotSameWord_thenShouldReturnExpected() {
        executeTest("mont", "Quebec", 0.0);
    }

    @Test
    public void whenCalculate_givenWordWithGreaterLength_thenShouldReturnExpected() {
        executeTest("almaq", "Alma", 0.8);
    }

    private void executeTest(String query, String name, double expected) {
        double actual = underTest.calculate(query, name);
        assertThat(actual).isEqualTo(expected);
    }


}

