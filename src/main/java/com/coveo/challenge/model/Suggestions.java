package com.coveo.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Suggestions {

    @Builder.Default
    @JsonProperty(value = "suggestions")
    private List<Suggestion> suggestions = new ArrayList<>();
}
