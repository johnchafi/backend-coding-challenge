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

    public double calculate(String searchWord, Double searchLatitude, Double searchLongitude, City city) {
        double totalScore = nameScoreCalculator.calculate(searchWord, city.getName());

        if(totalScore > 0.0 && searchLatitude != null && searchLongitude != null) {
            totalScore = totalScoreWithDistance(new Point(searchLatitude, searchLongitude),
                    city.getCoordinates(),
                    totalScore);
        }

        return round(totalScore, 2);
    }

    private double totalScoreWithDistance(Point searchPoint, Point point, double score) {
        double distanceScore = distanceScoreCalculator.calculate(searchPoint, point);
        return (score + distanceScore) / 2;
    }

}
