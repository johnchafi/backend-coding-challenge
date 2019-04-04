package com.coveo.challenge.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class City {

    private Integer id;

    private String name;

    private List<String> alternateNames;

    private Point geographicalCoordinates;

    private String country;

    private Double nameScore;

    private Double alternateNamesScore;

    private Double distanceScore;
}
