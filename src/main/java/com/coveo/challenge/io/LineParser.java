package com.coveo.challenge.io;

public interface LineParser<T> {

    T parse(String line);
}
