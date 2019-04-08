package com.coveo.challenge.service;

import com.coveo.challenge.io.ResourceProvider;
import com.coveo.challenge.model.Suggestion;
import com.coveo.challenge.model.Suggestions;
import com.coveo.challenge.suggestion.SuggestionFinder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SuggestionsServiceTest {

    private static final String CITIES_FILENAME = "data/cities_canada-usa.tsv";
    private static final String HEADER = "header";
    private static final String LINE_1 = "line1";
    private static final String LINE_2 = "line2";
    private static final String LINE_3 = "line3";
    private static final String CONTENT = HEADER + "\n" + LINE_1 + "\n" + LINE_2 + "\n" + LINE_3;
    private static final String QUERY = "query";
    private static final Double LATITUDE = 45.649719;
    private static final Double LONGITUDE = -71.7896;

    @InjectMocks
    private SuggestionsService underTest;

    @Mock
    private ResourceProvider resourceProvider;

    @Mock
    private SuggestionFinder suggestionFinder;

    @Test
    public void whenCall_givenSuggestions_thenShouldReturnEmpty() throws Exception {
        Suggestion suggestion1 = Suggestion.builder().score(0.0).build();
        Suggestion suggestion2 = Suggestion.builder().score(0.5).build();
        Suggestion suggestion3 = Suggestion.builder().score(1.0).build();
        Suggestions expected = Suggestions.builder().suggestions(Arrays.asList(suggestion3, suggestion2)).build();

        when(resourceProvider.resourceAsString(CITIES_FILENAME)).thenReturn(CONTENT);
        when(suggestionFinder.getSuggestion(LINE_1, QUERY, LATITUDE, LONGITUDE)).thenReturn(suggestion1);
        when(suggestionFinder.getSuggestion(LINE_2, QUERY, LATITUDE, LONGITUDE)).thenReturn(suggestion2);
        when(suggestionFinder.getSuggestion(LINE_3, QUERY, LATITUDE, LONGITUDE)).thenReturn(suggestion3);

        Suggestions actual = underTest.call(QUERY, LATITUDE, LONGITUDE);

        assertThat(actual).isEqualTo(expected);

        verify(resourceProvider).resourceAsString(CITIES_FILENAME);

        verify(suggestionFinder, never()).getSuggestion(HEADER, QUERY, LATITUDE, LONGITUDE);
        verify(suggestionFinder).getSuggestion(LINE_1, QUERY, LATITUDE, LONGITUDE);
        verify(suggestionFinder).getSuggestion(LINE_2, QUERY, LATITUDE, LONGITUDE);
        verify(suggestionFinder).getSuggestion(LINE_3, QUERY, LATITUDE, LONGITUDE);
    }

    @Test(expected = IOException.class)
    public void whenCall_givenResourceProviderError_thenShouldThrowException() throws Exception {
        when(resourceProvider.resourceAsString(CITIES_FILENAME)).thenThrow(IOException.class);
        underTest.call(QUERY, LATITUDE, LONGITUDE);
    }

}

