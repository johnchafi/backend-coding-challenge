package com.coveo.challenge.converter;

import com.coveo.challenge.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.equalsAny;

@Component
public class CountryConverter implements Converter<String, Country> {

    @Override
    public String convertToX(Country value) {
        return value.getFullName();
    }

    @Override
    public Country convertToY(String value) {
        Optional<Country> countryFound = Arrays.stream(Country.values())
                .filter(v -> equalsAny(v.getCode(), v.getFullName()))
                .findFirst();
        return countryFound.isPresent() ? countryFound.get() : null;
    }

}