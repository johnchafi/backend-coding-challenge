package com.coveo.challenge.service;

import com.coveo.challenge.model.Suggestions;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class SuggestionsService {

    private static final String ERROR_MESSAGE_TEMPLATE = "when %s is not null then %s should not be null";

    public Suggestions call(String query, Double latitude, Double longitude) {
        checkArgument(latitude != null && longitude == null, ERROR_MESSAGE_TEMPLATE, "latitude", "longitude");
        checkArgument(longitude != null && latitude == null, ERROR_MESSAGE_TEMPLATE, "longitude", "latitude");

        if(latitude != null) {
            return search(query, latitude, longitude);
        }

        return search(query);
    }

    private Suggestions search(String query) {
        return Suggestions.builder().build();
    }

    private Suggestions search(String query, Double latitude, Double longitude) {
        return Suggestions.builder().build();
    }
}
