package com.coveo.challenge.service;

import com.coveo.challenge.model.Suggestions;
import org.springframework.stereotype.Service;

@Service
public class SuggestionsService {

    public Suggestions call(String query, Double latitude, Double longitude) {
        if(latitude != null) {
            return extendedSearch(query, latitude, longitude);
        }

        return simpleSearch(query);
    }

    private Suggestions simpleSearch(String query) {
        return Suggestions.builder().build();
    }

    private Suggestions extendedSearch(String query, Double latitude, Double longitude) {
        return Suggestions.builder().build();
    }
}
