package com.coveo.challenge.io;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ResourceProvider {

    public InputStream resourceAsStream(String filename) {
        return this.getClass().getClassLoader().getResourceAsStream(filename);
    }

    public String resourceAsString(String filename) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return IOUtils.resourceToString(filename, Charset.forName("UTF8"), classLoader);
    }

}
