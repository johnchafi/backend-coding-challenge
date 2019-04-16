package com.coveo.challenge.controller;

import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.service.SuggestionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SuggestionsControllerTest {

    private static final String VALID_QUERY = "query";
    private static final Double VALID_LATITUDE = 51.34;
    private static final Double VALID_LONGITUDE = 123.98;

    @InjectMocks
    private SuggestionsController underTest;

    @Mock
    private SuggestionsService suggestionsService;

    @Test(expected = IOException.class)
    public void whenGetSuggestions_givenException_thenShouldThrowException() throws Exception {
        when(suggestionsService.call(VALID_QUERY, VALID_LATITUDE, VALID_LONGITUDE)).thenThrow(IOException.class);
        underTest.getSuggestions(VALID_QUERY, VALID_LATITUDE, VALID_LONGITUDE);
    }

    @Test
    public void whenGetSuggestions_givenValidParams_thenShouldCallSuggestionsService() throws Exception {
        Suggestions expected = mock(Suggestions.class);
        when(suggestionsService.call(VALID_QUERY, VALID_LATITUDE, VALID_LONGITUDE)).thenReturn(expected);

        ResponseEntity<Suggestions> actual = underTest.getSuggestions(VALID_QUERY, VALID_LATITUDE, VALID_LONGITUDE);

        assertThat(actual.getBody()).isEqualTo(expected);
        verify(suggestionsService).call(VALID_QUERY, VALID_LATITUDE, VALID_LONGITUDE);
    }
}

