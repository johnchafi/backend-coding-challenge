package com.coveo.challenge.service;

import com.coveo.challenge.io.CitiesDataSource;
import com.coveo.challenge.model.Suggestion;
import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.suggestion.SuggestionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Service
public class SuggestionsService {

    private final SuggestionResolver suggestionResolver;

    private final CitiesDataSource citiesDataSource;

    @Autowired
    SuggestionsService(SuggestionResolver suggestionResolver, CitiesDataSource citiesDataSource) {
        this.suggestionResolver = suggestionResolver;
        this.citiesDataSource = citiesDataSource;
    }

    public Suggestions call(String query, Double latitude, Double longitude) throws IOException {
        List<Suggestion> suggestions = getSuggestions(query, latitude, longitude);
        return Suggestions.builder().suggestions(suggestions).build();
    }

    private List<Suggestion> getSuggestions(String query, Double latitude, Double longitude) throws IOException {
        return citiesDataSource.getElements().stream()
                .map(city -> suggestionResolver.getSuggestion(city, query, latitude, longitude))
                .filter(scoreGreaterThanZero())
                .sorted(sortedByScoreDesc())
                .collect(toList());
    }

    private Predicate<Suggestion> scoreGreaterThanZero() {
        return suggestion -> suggestion.getScore() > 0.0;
    }

    private Comparator<Suggestion> sortedByScoreDesc() {
        return Comparator.comparing(suggestion -> suggestion.getScore(), Comparator.reverseOrder());
    }





}
