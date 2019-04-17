package com.coveo.challenge.converter;

import com.coveo.challenge.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.equalsAny;

@Component
public class CountryConverter implements Converter<String, Country> {

    @Override
    public String convertToX(Country value) {
        return value.getFullName();
    }

    @Override
    public Country convertToY(String value) {
        return Arrays.stream(Country.values())
                .filter(v -> equalsAny(value, v.getCode(), v.getFullName()))
                .findAny().orElse(null);
    }

}
