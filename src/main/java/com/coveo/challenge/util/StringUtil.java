package com.coveo.challenge.util;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.normalizeSpace;
import static org.apache.commons.lang3.StringUtils.trimToNull;

public class StringUtil {

    public static int longestLength (String str1, String str2) {
        int length1 = length(str1);
        int length2 = length(str2);
        return length1 >= length2 ? length1 : length2;
    }

    public static String normalize(String str) {
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
