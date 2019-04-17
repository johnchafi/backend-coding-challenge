package com.coveo.challenge.converter;

import com.coveo.challenge.model.Country;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class CountryConverterTest {

    private final CountryConverter underTest = new CountryConverter();

    @Test
    public void whenConvertToY_givenCountryCodes_thenShouldReturnExpectedCountry() {
        Arrays.stream(Country.values()).forEach(v -> assertStringValue(v.getCode(), v));
    }

    @Test
    public void whenConvertToY_givenCountryNamesthenShouldReturnExpectedCountry() {
        Arrays.stream(Country.values()).forEach(v -> assertStringValue(v.getFullName(), v));
    }

    @Test
    public void whenConvertToX_givenCountry_thenShouldReturnExpectedString() {
        Arrays.stream(Country.values()).forEach(v -> assertCountryValue(v, v.getFullName()));
    }

    private void assertStringValue(String value, Country expected) {
        Country actual = underTest.convertToY(value);
        assertThat(actual).isEqualTo(expected);
    }

    private void assertCountryValue(Country value, String expected) {
        String actual = underTest.convertToX(value);
        assertThat(actual).isEqualTo(expected);
    }
}