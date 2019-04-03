package com.coveo.challenge.controller;

import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.service.SuggestionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {

    private static final String ANY_QUERY = "query";
    private static final Double ANY_LATITUDE = 51.34;
    private static final Double ANY_LONGITUDE = 123.98;

    @InjectMocks
    private ApiController underTest;

    @Mock
    private SuggestionsService suggestionsService;

    @Test
    public void whenGetSuggestions_givenParams_thenShouldCallSuggestionsService() {
        Suggestions expected = Suggestions.builder().build();
        when(suggestionsService.search(ANY_QUERY, ANY_LATITUDE, ANY_LONGITUDE)).thenReturn(expected);

        Suggestions actual = underTest.getSuggestions(ANY_QUERY, ANY_LATITUDE, ANY_LONGITUDE);

        assertThat(actual).isEqualTo(expected);
        verify(suggestionsService).search(ANY_QUERY, ANY_LATITUDE, ANY_LONGITUDE);
    }
}

