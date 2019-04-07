package com.coveo.challenge.service;

import org.junit.Before;
import org.junit.Test;

public class SuggestionsServiceTest {

    private SuggestionsService underTest;

    @Before
    public void setUp() {
        underTest = new SuggestionsService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSearch_givenNullLatitude_thenShouldThrowException() throws Exception {
        underTest.call("query", null, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSearch_givenNullLongitude_thenShouldThrowException() throws Exception {
        underTest.call("query", 0.0, null);
    }


}

