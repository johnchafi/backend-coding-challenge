package com.coveo.challenge.suggestion;

import com.coveo.challenge.calculator.SuggestionScoreCalculator;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuggestionResolver {

    private final SuggestionScoreCalculator suggestionScoreCalculator;

    @Autowired
    SuggestionResolver(SuggestionScoreCalculator suggestionScoreCalculator) {
        this.suggestionScoreCalculator = suggestionScoreCalculator;
    }

    public Suggestion getSuggestion(City city, String query, Double latitude, Double longitude) {
        double totalScore = suggestionScoreCalculator.calculate(query, latitude, longitude, city);
        return Suggestion.builder()
                .name(city.getFullName())
                .latitude(city.getCoordinates().getLatitude())
                .longitude((city.getCoordinates().getLongitude()))
                .score(totalScore)
                .build();
    }

}
