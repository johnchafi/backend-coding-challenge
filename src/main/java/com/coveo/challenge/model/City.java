package com.coveo.challenge.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class City {

    private String name;

    private String[] alternateNames;

    private Point geographicalCoordinates;

    private String countryCode;

    private String adminCode;

    private BigInteger population;

    private Double nameScore;

    private Double alternateNamesScore;

    private Double distanceScore;
}
