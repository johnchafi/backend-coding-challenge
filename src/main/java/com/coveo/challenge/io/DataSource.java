package com.coveo.challenge.io;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX;
import static org.apache.commons.lang3.StringUtils.split;

public abstract class DataSource<T> {

    @Autowired
    private ResourceProvider resourceProvider;

    private List<T> elements;

    public List<T> getElements() throws IOException {
        if(elements == null) {
            elements = Arrays.stream(lines())
                    .skip(1)
                    .map(line -> getLineParser().parse(line))
                    .collect(Collectors.toList());
        }
        return elements;
    }

    private String[] lines() throws IOException {
        String content = resourceProvider.resourceAsString(getFileName());
        return split(content, LINE_SEPARATOR_UNIX);
    }

    protected abstract String getFileName();

    protected abstract LineParser<T> getLineParser();
}
