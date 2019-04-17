package com.coveo.challenge.io;

import com.coveo.challenge.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CitiesDataSource extends DataSource<City> {

    private final LineParser<City> cityLineParser;

    @Autowired
    CitiesDataSource(@Qualifier("cityLineParser") LineParser<City> cityLineParser) {
        this.cityLineParser = cityLineParser;
    }

    @Override
    protected String getFileName() {
        return "data/cities_canada-usa.tsv";
    }

    @Override
    protected LineParser<City> getLineParser() {
        return cityLineParser;
    }
}
