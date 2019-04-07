package com.coveo.challenge.calculator;

import com.coveo.challenge.model.City;
import com.coveo.challenge.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.math3.util.Precision.round;

@Component
public class CityScoreCalculator {

    @Autowired
    private NameScoreCalculator nameScoreCalculator;

    @Autowired
    private DistanceScoreCalculator distanceScoreCalculator;

    public double calculate(String searchWord, Double latitude, Double longitude, City city) {
        double distanceScore = 0.0;
        double score = nameScoreCalculator.calculate(searchWord, city.getName());
        double totalScore = score;

        if(totalScore > 0.0 && latitude != null && longitude != null) {
            distanceScore = distanceScoreCalculator.calculate(
                    new Point(latitude, longitude),
                    city.getCoordinates());
            totalScore = (totalScore + distanceScore) / 2;
        }

        return round(totalScore, 2);
    }

}
