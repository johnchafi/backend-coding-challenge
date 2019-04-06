package com.coveo.challenge.calculator;

import com.google.common.collect.Lists;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class NameScoreCalculatorTest {

    private NameScoreCalculator underTest = new NameScoreCalculator();

    @Test
    public void test() {
        String query = "Londo";
        String name = "London";
        double expected = 1.0;
        double actual = underTest.calculate(query, name, Lists.newArrayList());
        assertThat(actual).isEqualTo(expected);
    }

}

