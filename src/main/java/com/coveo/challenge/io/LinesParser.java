package com.coveo.challenge.io;

import com.coveo.challenge.model.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX;
import static org.apache.commons.lang3.StringUtils.split;

@Component
public class LinesParser {

    private static final String FILENAME = "data/cities_canada-usa.tsv";

    @Autowired
    private ResourceProvider resourceProvider;

    @Autowired
    private LineParser lineParser;

    private List<Suggestion> parse() throws IOException {
        String content = resourceProvider.resourceAsString(FILENAME);
        String[] lines = split(content, LINE_SEPARATOR_UNIX);
        return Arrays.stream(lines)
                .map(line -> suggestion(line))
                .filter(s -> s.getScore() > 0.0)
                .collect(toList());
    }

    private Suggestion suggestion(String line) {
        return lineParser.parse(line);
    }
}
