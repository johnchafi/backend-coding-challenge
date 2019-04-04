package com.coveo.challenge.io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class ResourceProviderTest {

    public static final String RESOURCE_NOT_FOUND = "not_found.txt";
    public static final String RESOURCE_FOUND = "data/cities_canada-usa_test.tsv";

    private ResourceProvider underTest;


    @Before
    public void setUp() {
        underTest = new ResourceProvider();
    }

    @Test
    public void whenResourceAsStream_givenResourceNotFound_thenShouldReturnNull() {
        assertThat(underTest.resourceAsStream(RESOURCE_NOT_FOUND)).isNull();
    }

    @Test
    public void whenResourceAsStream_givenResource_thenShouldReturnExpected() {
        assertThat(underTest.resourceAsStream(RESOURCE_FOUND)).isNotNull();
    }

    @Test(expected = IOException.class)
    public void whenResourceAsString_givenResourceNotFound_thenShouldReturnNull() throws Exception {
        underTest.resourceAsString(RESOURCE_NOT_FOUND);
    }

    @Test
    public void whenResourceAsString_givenResource_thenShouldReturnExpected() throws Exception {
        assertThat(isNotBlank(underTest.resourceAsString(RESOURCE_FOUND))).isTrue();
    }

}

