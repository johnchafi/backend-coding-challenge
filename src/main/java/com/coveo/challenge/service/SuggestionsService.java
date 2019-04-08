package com.coveo.challenge.service;

import com.coveo.challenge.io.ResourceProvider;
import com.coveo.challenge.model.Suggestion;
import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.suggestion.SuggestionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX;
import static org.apache.commons.lang3.StringUtils.split;

@Service
public class SuggestionsService {

    private static final String CITIES_FILENAME = "data/cities_canada-usa.tsv";

    @Autowired
    private ResourceProvider resourceProvider;

    @Autowired
    private SuggestionResolver suggestionResolver;

    public Suggestions call(String query, Double latitude, Double longitude) throws IOException {
        List<Suggestion> suggestions = getSuggestions(query, latitude, longitude);
        return Suggestions.builder().suggestions(suggestions).build();
    }

    private List<Suggestion> getSuggestions(String query, Double latitude, Double longitude) throws IOException {
        return Arrays.stream(lines())
                .skip(1)
                .map(line -> suggestionResolver.getSuggestion(line, query, latitude, longitude))
                .filter(scoreGreaterThanZero())
                .sorted(sortedByScoreDesc())
                .collect(toList());
    }

    private String[] lines() throws IOException {
        String content = resourceProvider.resourceAsString(CITIES_FILENAME);
        return split(content, LINE_SEPARATOR_UNIX);
    }

    private Predicate<Suggestion> scoreGreaterThanZero() {
        return suggestion -> suggestion.getScore() > 0.0;
    }

    private Comparator<Suggestion> sortedByScoreDesc() {
        return Comparator.comparing(suggestion -> suggestion.getScore(), Comparator.reverseOrder());
    }





}
