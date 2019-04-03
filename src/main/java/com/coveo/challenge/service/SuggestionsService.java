package com.coveo.challenge.service;

import com.coveo.challenge.model.Suggestions;
import org.springframework.stereotype.Component;

@Component
public class SuggestionsService {

    public Suggestions search(String query, Double latitude, Double longitude) {
        return Suggestions.builder().build();
    }
}
