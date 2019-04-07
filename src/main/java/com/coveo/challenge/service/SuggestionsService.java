package com.coveo.challenge.service;

import com.coveo.challenge.calculator.CityScoreCalculator;
import com.coveo.challenge.io.LineParser;
import com.coveo.challenge.io.ResourceProvider;
import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Suggestion;
import com.coveo.challenge.model.Suggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX;
import static org.apache.commons.lang3.StringUtils.split;

@Service
public class SuggestionsService {

    private static final String CITIES_FILENAME = "data/cities_canada-usa.tsv";

    @Autowired
    private ResourceProvider resourceProvider;

    @Autowired
    private LineParser lineParser;

    @Autowired
    private CityScoreCalculator cityScoreCalculator;

    public Suggestions call(String query, Double latitude, Double longitude) throws IOException {
        List<Suggestion> suggestions = getSuggestions(query, latitude, longitude);
        return Suggestions.builder()
                .suggestions(suggestions)
                .build();
    }

    private List<Suggestion> getSuggestions(String query, Double latitude, Double longitude) throws IOException {
        String content = resourceProvider.resourceAsString(CITIES_FILENAME);
        String[] lines = split(content, LINE_SEPARATOR_UNIX);
        return Arrays.stream(lines)
                .skip(1)
                .map(line -> getSuggestion(line, query, latitude, longitude))
                .filter(city -> city.getScore() > 0.0)
                .sorted(Comparator.comparing(city -> city.getScore(), Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    private Suggestion getSuggestion(String line, String query, Double latitude, Double longitude) {
        City city = lineParser.parse(line);
        double totalScore = cityScoreCalculator.calculate(query, latitude, longitude, city);

        return Suggestion.builder()
                .name(city.getName())
                .latitude(city.getCoordinates().getLatitude())
                .longitude((city.getCoordinates().getLongitude()))
                .score(totalScore)
                .build();
    }

}
