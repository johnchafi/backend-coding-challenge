package com.coveo.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"name", "latitude", "longitude", "score"})
public class Suggestion {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "latitude")
    private Double latitude;

    @JsonProperty(value = "longitude")
    private Double longitude;

    @JsonProperty(value = "score")
    private Double score;

}
