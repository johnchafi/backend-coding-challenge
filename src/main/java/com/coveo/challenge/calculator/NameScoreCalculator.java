package com.coveo.challenge.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.math3.util.Precision.round;

public class NameScoreCalculator {

    public double calculate(String query, String name, List<String> alternateNames) {
        String normalizedQuery = normalize(query);
        String normalizedName = normalize(name);

        if(StringUtils.equals(normalizedQuery, normalizedName)) {
            return 1.0;
        }

        if(startsWith(normalizedName, normalizedQuery)) {
            String commonPrefix = getCommonPrefix(normalizedQuery, normalizedName);
            if (isBlank(commonPrefix)) {
                return 0.0;
            }

            Integer commonPrefixLength = length(commonPrefix);
            Integer longestLength = longestLength(normalizedQuery, normalizedName);

            Double distance = commonPrefixLength.doubleValue() / longestLength.doubleValue();

            return round(distance, 2);
        }

        return 0.0;
    }

    private int longestLength (String str1, String str2) {
        int length1 = length(str1);
        int length2 = length(str2);
        return length1 >= length2 ? length1 : length2;
    }

    private String normalize(String str) {
        String normalizedStr = " " + upperCase(str) + " ";
        normalizedStr = stripAccents(normalizedStr);

        if (isNotBlank(normalizedStr)) {
            normalizedStr = normalizedStr.replaceAll("[-\\.,]", " ");
            normalizedStr = normalizedStr.replaceAll("'", " ");
            normalizedStr = normalizedStr.replaceAll("[^a-zA-Z\\s]", " ");
            normalizedStr = normalizedStr.replaceAll("\\s[a-z]\\s", " ");
        }

        normalizedStr = trimToNull(normalizedStr);
        return normalizeSpace(normalizedStr);
    }
}
