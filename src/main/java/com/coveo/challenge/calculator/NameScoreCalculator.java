package com.coveo.challenge.calculator;

import com.coveo.challenge.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.math3.util.Precision.round;

@Component
public class NameScoreCalculator {

    public double calculate(String searchPrefix, String str) {
        String normalizedQuery = StringUtil.normalize(searchPrefix);
        String normalizedName = StringUtil.normalize(str);

        if(StringUtils.equals(normalizedQuery, normalizedName)) {
            return 1.0;
        }

        if(startsWith(normalizedName, normalizedQuery)) {
            String commonPrefix = getCommonPrefix(normalizedQuery, normalizedName);
            if (isNotBlank(commonPrefix)) {
                Double score = length(commonPrefix) / StringUtil.longestLength(normalizedQuery, normalizedName).doubleValue();
                return round(score, 2);
            }
        }

        return 0.0;
    }
}
