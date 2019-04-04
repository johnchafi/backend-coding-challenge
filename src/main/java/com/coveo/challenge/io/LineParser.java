package com.coveo.challenge.io;

import com.coveo.challenge.model.Suggestion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LineParser {

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String LIST_SEPARATOR = ",";

    public Suggestion parse(String line) {
        String[] values = StringUtils.split(line, COLUMN_SEPARATOR);
        String name = values[1];
        String[] alternateName = StringUtils.split(values[2], LIST_SEPARATOR);
        Double latitude = Double.parseDouble(values[4]);
        Double longitude = Double.parseDouble(values[5]);
        String countryCode = values[8];
        String adminCode = values[10];
        //BigInteger population = new BigInteger(values[14]);

        return new Suggestion();
    }

    private double calculateNameScore(String name, String[] alternateNames) {
        return 0.0;
    }

    // Abstract
    // if latitude and longitude
    private double calculateDistanceScore(double latitude, double longitude) {
        return 0.0;
    }
}
