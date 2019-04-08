package com.coveo.challenge.util;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class StringUtilTest {

    @Test
    public void whenLongestLength_givenTwoStrings_thenshouldReturnLongestLength() {
        Integer actual = StringUtil.longestLength("New York", "Québec");
        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void whenLongestLength_givenNullStrings_thenShouldReturnZero() {
        Integer actual = StringUtil.longestLength(null, null);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void whenLongestLength_givenEmptyStrings_thenShouldReturnZero() {
        Integer actual = StringUtil.longestLength("", "");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void whenLongestLength_givenNullAndEmptyStrings_thenShouldReturnZero() {
        Integer actual = StringUtil.longestLength("", null);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void whenNormalize_givenString_thenShouldReturnNormalizedString() {
        String actual = StringUtil.normalize("Montréal-,'<]èàçéù");
        assertThat(actual).isEqualTo("MONTREALEACEU");
    }

    @Test
    public void whenNormalize_givenNullString_thenShouldReturnNormalizedString() {
        String actual = StringUtil.normalize(null);
        assertThat(actual).isEqualTo("");
    }

    @Test
    public void whenNormalize_givenEmptyString_thenShouldReturnNormalizedString() {
        String actual = StringUtil.normalize("");
        assertThat(actual).isEqualTo("");
    }

}