package com.coveo.challenge.service;

import com.coveo.challenge.io.ResourceProvider;
import com.coveo.challenge.suggestion.SuggestionFinder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SuggestionsServiceTest {

    @InjectMocks
    private SuggestionsService underTest;

    @Mock
    private ResourceProvider resourceProvider;

    @Mock
    private SuggestionFinder suggestionFinder;

}

