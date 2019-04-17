package com.coveo.challenge.io;

import com.coveo.challenge.converter.AdminCodeConverter;
import com.coveo.challenge.converter.CountryConverter;
import com.coveo.challenge.model.AdminCode;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Country;
import com.coveo.challenge.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

@Component("cityLineParser")
public class CityLineParser implements LineParser<City> {

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String LIST_SEPARATOR = ",";

    private static final int NAME_COLUMN = 1;
    private static final int ALT_NAMES_COLUMN = 3;
    private static final int LATITUDE_COLUMN = 4;
    private static final int LONGITUDE_COLUMN = 5;
    private static final int COUNTRY_COLUMN = 8;
    private static final int ADMIN_1_COLUMN = 10;

    private final CountryConverter countryConverter;

    private final AdminCodeConverter adminCodeConverter;

    @Autowired
    public CityLineParser(CountryConverter countryConverter,
                          AdminCodeConverter adminCodeConverter) {
        this.countryConverter = countryConverter;
        this.adminCodeConverter = adminCodeConverter;
    }

    @Override
    public City parse(String line) {
        line = line.replaceAll("\t\t", "\t \t");

        String[] values = split(line, COLUMN_SEPARATOR);
        String name = values[NAME_COLUMN];
        String[] alternateNames = split(trimToEmpty(values[ALT_NAMES_COLUMN]), LIST_SEPARATOR);
        Double latitude = new Double(values[LATITUDE_COLUMN]);
        Double longitude = new Double(values[LONGITUDE_COLUMN]);
        Country country = countryConverter.convertToY(values[COUNTRY_COLUMN]);
        AdminCode adminCode = adminCodeConverter.convertToY(values[ADMIN_1_COLUMN]);

        return City.builder()
                .name(name)
                .alternateNames(alternateNames)
                .coordinates(new Point(latitude, longitude))
                .country(country)
                .adminCode(adminCode).build();
    }
}
