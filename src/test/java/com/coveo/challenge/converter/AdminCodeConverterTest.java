package com.coveo.challenge.converter;

import com.coveo.challenge.model.AdminCode;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class AdminCodeConverterTest {

    private final AdminCodeConverter underTest = new AdminCodeConverter();

    @Test
    public void whenConvertToY_givenCountryCodes_thenShouldReturnExpectedCountry() {
        Arrays.stream(AdminCode.values()).forEach(v -> assertStringValue(v.getCode(), v));
    }

    @Test
    public void whenConvertToY_givenCountryNamesthenShouldReturnExpectedCountry() {
        Arrays.stream(AdminCode.values()).forEach(v -> assertStringValue(v.getFullName(), v));
    }

    @Test
    public void whenConvertToX_givenCountry_thenShouldReturnExpectedString() {
        Arrays.stream(AdminCode.values()).forEach(v -> assertCountryValue(v, v.getFullName()));
    }

    private void assertStringValue(String value, AdminCode expected) {
        AdminCode actual = underTest.convertToY(value);
        assertThat(actual).isEqualTo(expected);
    }

    private void assertCountryValue(AdminCode value, String expected) {
        String actual = underTest.convertToX(value);
        assertThat(actual).isEqualTo(expected);
    }

}