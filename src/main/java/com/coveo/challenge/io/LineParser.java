package com.coveo.challenge.io;

import com.coveo.challenge.model.City;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class LineParser {

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String LIST_SEPARATOR = ",";

    public City parse(String line) {
        String[] values = StringUtils.split(line, COLUMN_SEPARATOR);
        String name = values[1];
        String[] alternateNames = StringUtils.split(values[2], LIST_SEPARATOR);
        Double latitude = new Double(values[4]);
        Double longitude = new Double(values[5]);
        String countryCode = values[8];
        String adminCode = values[10];
        BigInteger population = new BigInteger(values[14]);
        return City.builder()
                .name(name)
                .alternateNames(alternateNames)
                .latitude(latitude)
                .longitude(longitude)
                .countryCode(countryCode) // TODO: Parse code (United States or Canada)
                .adminCode(adminCode) // TODO: Parse code (provinces or states)
                .population(population)
                .build();
    }


}
