package com.coveo.challenge.calculator;

import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.apache.commons.math3.util.Precision.round;

@@Component
public class CityScoreCalculator {

    @Autowired
    private NameScoreCalculator nameScoreCalculator;

    @Autowired
    private DistanceScoreCalculator distanceScoreCalculator;

    public double calculate(String searchWord, City city) {
        double nameScore = nameScoreCalculator.calculate(searchWord, city.getName());
        double altNamesScore = Arrays.stream(city.getAlternateNames())
                .mapToDouble(altName -> nameScoreCalculator.calculate(searchWord, altName))
                .average()
                .orElse(0.0);
        return round((nameScore + altNamesScore) / 2, 2);
    }

    public double calculate(String searchWord, Point searchPoint, City city) {
        double nameScore = calculate(searchWord, city);
        double distanceScore = distanceScoreCalculator.calculate(searchPoint, city.getCoordinates());
        return round((nameScore + distanceScore) / 2, 2);
    }
}
