package com.coveo.challenge.io;

import com.coveo.challenge.converter.AdminCodeConverter;
import com.coveo.challenge.converter.CountryConverter;
import com.coveo.challenge.model.AdminCode;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Country;
import com.coveo.challenge.model.Point;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LineParser {

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String LIST_SEPARATOR = ",";

    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private AdminCodeConverter adminCodeConverter;

    public City parse(String line) {
        line = line.replaceAll("\t\t", "\t \t");
        String[] values = StringUtils.split(line, COLUMN_SEPARATOR);
        String name = values[1];
        String[] alternateNames = StringUtils.split(values[2], LIST_SEPARATOR);
        Double latitude = new Double(values[4]);
        Double longitude = new Double(values[5]);
        Country country = countryConverter.convertToY(values[8]);
        AdminCode adminCode = adminCodeConverter.convertToY(values[10]);
        return City.builder()
                .name(name)
                .alternateNames(alternateNames)
                .coordinates(new Point(latitude, longitude))
                .country(country)
                .adminCode(adminCode).build();
    }
}
