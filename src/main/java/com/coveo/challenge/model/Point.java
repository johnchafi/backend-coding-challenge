package com.coveo.challenge.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point {

    private double latitude;

    private double longitude;

}
