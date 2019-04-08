package com.coveo.challenge.suggestion;

import com.coveo.challenge.calculator.CityScoreCalculator;
import com.coveo.challenge.io.LineParser;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuggestionFinder {

    @Autowired
    private LineParser lineParser;

    @Autowired
    private CityScoreCalculator cityScoreCalculator;

    public Suggestion getSuggestion(String line, String query, Double latitude, Double longitude) {
        City city = lineParser.parse(line);
        double totalScore = cityScoreCalculator.calculate(query, latitude, longitude, city);

        return Suggestion.builder()
                .name(city.getFullName())
                .latitude(city.getCoordinates().getLatitude())
                .longitude((city.getCoordinates().getLongitude()))
                .score(totalScore)
                .build();
    }


}
